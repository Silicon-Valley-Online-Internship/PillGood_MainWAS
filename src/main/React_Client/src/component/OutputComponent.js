import React, {Component} from "react";
import UploadService from "../service/upload-files.service";

export default class OutputComponent extends Component {
    constructor(props) {
        super(props);

        this.state = {
            PillInfos: [],
            loading: false
        };
    }

    componentDidMount() {
        UploadService.getFiles().then((response) => {
            this.setState({
                PillInfos : response.data,
            });
        });
    }
    render() {
        return (
            <div>
                <div>
                    <h1 className = "text-center"> Pill Information</h1>
                    <table className = "table table-striped">
                        <thead>
                        <tr>

                            <td> Pill id</td>
                            <td> Pill name</td>
                            <td> Pill effect </td>
                            <td> Pill company </td>
                            <td> Pill engrave </td>
                            <td> Pill sideeffect</td>
                            <td> Pill url</td>

                        </tr>

                        </thead>
                        {!this.state.loading ?
                            (
                                null
                            ) :
                            (
                                <tbody>
                                {
                                    Object.keys(this.state.NutInfos).map((item, i) => (
                                        <tr key={{i}}>
                                            <td>{this.state.PillInfos[i].id}</td>
                                            <td>{this.state.PillInfos[i].pillname}</td>
                                            <td>{this.state.PillInfos[i].effect}</td>
                                            <td>{this.state.PillInfos[i].company}</td>
                                            <td>{this.state.PillInfos[i].engrave}</td>
                                            <td>{this.state.PillInfos[i].sideeffect}</td>
                                            <td>{this.state.PillInfos[i].url}</td>
                                        </tr>
                                    ))

                                }
                                </tbody>
                            )}

                    </table>
                </div>
            </div>
        );
    }
}