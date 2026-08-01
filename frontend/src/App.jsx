import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import BoardComponent from './components/BoardComponent/BoardComponent'
import ChatComponent from './components/Dummy/ChatConnectionComponent'
import { Route, Routes } from 'react-router-dom'
import Loginpage from './pages/LoginPage'
import RoomCreation from './components/RoomComponent/CreateRoomComponent'
import GameComponent from './components/GameComponent/GameComponent'
import RegisterPage from './pages/RegisterPage'
import RoomPage from './pages/RoomPage'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Routes>
        <Route path='/login' element={<Loginpage></Loginpage>}/>
        <Route path='/register' element={<RegisterPage></RegisterPage>} />
        <Route path='/room' element={<RoomPage></RoomPage>} />
      </Routes>
      {/* <ChatComponent></ChatComponent>
      <RoomCreation></RoomCreation> */}
      {/* <GameComponent></GameComponent> */}
    </>
  )
}

export default App
