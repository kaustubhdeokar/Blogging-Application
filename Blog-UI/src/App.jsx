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
import ListTopics from './components/ListTopics'
import PostComponent from './components/PostComponent'
import AccountVerificationComponent from './components/AccountVerificationComponent'
import { isUserLoggedIn } from './service/AuthService'

function App() {

  function AuthenticatedRoute({ children }) {
    const isAuth = isUserLoggedIn();
    if (isAuth) { return children; }
    return <Navigate to="/" />
  }

  return (
    <>
      <BrowserRouter>
        <HeaderComponent />
        <Routes>
          <Route path='/sign-up' element={< RegisterComponent />}></Route>
          <Route path='/login' element={< LoginComponent />}></Route>
          <Route path='/api/auth/accountVerification/:id' element={< AccountVerificationComponent />}></Route>
          <Route path='/' element={< LoginComponent />}></Route>
          <Route path='/new' element={< NewComponent />}></Route>

          <Route path='/home' element={<AuthenticatedRoute>< HomeComponent /></AuthenticatedRoute>}></Route>
          <Route path='/home/:topicName' element={<AuthenticatedRoute>< HomeComponent /></AuthenticatedRoute>}></Route>
          <Route path='/vote' element={< VoteComponent />}></Route>
          <Route path='/create-post' element={<AuthenticatedRoute>< CreatePostComponent /></AuthenticatedRoute>}></Route>
          <Route path='/create-topic' element={<AuthenticatedRoute>< CreateTopicComponent /></AuthenticatedRoute>}></Route>
          <Route path='/view-post/:id' element={<AuthenticatedRoute>< ViewPost /></AuthenticatedRoute>}></Route>
          <Route path='/userprofile' element={< UserProfile />}></Route>
          <Route path='/list-topics' element={<AuthenticatedRoute>< ListTopics /></AuthenticatedRoute>}></Route>
          <Route path='/view-topic/:topicName' element={<AuthenticatedRoute>< HomeComponent /></AuthenticatedRoute>}></Route>
        </Routes>
      </BrowserRouter >
    </>
  )
}

export default App
