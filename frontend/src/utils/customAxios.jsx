import axios from "axios";

const customAxios = axios.create({
    baseURL: "http://3.111.58.34:8080",
    withCredentials: true,
})

customAxios.interceptors.request.use((config) => {
    const token =
      localStorage.getItem("token") ||
      sessionStorage.getItem("token");

    console.log( "this is the token : "+token)

    if (token) {
      config.headers.Authorization = `Bearer ${token}`;
    }
  
    return config;
  });


  export default customAxios;