from fastapi import APIRouter, HTTPException, status, Depends
from db.client import db_client
from fastapi.responses import RedirectResponse 
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm
from db.schemas.user import user_schema, users_schema
from db.models.user import User

router = APIRouter(tags=["logindb"],
                   responses={status.HTTP_404_NOT_FOUND: {"message": "No encontrado"}})

oauth2 = OAuth2PasswordBearer(tokenUrl="login")


@router.post('/login')
async def login(form: OAuth2PasswordRequestForm = Depends()):

    user_db = db_client.local.users.find_one({"username": form.username})
    if not user_db:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST, detail="El usuario no es correcto")

    user_dbP = db_client.local.users.find_one({"password": form.password})
    if not user_dbP:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST, detail="la contraseña no es correcta")
    
    #return RedirectResponse("/templates/video.html")
    
def search_user(field: str, key):
    try:
        user = db_client.local.users.find_one({field: key})
        return User(**user_schema(user)) 
    except:
        return HTTPException(
            status_code = status.HTTP_204_NO_CONTENT, detail="No se ha encontrado este usuario")
