import axios from 'axios'

const REST_API_URL = 'http://localhost:8080/search/nut';

class NutServiceFetch {
    getFiles() {
        return axios.get(REST_API_URL);
    }
}

export default new NutServiceFetch();
