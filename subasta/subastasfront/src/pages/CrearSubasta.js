import React, {useRef} from 'react';

const CrearSubasta = ({person}) => {
    const auction = useRef({});
    const product = useRef({});

    const handleAuctionChange = (event) => {
        auction.current = {
            ...auction,
            [event.target.name]: event.target.value
        }
    }

    const handleProductChange = (event) => {
        product.current = {
            ...product,
            [event.target.name]: event.target.value
        }
    }

    const handleSubmit = (event) => {
        event.preventDefault()
        fetch('v1/product', {
            method: 'POST',
            body: JSON.stringify(product),
            headers: {
                'Content-Type': 'application/json'
            }
        })
        .then(response => response.json())
        .then(data => {
            auction.current = {
                ...auction,
                'serialProduct': data.serialProduct,
                'creatorDocument': person.document
            }

            fetch('v1/auction', {
                method: 'POST',
                body: JSON.stringify(auction),
                headers: {
                    'Content-Type': 'application/json'
                }
            })
            .then(response => response.status)
            .then(status => {
                if (status === 200) {
                    alert('Subasta creada satisfactoriamente!')
                } else {
                    alert('Se presentó un error al crear la subasta.')
                }
            })
        })
    }

    return (
        <>
            <br/>
            <h1>Creación de subasta</h1>
            <form className="Content" onSubmit={handleSubmit}>
                <div className="form-group row">
                    <div className='col-6'>
                        <input type="date" className="form-control" id="initialDate" name='initialDate' placeholder="Ingresa la fecha de inicio" onChange={handleAuctionChange}/>
                    </div>
                    <div className='col-6'>
                        <input type="date" className="form-control" id="finalDate" name="finalDate" placeholder="Ingresa la fecha final" onChange={handleAuctionChange}/>
                    </div>
                </div>
                <br/>
                <div className="form-group row">
                    <div className='col-6'>
                        <input type="text" className="form-control" id="name" name="name" placeholder="Ingresa el nombre del producto" onChange={handleProductChange}/>
                    </div>
                    <div className='col-6'>
                        <input type="text" className="form-control" id="value" name="value" placeholder="Ingresa el valor del producto" onChange={handleProductChange}/>
                    </div>
                </div>
                <br/>
                <div className="form-group">
                    <div className='col-12'>
                        <label htmlFor="description">Descripción del producto:</label>
                        <textarea className="form-control" id="description" name="description" rows="3" onChange={handleProductChange}></textarea>
                    </div>
                </div>
                <br/>
                <button type="submit" className="btn btn-primary">Crear</button>
            </form>
        </>
    );
}
  
export default CrearSubasta;