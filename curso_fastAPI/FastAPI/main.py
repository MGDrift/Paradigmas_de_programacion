from fastapi import FastAPI, Request
from routers import users_db, login_db
from fastapi.staticfiles import StaticFiles
from fastapi.responses import HTMLResponse
from fastapi.templating import Jinja2Templates
#products, users, basic_auth_users,jwt_auth_users,
app = FastAPI()

#Routers 
#app.include_router(products.router)
#app.include_router(users.router)
app.include_router(users_db.router)
app.include_router(login_db.router)


#app.include_router(basic_auth_users.router)
#app.include_router(jwt_auth_users.router)
app.mount("/templates", StaticFiles(directory="templates"), name="templates")
app.mount("/static", StaticFiles(directory="static"), name="static")

#Funciones
templates = Jinja2Templates(directory="templates")  # Asegúrate de tener la carpeta "templates" con el archivo "index.html"

@app.get("/", response_class=HTMLResponse)
async def read_root(request: Request):  
    return templates.TemplateResponse("welcome.html", {"request": request})



