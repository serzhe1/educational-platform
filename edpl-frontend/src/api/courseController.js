import axios from 'axios';

export const api = axios.create({
    baseURL: 'http://localhost:8090',
});
export const token = btoa(localStorage.getItem('username') + ':' + localStorage.getItem('password'));
