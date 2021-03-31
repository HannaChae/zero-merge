import PropTypes from "prop-types";
import React, { Fragment, useEffect, useState } from "react";
import MetaTags from "react-meta-tags";
import { Link } from "react-router-dom";
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic";
import Tab from "react-bootstrap/Tab";
import Nav from "react-bootstrap/Nav";
import LayoutOne from "../../layouts/LayoutOne";
import Breadcrumb from "../../wrappers/breadcrumb/Breadcrumb";
import axios from "axios"



export const UserLoginRegister = ({ location }) => {
    const { pathname } = location;
    const [usrId, setUsrId] = useState('')
    const [usrPwd, setUsrPwd] = useState('')
    const [usrName, setUsrName] = useState('')
    const [usrEmail, setUsrEmail] = useState('')
    const [user, setUser] = useState([])
    const sendData = () => {
        axios.post(`http://localhost:8080/usr/save`, {
            usrId, usrPwd, usrName, usrEmail
        })
            .then(response => {
                alert(`SUCCESS`)
            })
            .catch(err => {
                alert(`Error`)
                throw err
            });
    }

    return (
        <Fragment>
            {user.map(i => (
                // key값은 unique한 값(null이 아닌 값. 중복되지 않는 값.)
                <li key={i.usrNo}>{i.usrEmail}</li>
            ))}

            {user.map(i => {
                <li key={i.usrNo}>{i.usrEmail}</li>

            })}
            <MetaTags>
                <title>Flone | Login</title>
                <meta
                    name="description"
                    content="Compare page of flone react minimalist eCommerce template."
                />
            </MetaTags>
            <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
            <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>
                Login Register
      </BreadcrumbsItem>
            <LayoutOne headerTop="visible">
                {/* breadcrumb */}
                <Breadcrumb />
                <div className="login-register-area pt-100 pb-100">
                    <div className="container">
                        <div className="row">
                            <div className="col-lg-7 col-md-12 ml-auto mr-auto">
                                <div className="login-register-wrapper">
                                    <Tab.Container defaultActiveKey="login">
                                        <Nav variant="pills" className="login-register-tab-list">
                                            <Nav.Item>
                                                <Nav.Link eventKey="login">
                                                    <h4>Login</h4>
                                                </Nav.Link>
                                            </Nav.Item>
                                            <Nav.Item>
                                                <Nav.Link eventKey="register">
                                                    <h4>Register</h4>
                                                </Nav.Link>
                                            </Nav.Item>
                                        </Nav>
                                        <Tab.Content>
                                            <Tab.Pane eventKey="login">
                                                <div className="login-form-container">
                                                    <div className="login-register-form">
                                                        <form>
                                                            <input
                                                                type="text"
                                                                name="user-name"
                                                                placeholder="Username"
                                                                onChange={e => {
                                                                    setUsrId(`${e.target.value}`)

                                                                }}
                                                            />
                                                            <input
                                                                type="password"
                                                                name="user-password"
                                                                placeholder="Password"
                                                                onChange={e => { setUsrPwd(`${e.target.value}`) }
                                                                }
                                                            />
                                                            <div className="button-box">
                                                                <div className="login-toggle-btn">
                                                                    <input type="checkbox" />
                                                                    <label className="ml-10">Remember me</label>
                                                                    <Link to={process.env.PUBLIC_URL + "/"}>
                                                                        Forgot Password?
                                  </Link>
                                                                </div>
                                                                <button type="submit">
                                                                    <span>Login</span>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </Tab.Pane>
                                            <Tab.Pane eventKey="register">
                                                <div className="login-form-container">
                                                    <div className="login-register-form">
                                                        <form>
                                                            <input
                                                                type="text"
                                                                name="user-name"
                                                                placeholder="Name"
                                                                onChange={e => { setUsrName(`${e.target.value}`) }}
                                                            />
                                                            <input
                                                                type="password"
                                                                name="user-password"
                                                                placeholder="Password"
                                                                onChange={e => { setUsrPwd(`${e.target.value}`) }}
                                                            />
                                                            <input
                                                                name="user-email"
                                                                placeholder="Email"
                                                                type="email"
                                                                onChange={e => { setUsrEmail(`${e.target.value}`) }}
                                                            />
                                                            <input
                                                                name="user-phone"
                                                                placeholder="Phone"
                                                                type="email"
                                                                onChange={e => { setUsrEmail(`${e.target.value}`) }}
                                                            />
                                                            <input
                                                                name="user-email"
                                                                placeholder="Column"
                                                                type="Column"
                                                                onChange={e => { setUsrEmail(`${e.target.value}`) }}
                                                            />
                                                            <input
                                                                name="user-email"
                                                                placeholder="Column"
                                                                type="column"
                                                                onChange={e => { setUsrEmail(`${e.target.value}`) }}
                                                            />
                                                            <div className="button-box">
                                                                <button type="submit" onClick={sendData}>
                                                                    <span>Register</span>
                                                                </button>
                                                            </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </Tab.Pane>
                                        </Tab.Content>
                                    </Tab.Container>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </LayoutOne>
        </Fragment>
    );
};

UserLoginRegister.propTypes = {
    location: PropTypes.object
};

export default UserLoginRegister;