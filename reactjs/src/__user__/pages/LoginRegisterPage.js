import PropTypes from "prop-types"
import React, { useState } from "react"
import MetaTags from "react-meta-tags"
import { BreadcrumbsItem } from "react-breadcrumbs-dynamic"
import Tab from "react-bootstrap/Tab"
import Nav from "react-bootstrap/Nav"
import { Layout, Breadcrumb } from "__common__/index"
import { LoginComp, RegisterComp } from "__user__/index"

const LoginRegister = ({ location }) => {
  const { pathname } = location
  const [user, setUser] = useState([])

  return (<>
    <MetaTags>
        <title>Flone | Login Page</title>
    </MetaTags>

    <BreadcrumbsItem to={process.env.PUBLIC_URL + "/"}>Home</BreadcrumbsItem>
    <BreadcrumbsItem to={process.env.PUBLIC_URL + pathname}>Login | Register</BreadcrumbsItem>

    <Layout headerTop="visible">
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
                                                <LoginComp />
                                            </div>
                                        </div>
                                    </Tab.Pane>
                                    <Tab.Pane eventKey="register">
                                        <div className="login-form-container">
                                            <div className="login-register-form">
                                              <RegisterComp />
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
    </Layout>
</>)
}

LoginRegister.propTypes = {
    location: PropTypes.object
}

export default LoginRegister