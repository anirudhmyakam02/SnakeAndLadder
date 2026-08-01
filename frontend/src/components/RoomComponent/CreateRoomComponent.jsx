import { useRef, useState } from "react";
import customAxios from "../../utils/customAxios";

function CreateRoomComponent(){

  const [ roomLimit, setRoomLimit ] = useState(3);
  const [ roomCode, setRoomCode ] = useState("");

  async function handleCreateNewRoom(){
    const response = await customAxios.post(
      "/player/createRoom",
      {
        roomLimit: roomLimit
      }
    )

    console.log(response);
  }

  return(
    <div className="roomCreation">
      <h1>Room Creation</h1>
      <input type="text"
        value={roomLimit}
        onChange={(e) => {
          setRoomLimit(e.target.value);
        }} />

      <button onClick={handleCreateNewRoom}>Create</button>
      

    </div>
    
  )
}

export default CreateRoomComponent;