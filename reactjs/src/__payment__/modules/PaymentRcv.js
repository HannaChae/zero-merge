import React, {useState} from "react"
import axios from "axios"

const PaymentRcv = () => {
    const [ addr, setAddr ] = useState('')
    const [ extraAddr, setExtraAddr ] = useState('')
    const [ postcode, setPostcode ] = useState('')
    const [ fullAddr, setFullAddr ] = useState('')
    const [ rcvName, setRcvName ] = useState('')
    const [ rcvPhone, setRcvPhone ] = useState('')

    const execPostCode = () => {
        new window.daum.Postcode({
          oncomplete: data => {
    
            setPostcode(data.zonecode)
    
            if(data.userSelectedType === "R"){
              setAddr(data.roadAddress)
              if (data.buildingName !== ""){
                setExtraAddr(" (" + data.buildingName + ")")
              }
            }else{
              setExtraAddr(data.jibunAddress)
            }
        }
        }).open();
      };

const onClickRcv = e => {

    e.preventDefault()
      axios({
        url: 'http://localhost:8080/receiver/save', 
        method: 'post',
        headers: {
          'Content-Type'  : 'application/json',
          'Authorization' : 'JWT fefege..'
        },
        data: {
          rcvName,
          rcvPhone,
          // rcvAddr: `${postcode} ${addr} ${extraAddr}`+` `+fullAddr,
        }
      })
      .then(res => {
        alert(`성공`)
      })
      .catch(err => {
        console.log(`실패: ` + err)
        throw err
      })
}
    return (<><div className="row">
                      <div className="col-lg-6 col-md-6">
                        <div className="billing-info mb-20">
                          <label>Name</label>
                          <input name="rcvName" value={rcvName} placeholder="받으시는 분의 성함을 입력하세요" required
                          onChange = { e => { setRcvName(`${e.target.value}`)}}
                          />
                        </div>
                      </div>
                      <div className="col-lg-6 col-md-6">
                        <div className="billing-info mb-20">
                          <label>Phone</label>
                          <input type="number" name="rcvPhone" value={rcvPhone} placeholder="받으시는 분의 연락처를 입력하세요" required
                          onChange = { e => { setRcvPhone(`${e.target.value}`)}}
                          />
                        </div>
                      </div>
                    <div className="col-lg-12">
                        <div className="billing-info mb-20">
                          <label>Address</label> <button onClick={ execPostCode }>주소 검색</button>
                          <input type="text" value={`${postcode} ${addr} ${extraAddr}`} readOnly />
                          <input type="text" placeholder="받으시는 분의 상세 주소를 입력하세요" name="fullAddr" value={fullAddr} required
                          onChange = { e => { setFullAddr(`${e.target.value}`)}} />
                        </div>
                      </div>
                </div>
    </>)
}
export default PaymentRcv;