import { useState } from "react";
import customAxios from "../utils/customAxios";

function RegisterPage(){

    const [ username, setUsername ] = useState("");
    const [ email, setEmail ] = useState("");
    const [ password, setPassword ] = useState("");

    async function handleRegistration(){

        const response = await customAxios.post(
            "/user/register",
            {
                username: username,
                email: email,
                password: password
            }
        )

    }

    return (
        <>
            <input type="text"
              placeholder="Enter your username"
              value={username}
              onChange={(e) => {
                setUsername(e.target?.value)
              }}
            />

            <input type="text"
              placeholder="Enter your email"
              value={email}
              onChange={(e) => {
                setEmail(e.target?.value)
              }}
            />

            <input type="text"
              placeholder="Enter your password"
              value={password}
              onChange={(e) => {
                setPassword(e.target?.value)
              }}
            />

            <button 
              onClick={handleRegistration}
            >Register</button>
        </>
    )

}

export default RegisterPage;