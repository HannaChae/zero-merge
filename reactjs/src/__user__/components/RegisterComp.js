import React, { useCallback, useState } from "react"
import axios from "axios"

const RegisterComp = () => {
  /* JSON으로 property에 대한 속성 정의 (기존 코드는 String으로 하나하나 줬음) */
  const [userRegister, setUserRegister] = useState({
    username: "",
    password: "",
    usrName: "",
    usrEmail: ""
  })

  const { username, password, usrName, usrEmail } = userRegister //getter의 역할 -> 구조분해할당
  const onChange = useCallback(e => {
    setUserRegister({...userRegister, [e.target.name]: e.target.value})
  }) //setter의 역할 -> JSON 내부에서 스프레드를 사용해 setter 설정(자바에서 빌더 역할)

  const registerUser = e => {
    e.preventDefault()
    axios({
      url: 'http://localhost:8080/usr/signup', 
      method: 'post',
      headers: {
        'Content-Type'  : 'application/json',
        'Authorization' : 'JWT fefege..'
      },
      data: userRegister
    })
    .then(res => {
      alert(usrName + ` 님 가입을 환영합니다! 로그인 해주세요.`)
      console.log(`유저 가입 성공: `)
    })
    .catch(err => {
      console.log(`유저 가입 실패: ` + err)
      throw err
    })
  }

  return (<>
    <form>
      <h5>ID</h5>
      <input
        type="text"
        name="username"
        value={username}
        placeholder="ID를 입력하세요"
        onChange={onChange}
      />
      <h5>PASSWORD</h5>
      <input
        type="password"
        name="password"
        value={password}
        placeholder="비밀번호를 입력하세요"
        onChange={onChange}
      />
      <h5>E-MAIL</h5>
      <input
        type="email"
        name="usrEmail"
        value={usrEmail}
        placeholder="이메일 주소를 입력하세요"
        onChange={onChange}
      />
      <h5>NAME</h5>
      <input
        type="text"
        name="usrName"
        value={usrName}
        placeholder="이름을 입력하세요"
        onChange={onChange}
      />
      <div className="button-box">
        <button type="submit" onClick={registerUser}>
          <span>Register</span>
        </button>
      </div>
    </form>
  </>)
}

export default RegisterComp