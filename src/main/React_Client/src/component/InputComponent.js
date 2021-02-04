import React, {Component} from "react";
import UploadService from "../service/upload-files.service";
import "views/HomeView.css"
import img_preview from "../assets/img/previewimg.jpg";

export default class InputComponent extends Component {
    constructor(props) {
        super(props);
        this.selectFile = this.selectFile.bind(this);
        this.upload = this.upload.bind(this);

        this.state = {
            selectedFiles: undefined,
            currentFile: undefined,
            progress: 0,
            message: "",
            loading: false
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
        }).then((response) => {
            this.state.PillInfos.push(response)
            this.setState({
                PillInfos: this.state.PillInfos,
                message: response.data.message,
            });
            return UploadService.getFiles();
        }).catch(() => {
            this.setState({
                progress: 0,
                message: "upload the file!",
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
        } = this.state;

        let profile_preview = null;
        if(this.state.file !== ''){
            if(typeof this.state.file !== 'undefined') {
                profile_preview = <img className='profile_preview' src={this.state.previewURL}></img>;
            }
            else {
                profile_preview = <img className='profile_preview' src={img_preview}></img>;
            }
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

                <div className="filebox bs3-warning">
                    <label style = {{margin:0, marginRight:10}} htmlFor="ex_file2">Find your photo</label>
                    <input type="file" id="ex_file2"
                           accept='image/jpg'
                           name='profile_img'
                           onChange={this.selectFile} />

                    {/*업로드 버튼*/}
                    <button style={{marginLeft:10}} className="btn btn-dark active"
                            disabled={!selectedFiles}
                            onClick={this.upload}
                    >
                        Upload
                    </button>
                </div>
                {profile_preview}

            </div>
        );
    }
}