import React, {Component} from "react";
import UploadService from "../service/upload-files.service";
import Pill_img from "assets/img/pills_example01.jpg";
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
        /*이미지 객체 생성*/
        /*파일 받으면.. src에 해당그림 url넣는거...함수 짜야될듯....?*/
        let pill_img = null;
        pill_img =<img src = {Pill_img} style={{width: 300}}/>

        return (
            <div>
                {pill_img}
                <div>
                    <h1 className = "text-center"> Pill Information</h1>
                    <table className = "table table-striped" style={{color:"white"}} >
                        <thead>
                        <tr>

                            <td> id</td>
                            <td> name</td>
                            <td> effect </td>
                            <td> company </td>
                            <td> engrave </td>
                            <td> sideeffect</td>
                            <td> url</td>

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