import './App.css';
import React from 'react';
import axios from "axios";

export default function Company(){
    React.useEffect(()=>{
        console.log(localStorage.getItem("bearer"))
        if(localStorage.getItem("bearer")===null){
         window.location.href = "/login"
        }
        return()=>{
          
        }
      },[])
    const config = {
        headers: {
            Authorization: `Bearer ${localStorage.getItem("bearer")}`}
    };
    const[companyId, setCompanyId] = React.useState('')
    const[companyName, setCompanyName] = React.useState('')
    return(
        <header className="App-header">
            <form onSubmit={(e)=>{
                e.preventDefault();
                const userObject = {
                company_id:companyId,
                company_name:companyName
                }

            axios.post('http://localhost:8080/company', userObject, config)
                .then((res) => {
                    if(res.data.status===true){
                        window.alert(res.data.message)
                    }else{
                        window.alert(res.data.message)
                    }
                }).catch((error) => {
                    if(error.response.status===403){
                        window.alert("token expired, Please login !")
                        window.location.href = "/login"
                    }
                });
        }}>
          <div className='item'>
            <label className='title'>
              Input Company
            </label>
          </div>
          <div>
          </div>
          <div className='item'>
              <input placeholder='Company Id' type="text" value={companyId} onChange={i=>setCompanyId(i.target.value)} />
          </div>
          <div className='item'>
              <input placeholder='Company Name' type="text" value={companyName} onChange={n=>setCompanyName(n.target.value)} />
          </div>
          <div className='item'>
            <div>
            <button type="submit">Submit</button>
            <button onClick={()=>{
                window.location.href ="/"
            }}>Home</button>
            </div>
          </div>
        </form>
</header>
    )
}