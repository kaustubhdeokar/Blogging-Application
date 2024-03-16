import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import HeaderComponent from './components/HeaderComponent'
import { BrowserRouter, Route, Routes } from 'react-router-dom'
import RegisterComponent from './components/RegisterComponent'
import LoginComponent from './components/LoginComponent'
import NewComponent from './components/NewComponent'
import HomeComponent from './components/HomeComponent'
import VoteComponent from './components/VoteComponent'
import CreatePostComponent from './components/CreatePostComponent'
import CreateTopicComponent from './components/CreateTopicComponent'
import ViewPost from './components/ViewPost'
import UserProfile from './components/UserProfile'

function App() {

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path='/sign-up' element={< RegisterComponent />}></Route>
          <Route path='/login' element={< LoginComponent />}></Route>
          <Route path='/' element={< LoginComponent />}></Route>
          <Route path='/new' element={< NewComponent />}></Route>
          <Route path='/home' element={< HomeComponent />}></Route>
          <Route path='/vote' element={< VoteComponent />}></Route>
          <Route path='/create-post' element={< CreatePostComponent />}></Route>
          <Route path='/create-topic' element={< CreateTopicComponent />}></Route>
          <Route path='/view-post/:id' element={< ViewPost />}></Route>
          <Route path='/userprofile' element={< UserProfile />}></Route>
        </Routes>
      </BrowserRouter >
    </>
  )
}

export default App
