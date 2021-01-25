
const REST_API_URL = "/uploadFile";

class NutServiceFetch{
    getFiles(){
        return fetch(REST_API_URL,
        {
            method: 'post',
            headers : {
                'Accept': 'application/json',
                'content-Type': 'application/json'
            }
        }).then((res=>res.json()));
    }
}

export default new NutServiceFetch();
