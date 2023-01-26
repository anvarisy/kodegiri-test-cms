import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import reportWebVitals from './reportWebVitals';
import 'bootstrap/dist/css/bootstrap.css';
import "primereact/resources/themes/lara-light-indigo/theme.css";  //theme
import "primereact/resources/primereact.min.css";                  //core css
import "primeicons/primeicons.css";                                //icons
import { Route, BrowserRouter, Routes } from 'react-router-dom'
import Home from './Home';
import ErrorPage from './ErrorPage';
import Company from './Company';
import { Transaction } from './Transaction';

const routs = (
  < BrowserRouter >
        <Routes>
           <Route path="/" element={<Home />} />
           <Route path="/login" element={<App/>} />
           <Route path="/company" element={<Company/>} />
           <Route path="/transaction" element={<Transaction/>} />
           <Route path="*" element={<ErrorPage/>} />
        </Routes>
  </ BrowserRouter >
);
const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(routs)
// const root = ReactDOM.createRoot(document.getElementById('root'));
// root.render(
//   // <React.StrictMode>
//   //   <App />
//   // </React.StrictMode>
//   routs
// );

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
