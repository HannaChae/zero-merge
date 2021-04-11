import PropTypes from "prop-types"
import React, { useState, useEffect } from 'react';
import axios from 'axios'
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import { Breadcrumb } from "__common__/index"
import LayoutOne from "layouts/LayoutOne";
import { useHistory } from "react-router"
import TeamMemberOne from "wrappers/team-member/TeamMemberOne";

const MyAccountDetail = ({ location, match }) => {

    useEffect(()=>{
        setPayment(JSON.parse(localStorage.getItem("payment")))
      }, [])

    const [ payment, setPayment ] = useState({})
    const [ payState, setPayState ] = useState('')
    const [ rcvName, setRcvName ] = useState('')
    const [ rcvPhone, setRcvPhone ] = useState('')
    const [ rcvAddr, setRcvAddr ] = useState('')

    const history = useHistory()
    const { pathname } = location;

    // const ChangeAddr = () => {
    //     setPayment(JSON.parse(localStorage.getItem("payment")))
    // } 
    const refund = e => {
        e.preventDefault()
        axios({
            url: `http://localhost:8080/payment/${match.params.id}`,
            method: 'delete',
            headers: {'Content-Type':'application/json','Authorization': 'JWT fefege...'},
            data: {}
        }).then(res => {
            history.push('/my-account')
        }).catch(err => {
            alert(err.response)
        })
    }
    const [ addr, setAddr ] = useState('')
    const [ extraAddr, setExtraAddr ] = useState('')
    const [ postcode, setPostcode ] = useState('')
    const [ fullAddr, setFullAddr ] = useState('')
  
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
    const addrChange = e => {
        e.preventDefault()
        axios({
            url: `http://localhost:8080/payment/edit/${match.params.id}`,
            method: 'put',
            headers: {'Content-Type':'application/json','Authorization': 'JWT fefege...'},
            data: {
                payNo : `${match.params.id}`,
                payState : payment.payState,
                payDate : payment.payDate,
                payPrice : payment.payPrice,
                rcvAddr : `${postcode} ${addr} ${extraAddr}`+` `+fullAddr,
                rcvName, rcvPhone}
        }).then(res => {
            history.push('/my-account')
        }).catch(err => {
            alert(err.response)
        })
    }
    // useEffect(()=>ChangeAddr(), [])
    return (<>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>PaySuccess</BreadcrumbsItem>
    <LayoutOne headerTop="visible">
    <Breadcrumb />
    <button onClick={refund}>삭 제</button>
    <input type="text" value={payment.payState || ''} readOnly/>
    <input type="text" value={payment.payDate || ''} readOnly/>
    <input type="text" value={payment.payPrice || ''} readOnly/>
    <button onClick={ execPostCode }>주소 검색</button>
    <input type="text" value={`${postcode} ${addr} ${extraAddr}`} readOnly />
    <input type="text" placeholder="받으시는 분의 상세 주소를 입력하세요" name="fullAddr" value={fullAddr} required
    onChange = { e => { setFullAddr(`${e.target.value}`)}} />
    <input className="box" type="text" value={rcvName} onChange={e => setRcvName(e.target.value)}/>
    <input className="box" type="text" value={rcvPhone} onChange={e => setRcvPhone(e.target.value)}/>
    <button onClick={addrChange}>배송지 변경</button>
    {/* team member */}
    <TeamMemberOne spaceTopClass="pt-95" spaceBottomClass="pb-70" />

    </LayoutOne>
    </>

    )
}
MyAccountDetail.propTypes = {
    location: PropTypes.object
  }
export default MyAccountDetail