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
import HomePage from './pages/HomePage'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <Routes>
        <Route path='/' element={<HomePage />} />
        <Route path='/login' element={<Loginpage />} />
        <Route path='/register' element={<RegisterPage />} />
        <Route path='/room' element={<RoomPage />} />
      </Routes>
    </>
  )
}

export default App
