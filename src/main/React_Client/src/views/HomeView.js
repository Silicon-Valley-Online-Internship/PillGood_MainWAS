import React, { Fragment } from 'react';
import './HomeView.css';
import Slider from "react-slick";
import InputComponent from "../component/InputComponent";
import OutputComponent from "../component/OutputComponent";

class Home extends React.Component {
    render() {
        const settings = {
            dots: true,
            infinite: true,
            speed: 500,
            slidesToShow: 1,
            slidesToScroll: 1
        };
        return (
            <div className="cover-container d-flex h-100 p-3 mx-auto flex-column text-center">
                <meta charSet="utf-8" />
                <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
                <meta name="description" content />
                <meta name="author" content />
                <link rel="icon" href="/docs/4.0/assets/img/favicons/favicon.ico" />
                <title>Cover Template for Bootstrap</title>
                <link rel="canonical" href="https://getbootstrap.com/docs/4.0/examples/cover/" />
                {/* Bootstrap core CSS */}
                <link href="../../dist/css/bootstrap.min.css" rel="stylesheet" />
                {/* Custom styles for this template */}
                <link href="cover.css" rel="stylesheet" />
                <header className="masthead mb-auto">
                    <div className="inner">
                        <h3 className="masthead-brand">MeDitecter</h3>
                        <nav className="nav nav-masthead justify-content-center">
                            <a className="nav-link active" href="#">Home</a>
                            <a className="nav-link" href="#">Features</a>
                            <a className="nav-link" href="#">Contact</a>
                        </nav>
                    </div>
                </header>
                <main role="main" className="inner cover">
                    <h1 className="cover-heading">Easily search for the medicine <br/>in photos.</h1>
                    <p className="lead">Medetector analyzes the formulation, shape, and identification of the pill and tells you what kind of medicine it is. <br/>Let's protect our health by keeping and taking the right medication.</p>
                    <p className="lead">
                    </p>
                    <div>
                        <Slider {...settings}>
                            <div>
                               <InputComponent/>
                            </div>
                            <div>
                                <OutputComponent/>
                            </div>
                        </Slider>
                    </div>
                </main>
                <footer className="mastfoot mt-auto">
                    <div className="inner">
                        <p>Source Code for <a href="https://github.com/Silicon-Valley-Online-Internship/">Github</a><br/>made by YoungSeok-Choi, SeoHyeon-Ryu, SeongJin-Ahn and Chan-Park.</p>
                    </div>
                </footer>
            </div>
        )
    };
}

export default Home;