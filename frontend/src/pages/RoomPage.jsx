import { useState } from "react";
import CreateRoomComponent from "../components/RoomComponent/CreateRoomComponent";
import JoinRoomComponent from "../components/RoomComponent/JoinRoomComponent";

function RoomPage(){

  const [ pageView, setPageView ] = useState(null);



  return (
    <>
    <div>
      <button
      onClick={() => {
          setPageView("CREATE")
      }}
      >Create Room</button>
      <button
      onClick={() => {
          setPageView("JOIN")
      }}
      >Join Room</button>
    </div>

    <div>
      { pageView === "CREATE" && (
          <div>
            <CreateRoomComponent></CreateRoomComponent>
          </div>
      )}

      { pageView === "JOIN" && (
          <div>
            <JoinRoomComponent></JoinRoomComponent>
          </div>
      )}
    </div>
    </>
  )

}

export default RoomPage;