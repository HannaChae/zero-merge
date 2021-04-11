import React, {useState,useEffect} from "react"
import axios from "axios"
import moment from "moment"
import { useHistory } from "react-router"

const PaymentPost = () => {
    const history = useHistory()
    useEffect(()=>{
        setUser(JSON.parse(localStorage.getItem("user")))
      }, [])

    const [user, setUser] = useState([])
    const [usrName, setUsrName] = useState('')
    const [usrPhone, setUsrPhone] = useState('')
    const [usrAddr, setUsrAddr] = useState('')

    const nowTime = useState(moment().format('YYYY-MM-DD HH:mm:ss'));

    const orderPlace = e => {
      e.preventDefault()
    axios({
        url: 'http://localhost:8080/payment/save', 
        method: 'post',
        headers: {
          'Content-Type'  : 'application/json',
          'Authorization' : 'JWT fefege..'
        },
        data: {
          userNumber: `${user.usrNo}`,
          payPrice: "",
          payInfo: "",
          payDate: nowTime,
          payState: "결제완료"
        }
      })
      .then(res => {
        alert(`성공`)
        history.push('/pay-progress')
      })
      .catch(err => {
        console.log(`실패: ` + err)
        throw err
    })
}
    return (<>
                <div className="row">
                    <ul>
                    <div className="col-lg-6 col-md-6">
                        <div className="billing-info mb-20">
                        <label>Name</label>
                        <input type="text" value={user.usrName || ''} onChange = { e => { setUsrName(`${e.target.value}`)}}/>
                        </div>
                    </div>
                    <div className="col-lg-6 col-md-6">
                        <div className="billing-info mb-20">
                        <label>Phone</label>
                        <input type="text" value={user.usrPhone || ''} onChange = { e => { setUsrPhone(`${e.target.value}`)}}/>
                        </div>
                    </div>
                    <div className="col-lg-12">
                        <div className="billing-info mb-20">
                        <label>Address</label>
                        <input type="text" value={user.usrAddr || ''} onChange = { e => { setUsrAddr(`${e.target.value}`)}}/>
                        </div>
                    </div>
                    </ul>
                    <button className="btn-hover" type="submit" onClick= {orderPlace}>Place Order</button>
                </div>
    </>)
}
export default PaymentPost