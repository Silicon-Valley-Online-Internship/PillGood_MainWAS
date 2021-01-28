import React, {Component} from "react";
import UploadService from "../service/upload-files.service";
import axios from "axios";
import NutService from "../service/NutServiceFetch";

export default class UploadFiles extends Component {
    constructor(props) {
        super(props);
        this.selectFile = this.selectFile.bind(this);
        this.upload = this.upload.bind(this);

        this.state = {
            selectedFiles: undefined,
            currentFile: undefined,
            progress: 0,
            message: "",
            fileInfos: [],
            NutInfos: [],
        };
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
                this.setState({
                    message: response.data.message,
                });
                return UploadService.getFiles();
            })
            .then((files) => {
                this.setState({
                    fileInfos: files.data,
                });
            })
            .catch(() => {
                this.setState({
                    progress: 0,
                    message: "Could not upload the file!",
                    currentFile: undefined,
                });
            });

        this.setState({
            selectedFiles: undefined,
        });
    }
    componentDidMount() {
        UploadService.getFiles().then((response) => {
            this.setState({
                fileInfos: response.data,
            });
        });
        NutService.getFiles().then((response) => {
            this.setState({
                NutInfos : response.data})
        });
    }

    render() {
        const {
            selectedFiles,
            currentFile,
            progress,
            message,
            fileInfos,
            NutInfos,
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

                <div className="card">
                    <div className="card-header">List of Files</div>
                    <ul className="list-group list-group-flush">
                        {fileInfos &&
                        fileInfos.map((file, index) => (
                            <li className="list-group-item" key={index}>
                                <a href={file.url}>{file.name}</a>
                            </li>
                        ))}
                    </ul>
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
                        <tbody>
                        {
                            this.state.NutInfos.map(
                                Nutinfo =>
                                    <tr key = {Nutinfo.id}>
                                        <td> {Nutinfo.id}</td>
                                        <td> {Nutinfo.foodname}</td>
                                        <td> {Nutinfo.calories}</td>
                                        <td> {Nutinfo.carbohydrate}</td>
                                        <td> {Nutinfo.protein}</td>
                                        <td> {Nutinfo.fat}</td>

                                    </tr>
                            )
                        }

                        </tbody>
                    </table>

                </div>

            </div>
        );
    }
}