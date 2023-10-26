import React, {useState, useEffect} from 'react';

const ElegirPersona = ({setPerson}) => {
    const [people, setPeople] = useState([]);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        setLoading(true);

        fetch('v1/person/list')
        .then(response => response.json())
        .then(data => {
            setPeople(data);
            setLoading(false);
        })
    }, []);

    const handleClick = (person) => {
        setPerson(person)
    }

    if (loading) {
        return <p>Loading...</p>;
    }

    return (
        <div className='Content'>
            <table className="table">
                <thead>
                    <tr>
                        <th scope="col">Documento</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Apellido</th>
                        <th scope="col"></th>
                    </tr>
                </thead>
                <tbody>
                    {people.map((person, index) => (
                        <tr key={index}>
                            <td>{person.document}</td>
                            <td>{person.name}</td>
                            <td>{person.lastName}</td>
                            <td>
                                <div className="row">
                                    <div className="col-3"></div>
                                    <button type="submit" className="btn btn-primary col-3" onClick={() => handleClick(person)}>Elegir</button>
                                    <div className="col-3"></div>
                                </div>
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        </div>
    )
    
}

export default ElegirPersona;