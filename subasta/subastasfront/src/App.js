import React, { useEffect, useState } from 'react';
import logo from './logo.svg';
import './App.css';
import Navbar from './components/Navbar.js';

const App = () => {

  return (
    <div className="App">
      <Navbar/>
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <div>
        </div>
        {auctions.map(
          auction => <div key={auction.id}>
            {auction.intialDate} to {auction.finalDate}
          </div>
        )}
      </header>
    </div>
  );
}

export default App;
