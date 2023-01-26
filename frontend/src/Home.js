import React from 'react';

function Home(){
    React.useEffect(()=>{
        console.log(localStorage.getItem("bearer"))
        if(localStorage.getItem("bearer")===null){
         window.location.href = "/login"
        }
        return()=>{
          
        }
      },[])
    return(
        <header className="App-header">
            <div className='item'>
                <button onClick={()=>{
                    window.location.href = "/company"
                }}>Insert Company</button>
            </div>
            <div className='item'>
                <button onClick={()=>{
                     window.location.href = "/transaction"
                }}>Insert Transaction</button>
            </div>
            <div className='item'>
                <button onClick={()=>{
                    console.log("print data")
                }}>Print Data</button>
            </div>
        </header>
    );
}

export default Home;