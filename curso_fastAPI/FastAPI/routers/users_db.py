from fastapi import APIRouter, HTTPException, status, Depends
from db.models.user import User
from db.client import db_client
from db.schemas.user import user_schema, users_schema
from bson import ObjectId
from fastapi.responses import RedirectResponse 
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm

oauth2 = OAuth2PasswordBearer(tokenUrl="login")


router = APIRouter(prefix="/userdb",tags=["userdb"],
                   responses={status.HTTP_404_NOT_FOUND: {"message": "No encontrado"}})


@router.get('/', response_model=list[User])
async def users():
    return users_schema(db_client.local.users.find())


@router.get('/')
async def user(id: str):
    return search_user("_id", ObjectId(id))

#esta funcion crea un usuario en la base de datos
@router.post("/", response_model = User, status_code=status.HTTP_201_CREATED)
async def user(user: User):
    if type(search_user("email", user.email )) == User:    
       raise HTTPException(
           status_code= status.HTTP_404_NOT_FOUND, detail="Este usuario ya existe")
    user_dict = dict(user)
    del user_dict["id"]
    id = db_client.local.users.insert_one(user_dict).inserted_id
    new_user = user_schema(db_client.local.users.find_one({"_id":id}))

    return RedirectResponse("/templates/payment.html")

@router.post("/login")
async def login(form: OAuth2PasswordRequestForm = Depends()):

    user_db = db_client.local.users.find_one({"username": form.username})
    if not user_db:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST, detail="El usuario no es correcto")

    user_dbP = db_client.local.users.find_one({"password": form.password})
    if not form.password == user_dbP["password"]:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST, detail="la contraseña no es correcta")
    
    
    


@router.delete("/{id}", status_code = status.HTTP_204_NO_CONTENT)
async def user(id: str):

    found = db_client.local.users.find_one_and_delete({"_id": ObjectId(id)})

    if not found:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="este usuario no existe")



def search_user(field: str, key):
    try:
        user = db_client.local.users.find_one({field: key})
        return User(**user_schema(user)) 
    except:
        return HTTPException(
            status_code = status.HTTP_204_NO_CONTENT, detail="No se ha encontrado este usuario")


