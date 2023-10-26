import React from 'react';
import { Outlet, Link } from "react-router-dom";

const Navbar = ({person}) => {
  return (
    <>
      <nav className="navbar navbar-expand-lg navbar-light bg-light">
        <Link className="navbar-brand" to="/">Subastas</Link>
        <div className="collapse navbar-collapse" id="navbar">
            <ul className="navbar-nav mr-auto">
                <li className="nav-item">
                    <Link className="nav-link" to="/mis-subastas-publicadas">Mis subastas publicadas</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/subastas-participadas">Subastas participadas</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/crear-subasta">Crear producto</Link>
                </li>
                <li className="nav-item">
                    <Link className="nav-link" to="/elegir-persona">Elegir persona</Link>
                </li>
            </ul>
            { person.name &&
                <span className="navbar-text">
                    Hola {person.name}!
                </span>
            }
        </div>
    </nav>

      <Outlet />
    </>
  );
}

export default Navbar;
