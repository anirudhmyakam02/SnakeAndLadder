import { useState } from "react";
import customAxios from "../../utils/customAxios";

function JoinRoomComponent(){

  const [ roomCode, setRoomCode ] = useState("");

  async function handleJoinRoom(){

    const response = await customAxios.get(
      `/joinRoom/${roomCode}`
    )
  }

  return (
    <>
    
      <input type="text" 
        placeholder="Enter Room code"
        value={roomCode}
        onChange={(e) => setRoomCode(e.target?.value)}
      />

      <button
        onClick={handleJoinRoom}
      >Join</button>
    </>
  )

}

export default JoinRoomComponent;