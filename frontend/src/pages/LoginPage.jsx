import { useRef } from "react";
import customAxios from "../utils/customAxios"

function Loginpage(){

    const username = useRef("");
    const password = useRef("");

    async function handleLogin(){
        
        console.log(username.current?.value, password.current?.value)
        
        try{
            const response = await customAxios.post(
                "/auth/login",
                {
                    username: username.current?.value,
                    password: password.current?.value
                }
            )

            if(response.status == 200){
              localStorage.setItem("token",response.data.token);
            }
            
        } catch(e){
            alert("login failed");
            console.log(e);
        }
    }
    

    return(
        <>
          <input 
            type="text"
            placeholder="Enter Username"
            // value={username}
            ref={username}
            />

          <input
            type="text"
            placeholder="Enter password"
            ref={password}
          />

          <button
            onClick={handleLogin}
          >Login</button>

        </>
    )

}

export default Loginpage;