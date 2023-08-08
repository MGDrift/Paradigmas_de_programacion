from fastapi import APIRouter, Depends, HTTPException, status
from pydantic import BaseModel
from fastapi.security import OAuth2PasswordBearer, OAuth2PasswordRequestForm
from jose import jwt, JWTError
from passlib.context import CryptContext
from datetime import datetime, timedelta


ALGORITHM = "HS256" 
ACCES_TOKEN_DURATION = 80
SECRET = "ba271c4087bc1474bf7da2c283369355ddcad524167443ec5ad9e001acc352b8"

router = APIRouter(tags=["Aunteticacion encryptada"])

oauth2 = OAuth2PasswordBearer(tokenUrl="login")

crypt = CryptContext(schemes=["bcrypt"])

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
        "password": "$2a$12$nuc3.tPBspg3qdO1RFqX0OyVAAKxn7P2/IjeVcI6s2vqB0iQtgJz2"
    },
    "alejo2": {
        "username": "alejo2",
        "full_name": "Alejandro fernandez",
        "email": "alejoplus3452@gmail.com",
        "disabled": True,
        "password": "$2a$12$NQWxeijI/lycTFMJrqv8FOvEhFz2NIK75ecyTdtKr2Mv20jlqy.ei"
    }
}


def search_user_db(username: str):
    if username in users_db:
        return UserDB(**users_db[username])
                      
def search_user(username: str):
    if username in users_db:
        return User(**users_db[username])

async def auth_user(token: str = Depends(oauth2)):
    exception = HTTPException(
            status_code=status.HTTP_401_UNAUTHORIZED, 
            detail="Credenciales invalidas",
            headers={"www-Authenticate": "Bearer"})
    try:
        username = jwt.decode(token, SECRET,algorithms=[ALGORITHM]).get("sub")
        if username is None:
             raise exception

    except JWTError:
         raise exception

    return search_user(username)
       

async def current_user(user: User = Depends(auth_user)):    
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

    if not crypt.verify(form.password, user.password):
        raise HTTPException(
            status_code = status.HTTP_400_BAD_REQUEST, detail="la contraseña es incorrecta")

    access_token = {"sub": user.username, 
                   "exp":datetime.utcnow() + timedelta(minutes=ACCES_TOKEN_DURATION)}

    return {"access_token": jwt.encode(access_token,SECRET,algorithm=ALGORITHM), "token_type": "bearer"}


@router.get("/users/me")                                                               
async def me(user: User = Depends(current_user)):
    return user
