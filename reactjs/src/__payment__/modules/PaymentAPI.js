import React, {useState, useEffect} from "react"
import jQuery from "jquery"
import $ from "jquery"
import { useHistory } from "react-router"
window.$ = window.jQuery = jQuery; 

const PaymentAPI = ({location}) => {

    useEffect(()=>{
        setUser(JSON.parse(localStorage.getItem("user")))
      }, [])

    const [user, setUser] = useState([])

    const history = useHistory()
    
    function onClickPayment() {
      /* 1. 가맹점 식별하기 */
      const { IMP } = window;
      IMP.init('imp55713696');
  
      /* 2. 결제 데이터 정의하기 */
      const data = {
        pg: 'kakaopay',                           // PG사
        pay_method: 'card',                           // 결제수단
        merchant_uid: `mid_${new Date().getTime()}`,   // 주문번호
        amount: 1000,                                 // 결제금액
        name: '아임포트 결제 데이터 분석',                  // 주문명
        buyer_name: `${user.usrName}`,                           // 구매자 이름
        buyer_tel: `${user.usrPhone}`,                   // 구매자 전화번호
        buyer_addr: `${user.usrAddr}`                 // 구매자 주소
      }
      /* 4. 결제 창 호출하기 */
      IMP.request_pay(data, callback);
    }
  
    /* 3. 콜백 함수 정의하기 */
    function callback(response) {
      const {
        success,
        merchant_uid,
        error_msg
      } = response;
  
      if (success) {
        alert('결제 성공');
        history.push('/pay-success')
      } else {
        alert(`결제 실패: ${error_msg}`);
      }
    }


    // const { IMP } = window;
    // IMP.init('imp00000000');

    // const placeOrder = e => {
    // e.preventDefault()
    // IMP.init('imp55713696');
    // IMP.request_pay({
    //   pg : 'kakaopay',
    //   pay_method : 'card', //card(신용카드), trans(실시간계좌이체), vbank(가상계좌), phone(휴대폰소액결제)
    //   merchant_uid : 'merchant_' + new Date().getTime(), //상점에서 관리하시는 고유 주문번호를 전달
    //   name : "",
    //   amount : "",
    //   buyer_name : 
    //   buyer_tel : `${user.usrPhone}`,
    //   buyer_addr : 
    // }, function(rsp) {
    //   history.push('/pay-success')
    //     if ( rsp.success ) {
    //       //[1] 서버단에서 결제정보 조회를 위해 jQuery ajax로 imp_uid 전달하기
    //       jQuery.ajax({
    //       url: "http://localhost:8080/payment/save", //cross-domain error가 발생하지 않도록 주의해주세요
    //       type: 'POST',
    //       dataType: 'json',
    //       headers: { 'Content-Type'  : 'application/json' },
    //       data: {
    //       imp_uid : rsp.imp_uid,
    //       merchant_uid: rsp.merchant_uid
    //       //기타 필요한 데이터가 있으면 추가 전달
    //       }
    //     }).done(function(data) {
    //       //[2] 서버에서 REST API로 결제정보확인 및 서비스루틴이 정상적인 경우
    //       if (data.success) {
    //       var msg = '결제가 완료되었습니다.';
    //       msg += '\n고유ID : ' + rsp.imp_uid;
    //       msg += '\n상점 거래ID : ' + rsp.merchant_uid;
    //       msg += '\결제 금액 : ' + rsp.paid_amount;
    //       msg += '카드 승인번호 : ' + rsp.apply_num;
    //       alert(msg);

    //     } else {
    //       //[3] 아직 제대로 결제가 되지 않았습니다.
    //       //[4] 결제된 금액이 요청한 금액과 달라 결제를 자동취소처리하였습니다.
    //       }
    //     });
    // } else {
    //     var msg = '결제에 실패하였습니다.';
    //     msg += '에러내용 : ' + rsp.error_msg;
    //     location.href='/checkout';
    //     alert(msg);
    //     }

    //   });
    
    // var express = require('express');
    // var app = express();  

    // app.use(express.json());
    // app.post("/payment", async( req, res) => {
    //   try{
    //     const {imp_uid, merchant_uid} = req.body;
    //     const getToken = await axios({
    //       url:"https://api.iamport.kr/users/getToken",
    //       method:"post",
    //       header:{"Content-Type": "application/json"},
    //       data:{
    //         imp_key:"8393437079148616",
    //         imp_secret:"1419473fcfb0cbf0a75f62756c961c362147b0be4457ec5e77d78932b61640c2aa57d73e476b09cf"
    //       }
    //     });
    //     const {access_token} = getToken.data.response;
    //     const getPaymentData = await axios({
    //       url:`https://api.iamport.kr/payment/${imp_uid}`,
    //       method:"get",
    //       headers: {"Authorization": access_token}
    //     });
    //     const paymentData = getPaymentData.data.response;
    //     const order = await Orders.findById(paymentData.merchant_uid);
    //     const amountToBePaid = order.amount;
    //     const { amount, status } = paymentData;
    //     if(amount === amountToBePaid){
    //       await Orders.findByIdAndUpdate(merchant_uid, {$set:paymentData});
    //       switch (status) {
    //         case "ready":
    //           const { vbank_num, vbank_date, vbank_name } = paymentData;
    //           await Users.findByIdAndUpdate({ $set: {vbank_num, vbank_date, vbank_name}});
    //           SMS.send({text:`가상계좌 발급이 성공되었습니다. 계좌 정보 \${vbank_num} \${vbank_date} \${vbank_name}\}`});
    //           res.send({status: "vbanklssued", message:"가상계좌 발급 성공"});
    //           break;
    //         case "paid":
    //           res.send({status:"success", message:"일반 결제 성공"});
    //           break;
    //       }
    //     } else {
    //       throw { status : "forgery", message : "위조된 결제시도" }
    //      }
    //     } catch (e) {
    //       res.status(400).send(e);
    //   }
    // });
    //   }   
    return (<>
    </>)
}
export default PaymentAPI