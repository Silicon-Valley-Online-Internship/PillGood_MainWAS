import http from "../http-common";
import axios from "axios";

class UploadFilesService {
    async upload(file, onUploadProgress) {
        let formData = new FormData();
        formData.append("file", file);

        console.log(formData)

        const returnJSON = axios.post("/uploadFile", formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            },
            onUploadProgress,
        });

        console.log(returnJSON)

        console.log(JSON.parse((await returnJSON).data.predictinfo));

        return JSON.parse((await returnJSON).data.predictinfo)
    }

    async getFiles() {
        return http.get("/uploadFile");
    }
}

export default new UploadFilesService();