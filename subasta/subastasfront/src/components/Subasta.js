import React, {useRef} from 'react';
import Moment from 'moment';

const Subasta = ({subasta, people, products, setRefresh, person}) => {
    Moment.locale('en')
    const inputRef = useRef(null)

    const handleSubmit = (event) => {
        event.preventDefault()
        fetch('v1/product/change-value?serialProduct=' + subasta.serialProduct + '&value=' + inputRef.current.value)
        .then(response => response.status)
        .then(status => {
            if (status === 200) {
                alert('Su puja ha sido aceptada!')
                setRefresh(prevState => !prevState);
            } else if (status === 404) {
                alert('No se encontró el producto a pujar.')
            } else {
                alert('Lo sentimos. Su puja NO ha sido aceptada.')
            }
        })
        fetch('v1/auction/change-buyer?id=' + subasta.id + '&buyerDocument=' + person.document)
        .then(response => response.status)
        .then(status => {
            if (status === 404) {
                alert('La subasta ya no existe!')
            }
        })
    }

    return (
        <tr key={subasta.id}>
            <td>{Moment(subasta.initialDate).format('DD-MM-YYYY')}</td>
            <td>{Moment(subasta.finalDate).format('DD-MM-YYYY')}</td>
            <td>{products.find(product => product.serialProduct === subasta.serialProduct).name}</td>
            <td>${products.find(product => product.serialProduct === subasta.serialProduct).value}</td>
            <td>{people.find(person => person.document === subasta.creatorDocument).name}</td>
            <td>{people.find(person => person.document === subasta.buyerDocument).name}</td>
            <td>
                <form onSubmit={handleSubmit}>
                    <div className="row">
                        <input type="number" className="form-control col" id="value" placeholder="Introduzca su valor" ref={inputRef}/>
                        <div className="col-1"></div>
                        <button type="submit" className="btn btn-primary col-3">Pujar</button>
                    </div>
                </form>
            </td>
        </tr>
    )
}

export default Subasta;