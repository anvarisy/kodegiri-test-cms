import './App.css';
import React from 'react';
import axios from "axios";
import Select from 'react-select'

export function Transaction(){
    const config = {
        headers: {
            Authorization: `Bearer ${localStorage.getItem("bearer")}`}
    };
    const[productItems, setProductItems] = React.useState([])
    const[companyItems, setCompanyItems] = React.useState([])
    const[qty, setQty] = React.useState(0)
    const[productId, setProductId] = React.useState("")
    const[companyId, setCompanyId] = React.useState("")
    // const[name, setName] = React.useState("")
    React.useEffect(()=>{
        console.log(localStorage.getItem("bearer"))
        if(localStorage.getItem("bearer")===null){
         window.location.href = "/login"
        }
        const config = {
            headers: {
                Authorization: `Bearer ${localStorage.getItem("bearer")}`}
        };
        axios.get('http://localhost:8080/product', config)
            .then((res) => {
                if(res.data.status===true){
                    console.log(res.data.data)
                    const option = res.data.data.map(d=>({
                        "value" : d.id,
                        "label" : d.name +" - "+ d.price
                    }))
                    setProductItems(option)
                }else{
                    window.alert(res.data.message)
                }
            }).catch((error) => {
                if(error.response.status===403){
                    window.alert("token expired, Please login !")
                    window.location.href = "/login"
                }
            });

            axios.get('http://localhost:8080/company', config)
            .then((res) => {
                if(res.data.status===true){
                    console.log(res.data.data)
                    const option = res.data.data.map(d=>({
                        "value" : d.id,
                        "label" : d.company_name
                    }))
                    setCompanyItems(option)
                }else{
                    window.alert(res.data.message)
                }
            })
        return()=>{

        }
      },[])
    
 
    return(
        <header className="App-header">
            <form onSubmit={(e)=>{
                e.preventDefault();
                const userObject = {
                company_id:companyId,
                product_id:productId,
                qty:qty
                }

            axios.post('http://localhost:8080/transaction', userObject, config)
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
              Input Transaction
            </label>
          </div>
          <div>
          </div>
          <div className='item'>
            <Select color='black' options={companyItems} onChange={(e, v)=>{
                setCompanyId(e.value)
            }} />
          </div>

          <div className='item'>
            <Select color='black' options={productItems} onChange={(e, v)=>{
                setProductId(e.value)
            }} />
          </div>
          <div className='item'>
                QTY
              <input placeholder='Qty' type="number" value={qty} onChange={q=>setQty(q.target.value)} />
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