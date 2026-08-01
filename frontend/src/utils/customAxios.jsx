import axios from "axios";

const customAxios = axios.create({
    baseURL: "http://localhost:8080",
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