
const REST_API_URL = "http://localhost:8080/search/nut/{{id}}";

class NutServiceFetch{
    getFiles(){
        return fetch(REST_API_URL,
        {
            method: 'get',
            headers : {
                'Accept': 'application/json',
                'content-Type': 'application/json'
            }
        }).then((res=>res.json()));
    }
}

export default new NutServiceFetch();
