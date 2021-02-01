import React, { Fragment } from 'react';

import {Col, Container, Row} from "reactstrap";
import InputComponent from "component/InputComponent";
import OutputComponent from "component/OutputComponent";

class HomeView extends React.Component {
    render() {
        return (
            <main className="my-5 py-5">
                <InputComponent></InputComponent>
            </main>
        )
    };
}

export default HomeView;