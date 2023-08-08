from fastapi import APIRouter, HTTPException, status, Depends
from db.models.user import User
from db.client import db_client
from db.schemas.user import user_schema, users_schema
from bson import ObjectId
from fastapi.responses import RedirectResponse 



router = APIRouter(prefix="/userdb",tags=["userdb"],
                   responses={status.HTTP_404_NOT_FOUND: {"message": "No encontrado"}})


@router.get('/', response_model=list[User])
async def users():
    return users_schema(db_client.local.users.find())


@router.get('/{id}')
async def user(id: str):
    return search_user("_id", ObjectId(id))

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

@router.post("/login/")
async def login(user: User):
    # Busca el usuario en la base de datos por su nombre de usuario
    stored_user = db_client.local.users.find_one({"username": user.username})

    if not stored_user:
        raise HTTPException(status_code=404, detail="Usuario no encontrado")

    # Comprueba si la contraseña coincide
    if user.password != stored_user["password"]:
        raise HTTPException(status_code=401, detail="Contraseña incorrecta")

    # Aquí puedes realizar otras acciones de verificación, como verificar roles, etc.

    return {"mensaje": "Inicio de sesión exitoso"}

   

@router.put('/', response_model=User)
async def user(user: User):
    
    user_dict = dict(user)
    del user_dict["id"]
    
    try:
        db_client.local.users.find_one_and_replace(
            {"_id": ObjectId(user.id)}, user_dict)
    except:
        raise HTTPException(status_code=status.HTTP_404_NOT_FOUND, detail="No se encontro el usuario")
    
    return search_user("_id", ObjectId(user.id))


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


