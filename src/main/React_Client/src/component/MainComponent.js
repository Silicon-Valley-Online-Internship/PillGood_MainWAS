import React, {Component} from "react";
import UploadService from "../service/upload-files.service";
import axios from "axios";

export default class MainComponent extends Component {
    constructor(props) {
        super(props);
        this.selectFile = this.selectFile.bind(this);
        this.upload = this.upload.bind(this);

        this.state = {
            selectedFiles: undefined,
            currentFile: undefined,
            progress: 0,
            message: "",
            NutInfos: [],
            loading: false
        };
    }

    componentDidMount() {
        UploadService.getFiles().then((response) => {
            this.setState({
                NutInfos : response.data,
            });
        });
    }

    selectFile(event)
    {
        event.preventDefault();
        let reader = new FileReader();
        let file = event.target.files[0];
        reader.onloadend = () => {
            this.setState({
                selectedFiles: event.target.files,
                file : file,
                previewURL : reader.result
            })
        }
        reader.readAsDataURL(file);
    }

    upload()
    {
        let currentFile = this.state.selectedFiles[0];

        this.setState({
            progress: 0,
            currentFile: currentFile,
        });

        UploadService.upload(currentFile, (event) => {
            this.setState({
                progress: Math.round((100 * event.loaded) / event.total),
            });
        })
            .then((response) => {
                var test = JSON.stringify((response))

                this.state.NutInfos.push(response)
                this.setState({
                    NutInfos: this.state.NutInfos,
                    message: response.data.message,
                });

                return UploadService.getFiles();
            })

            .catch(() => {
                this.setState({
                    progress: 0,
                    message: "Could not upload the file!",
                    currentFile: undefined,
                });
            }).finally(() => {

                this.setState({
                    loading:true,
                })
        });

        this.setState({
            selectedFiles: undefined,
        });
    }

    render() {
        const {
            selectedFiles,
            currentFile,
            progress,
            message,
        } = this.state;

        let profile_preview = null;
        if(this.state.file !== ''){
            profile_preview = <img className='profile_preview' src={this.state.previewURL}></img>
        }
        return (
            <div>
                {currentFile && (
                    <div className="progress">
                        <div
                            className="progress-bar progress-bar-info progress-bar-striped"
                            role="progressbar"
                            aria-valuenow={progress}
                            aria-valuemin="0"
                            aria-valuemax="100"
                            style={{ width: progress + "%" }}
                        >
                            {progress}%
                        </div>
                    </div>
                )}

                <label className="btn btn-default">
                    <input type="file"
                           accept='image/jpg'
                           name='profile_img'
                           onChange={this.selectFile} />
                    {/*업로드 버튼*/}
                    <button className="btn btn-success"
                            disabled={!selectedFiles}
                            onClick={this.upload}
                    >
                        Upload
                    </button>
                    {profile_preview}
                </label>
                <div className="alert alert-light" role="alert">
                    {message}
                </div>

                <div>
                    <h1 className = "text-center"> Food Information</h1>
                    <table className = "table table-striped">
                        <thead>
                        <tr>

                            <td> Food id</td>
                            <td> Food name</td>
                            <td> Calories</td>
                            <td> Carbohydrate</td>
                            <td> Protein</td>
                            <td> Fat</td>

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
                                            <td>{this.state.NutInfos[i].id}</td>
                                            <td>{this.state.NutInfos[i].foodname}</td>
                                            <td>{this.state.NutInfos[i].calories}</td>
                                            <td>{this.state.NutInfos[i].carbohydrate}</td>
                                            <td>{this.state.NutInfos[i].protein}</td>
                                            <td>{this.state.NutInfos[i].fat}</td>
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