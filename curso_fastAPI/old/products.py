from fastapi import APIRouter, HTTPException

from pydantic import BaseModel

router = APIRouter(prefix="/products",
                   tags=["products"],
                   responses={404: {"message": "No encontrado"}})

class Product(BaseModel):
    id: int
    name: str
    price: int
    category: str


product_list = [Product(id = 1,name='servilleta', price= 55, category="house"),
             Product(id = 2,name='Frezer', price= 344, category= 'clean'),
             Product(id = 3,name='razor', price=23, category= 'electronic')]



#operaciones

@router.get("/")
async def products():
    return product_list

@router.get("/{id}")
async def products(id: int):
    return search_product(2)

@router.put("/")
async def products(product: Product):
    for index, saved_product in enumerate(product_list):
        if saved_product.id == product.id:
            product_list[index] = product
            raise HTTPException(status_code=201, detail= "producto actualizado")
    

@router.delete('/{id}')
async def user(id: int):
    for index, saved_product in enumerate(product_list):
        if saved_product.id == id:
            del product_list[index]
            raise HTTPException(status_code=200, detail= "producto eliminado correctamente")
        else:
            raise HTTPException(status_code=404, detail="este producto no existe")

#permite buscar un producto en la lista de productos
def search_product(id: int):
    products = filter(lambda product: product.id == id, product_list)
    try:
        return list(products)[0]
    except:
        raise HTTPException(status_code = 204, detail="No se ha encontrado este producto")

