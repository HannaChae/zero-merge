import React, { useCallback, useState } from "react"
import { Link } from "react-router-dom"
import { useHistory } from "react-router"
import axios from "axios"

const Login = () => {
  const history = useHistory()
  const [userLogin, setUserLogin] = useState({
    username: "",
    password: "",
  })
  
  const { username, password } = userLogin
  const onChange = useCallback(e => {
    setUserLogin({...userLogin, [e.target.name]: e.target.value})
  })

  const loginUser = e => {
    e.preventDefault()
    axios({
      url:"http://localhost:8080/usr/signin",
      method:'post',
      headers: {
          'Content-Type'  : 'application/json',
          'Authorization' : 'JWT fefege..'
        },
      data: userLogin
    })
    .then(res => {
      if(res.data.token) {
        localStorage.setItem("user", JSON.stringify(res.data.user))
        localStorage.setItem("token", res.data.token.accessToken)
        console.log(`유저 로그인 성공_id: ` + username)
        history.push(`/`)
      }else {
        alert(`토큰값 없음`)
      }
    })
    .catch(err => {
      alert(`유저 로그인 실패: ` + err)
      throw err
    });
}

  return (<>
    <form>
      <h5>ID</h5>
      <input
        type="text"
        name="username"
        placeholder="ID를 입력하세요"
        onChange={onChange}
      />
      <h5>PASSWORD</h5>
      <input
        type="password"
        name="password"
        placeholder="비밀번호를 입력하세요"
        onChange={onChange}
      />
      <div className="button-box">
        <div className="login-toggle-btn">
            <input type="checkbox" />
            <label className="ml-10">Remember me</label>
            <Link to={process.env.PUBLIC_URL + "/"}>
              Forgot Password ?
            </Link>
        </div>
        <button type="submit" onClick={loginUser}>
          <span>Login</span>
        </button>
      </div>
    </form>
  </>)
}

export default Login