import React, {useEffect, useState} from 'react';
import { BrowserRouter, Routes, Route } from "react-router-dom";
import './App.css';
import Navbar from './components/Navbar.js';
import Subastas from './pages/Subastas.js';
import CrearSubasta from './pages/CrearSubasta.js';
import MisSubastasPublicadas from './pages/MisSubastasPublicadas.js';
import SubastasParticipadas from './pages/SubastasParticipadas.js';
import ElegirPersona from './pages/ElegirPersona.js';

const App = () => {
  const [person, setPerson] = useState([]);

  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Navbar person={person}/>}>  
            <Route path="/" element={<Subastas person={person}/>} />
            <Route path="/crear-subasta" element={<CrearSubasta person={person}/>} />
            <Route path="/mis-subastas-publicadas" element={<MisSubastasPublicadas person={person}/>} />
            <Route path="/subastas-participadas" element={<SubastasParticipadas person={person}/>} />
            <Route path="/elegir-persona" element={<ElegirPersona setPerson={setPerson} />} />
          </Route>
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
