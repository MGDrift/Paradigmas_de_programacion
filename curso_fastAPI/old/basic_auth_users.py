from fastapi import APIRouter, Depends, HTTPException, status
from pydantic import BaseModel
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm


router = APIRouter(prefix="/basicauth",
                   tags=["basicauth"],
                   responses={status.HTTP_404_NOT_FOUND: {"message": "No encontrado"}})

oauth2 = OAuth2PasswordBearer(tokenUrl="login")


class User(BaseModel):
    username: str
    full_name: str
    email: str
    disabled: bool

class UserDB(User):
    password: str

users_db = {
    "alejo": {
        "username": "alejo",
        "full_name": "Alejandro Hernandez",
        "email": "aleajandrohernandez23@gmail.com",
        "disabled": False,
        "password": "pepito123"
    },
    "alejo2": {
        "username": "alejo2",
        "full_name": "Alejandro fernandez",
        "email": "alejoplus3452@gmail.com",
        "disabled": True,
        "password": "123456"
    }
}

def search_user_db(username: str):
    if username in users_db:
        return UserDB(**users_db[username])


def search_user(username: str):
    if username in users_db:
        return User(**users_db[username])

async def current_user(token: str = Depends(oauth2)):
    user = search_user(token)

    if not user:
        raise HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED, 
            detail="Credenciales invalidas",
            headers={"www-Authenticate": "Bearer"})
    
    if user.disabled:
        raise HTTPException(
            status_code=status.HTTP_400_BAD_REQUEST, 
            detail="usuario inactivo")
    
    return user


@router.post("/login")
async def login(form: OAuth2PasswordRequestForm = Depends()):
    user_db = users_db.get(form.username)
    if not user_db:
        raise HTTPException(
            status_code = status.HTTP_400_BAD_REQUEST, detail = "el usuario no es correcto")
    
    user = search_user_db(form.username)
    if not form.password == user.password:
        raise HTTPException(
            status_code = status.HTTP_400_BAD_REQUEST, detail="la contraseña es incorrecta")
    
    return {"access_token": user.username, "token_type": "bearer"}

@router.get("/users/me")                                                               
async def me(user: User = Depends(current_user)):
    return user
