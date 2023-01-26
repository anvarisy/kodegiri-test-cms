import './App.css';
import React from 'react';
import axios from "axios";

function App() {
const[username, setUsername] = React.useState('')
const[password, setPassword] = React.useState('')
  return (
      <header className="App-header">
        <form onSubmit={(e)=>{
          e.preventDefault();
          const userObject = {
            username:username,
            password:password
          }

          axios.post('http://localhost:8080/authenticate', userObject)
            .then((res) => {
                if(res.data.status===true){
                  localStorage.setItem("bearer", res.data.data.token)
                  window.location.href= "/"
                }else{
                 window.alert(res.data.message)
                }
            }).catch((error) => {
              console.log(error)
              window.alert("Username & Password not match")
            });
        }}>
          <div className='item'>
            <label className='title'>
              Login Form
            </label>
          </div>
          <div>
          </div>
          <div className='item'>
              <input placeholder='Username' type="text" value={username} onChange={u=>setUsername(u.target.value)} />
          </div>
          <div className='item'>
              <input placeholder='Password' type="password" value={password} onChange={p=>setPassword(p.target.value)} />
          </div>
          <div className='item'>
            <button type="submit">Submit</button>
          </div>
        </form>
      </header>
  );
}

export default App;
