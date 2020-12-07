import axios from 'axios';

const GET_USERS_API = 'http://localhost:8081/api/user/getall';
const POST_USER_API = 'http://localhost:8081/api/user';

class UserService{
    getUsers(){
        return axios.get(GET_USERS_API);
    }

    createUser(user){
        return axios.post(POST_USER_API, user);
    }
}

export default new UserService();