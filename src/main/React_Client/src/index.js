import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import Home from "views/HomeView.js";
import reportWebVitals from './reportWebVitals';
import 'semantic-ui-css/semantic.min.css'
import 'bootstrap/dist/css/bootstrap.min.css';
import {BrowserRouter, Redirect, Route, Switch} from "react-router-dom";
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";

ReactDOM.render(
    // <React.StrictMode>
    //     <App/>
    // </React.StrictMode>,
    <BrowserRouter>
        <Switch>
            <Route
                path="/"
                exact
                render={props => <Home {...props} />}
            />
            <Route
                path="/home"
                exact
                render={props => <Home {...props} />}
            />
            <Redirect to="/" />
        </Switch>
    </BrowserRouter>,
    document.getElementById('root')
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
