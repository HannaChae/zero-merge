import PropTypes from "prop-types";
import React, { useState, useEffect, Fragment } from "react";
import MetaTags from "react-meta-tags";
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic";
import Card, { CardBody } from "react-bootstrap/Card";
import Accordion from "react-bootstrap/Accordion";
import LayoutOne from "layouts/LayoutOne";
import Breadcrumb from "wrappers/breadcrumb/Breadcrumb";
import axios from 'axios';


const MyAccount = ({ location }) => {
    const [payment, setPayment] = useState([])
    const [receiver, setReceiver] = useState([])

 useEffect(()=>{
   axios.get("http://localhost:8080/payment/all", {
    headers: {
      'Content-Type'  : 'application/json',
      'Authorization' : 'JWT fefege..'
    }
   })
   .then(({ data }) => setPayment(data))
   .catch((error) => {
     alert('실패')
     throw error;
   })
  },[])
  


  const year = ["전체기간"];
  const { pathname } = location;

  return (
    <>
      <MetaTags>
        <title>Flone | My Account</title>
        <meta
          name="description"
          content="Compare page of flone react minimalist eCommerce template."
        />
      </MetaTags>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
      <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>
        My Account
      </BreadcrumbsItem>
      <LayoutOne headerTop="visible">
        {/* breadcrumb */}
        <Breadcrumb />
        <div className="myaccount-area pb-80 pt-100">
          <div className="container">
            <div className="row">
              <div className="ml-auto mr-auto col-lg-9">
                <div className="myaccount-wrapper">
                  <Accordion defaultActiveKey="0">
                    <Card className="single-my-account mb-20">
                      <Card.Header className="panel-heading">
                        <Accordion.Toggle variant="link" eventKey="3">
                          <h3 className="panel-title">
                            <span>4 .</span> Order list{" "}
                          </h3>
                        </Accordion.Toggle>
                      </Card.Header>
                      <Accordion.Collapse eventKey="3">
                        <Card.Body>
                          <div className="myaccount-info-wrapper">
                            <div className="account-info-wrapper">
                              <h4>Order list</h4>                            
                          <article>
                            <div>
                              <select>
                                {year.map(year => (
                                  <option key={year}>{year}</option>
                                ))}
                              </select>
                            </div>
                          </article>
                            </div>
                            {payment.map((card, index) => (
                            <div className="entries-wrapper">
                              <div className="row">
                                <div className="col-lg-6 col-md-6 d-flex align-items-center justify-content-center">
                                  <div className="entries-info text-center">
                                      <div key={index}>
                                        <div>
                                        {card.payDate}
                                        </div>
                                        <div>
                                        {card.payPrice}
                                        </div>
                                        <div>
                                        {card.payState}
                                        </div>
                                        <div>
                                        {card.prdNo}
                                        </div>
                                      </div>
                                  </div>
                                </div>
                                <div className="col-lg-6 col-md-6 d-flex align-items-center justify-content-center">
                                  <div className="entries-edit-delete text-center">
                                    <button className="edit">교환/환불</button>
                                    <form action="http://info.sweettracker.co.kr/tracking/5" method="post">
                                        <input type="hidden" class="form-control" id="t_key" name="t_key" value="ymJmuSQTWNb5HVh5nip8cw"/>
                                        <input type="hidden" class="form-control" name="t_code" id="t_code" value="04"/>
                                        <input type="hidden" class="form-control" name="t_invoice" id="t_invoice" value="387842034141"/>
                                      <button type="submit" class="btn btn-default">배송조회</button>
                                  </form>
                                  </div>
                                </div>
                              </div>
                            </div>
                            ))}
                            <div className="billing-back-btn">
                              <div className="billing-btn">
                                <button type="submit">Continue</button>
                              </div>
                            </div>
                          </div>
                        </Card.Body>
                      </Accordion.Collapse>
                    </Card>
                  </Accordion>
                </div>
              </div>
            </div>
          </div>
        </div>
      </LayoutOne>
    </>
  );
};

MyAccount.propTypes = {
  location: PropTypes.object
};

export default MyAccount;
