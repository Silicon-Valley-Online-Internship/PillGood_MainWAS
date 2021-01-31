import http from "../http-common";
import axios from "axios";

class UploadFilesService {
    async upload(file, onUploadProgress) {
        let formData = new FormData();
        formData.append("file", file);

        const returnJSON = axios.post("/uploadFile", formData, {
            headers: {
                "Content-Type": "multipart/form-data"
            },
            onUploadProgress,
        });

        return JSON.parse((await returnJSON).data.predictNutinfo)

    }

    async getFiles() {
        return http.get("/uploadFile");
            }
}

export default new UploadFilesService();