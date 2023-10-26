import React, {useState, useEffect} from 'react';
import Moment from 'moment';

const SubastasParticipadas = ({person}) => {
    const [auctions, setAuctions] = useState([]);
    const [people, setPeople] = useState([]);
    const [products, setProducts] = useState([]);
    const [loadingAuctions, setLoadingAuctions] = useState(false);
    const [loadingPeople, setLoadingPeople] = useState(false);
    const [loadingProducts, setLoadingProducts] = useState(false);

    useEffect(() => {
        setLoadingAuctions(true);
        setLoadingPeople(true);
        setLoadingProducts(true);

        fetch('v1/auction/list?buyerDocument=' + person.document)
        .then(response => response.json())
        .then(data => {
            setAuctions(data);
            setLoadingAuctions(false);
        })

        fetch('v1/person/list')
        .then(response => response.json())
        .then(data => {
            setPeople(data);
            setLoadingPeople(false);
        })

        fetch('v1/product/list')
        .then(response => response.json())
        .then(data => {
            setProducts(data);
            setLoadingProducts(false);
        })
    }, []);

    if (loadingAuctions || loadingPeople || loadingProducts) {
        return <p>Loading...</p>;
    }

    return (
        <div className='Content'>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Fecha inicial</th>
                        <th scope="col">Fecha final</th>
                        <th scope="col">Producto</th>
                        <th scope="col">Valor Actual</th>
                        <th scope="col">Vendedor</th>
                        <th scope="col">Comprador</th>
                    </tr>
                </thead>
                <tbody>
                    {auctions.map((auction, index) => (
                        <tr key={auction.id}>
                        <td>{Moment(auction.initialDate).format('DD-MM-YYYY')}</td>
                        <td>{Moment(auction.finalDate).format('DD-MM-YYYY')}</td>
                        <td>{products.find(product => product.serialProduct === auction.serialProduct).name}</td>
                        <td>${products.find(product => product.serialProduct === auction.serialProduct).value}</td>
                        <td>{people.find(person => person.document === auction.creatorDocument).name}</td>
                        <td>{people.find(person => person.document === auction.buyerDocument).name}</td>
                    </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
    
}

export default SubastasParticipadas;