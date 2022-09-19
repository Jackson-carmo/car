import { useEffect, useState } from "react";


function Table(){
    const [car , setCar ] = useState([]);

    useEffect(() => {
        fetch("http://localhost:8080/listar")
        .then(response => response.json())
        .then(response_convert => setCar(response_convert));
    },[]);

    return (
        <table className="table">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Nome</th>
                    <th>Marcar</th>
                    <th>Slecionar</th>
                </tr>
            </thead>
            <tbody>
                <tr>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td></td>
                </tr>
            </tbody>
        </table>
    )
}
export default Table;