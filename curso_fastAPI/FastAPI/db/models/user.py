from pydantic import BaseModel
#pydantic permite gestionar modelos 

class User(BaseModel):
    id: str | None = None
    username : str
    email: str
    password: str



