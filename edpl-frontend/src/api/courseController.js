import axios from 'axios';

export const api = axios.create({
    baseURL: 'http://localhost:9090/articles',
});
export const token = btoa(localStorage.getItem('username') + ':' + localStorage.getItem('password'));
