import http from "../http-common";
import axios from "axios";

class UploadFilesService {
    upload(file, onUploadProgress) {
        let formData = new FormData();
        formData.append("file", file);

        let returnJSON = axios.post("/uploadFile", formData, {
            headers: {
                "Content-Type" : "multipart/form-data"
            }
        })

        return console.log(returnJSON);
    }

    getFiles() {
        return http.get("/files");
    }
}

export default new UploadFilesService();