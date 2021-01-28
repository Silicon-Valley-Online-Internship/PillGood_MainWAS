import axios from 'axios'

const REST_API_URL = "/uploadFile";

class NutServiceFetch {
    getFiles() {
        return axios.post(REST_API_URL);
    }
}

export default new NutServiceFetch();
