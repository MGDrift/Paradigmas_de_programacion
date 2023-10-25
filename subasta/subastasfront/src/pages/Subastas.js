import React from 'react';

const Subastas = () => {
    const [auctions, setAuctions] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('v1/auction/list')
        .then(response => response.json())
        .then(data => {
            setAuctions(data);
            setLoading(false);
        })
    }, []);

    if (loading) {
        return <p>Loading...</p>;
    }

    return (
        <table>
            <thead>
                <tr>
                    <th>Fecha inicial</th>
                    <th>Fecha final</th>
                    <th>Serial del producto</th>
                    <th>Vendedor</th>
                    <th>Comprador</th>
                </tr>
            </thead>
            <tbody>
                {auctions.map((auction, index) => (
                <tr key={index}>
                    <td>{auction.initialDate}</td>
                    <td>{auction.finalDate}</td>
                    <td>{auction.serialProduct}</td>
                    <td>{auction.creatorDocument}</td>
                    <td>{auction.buyerDocument}</td>
                </tr>
                ))}
            </tbody>
        </table>
    )
}

export default Subastas;