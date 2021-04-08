import React, { useState, useEffect } from "react"
import MetaTags from "react-meta-tags"
import { Layout } from "__common__/index"
import { Sidebar } from "__user__/index"
import axios from "axios"

const UserAdmin = () => {
  const [user, setUser] = useState([])

  useEffect(() => {
    axios.get('http://localhost:8080/usr/all', )
    .then((res) => {
      console.log(`유저 조회 성공`)
      setUser(res.data)
    })
    .catch((err) => {
      console.log(`유저 조회 실패: ` + err)
      throw err
    })
  }, [])

  const renderBody = () => {
    return user.map(i => {
      return (
        <table>
          <tr key={i.usrNo}>
            <td>{i.usrName}</td>
            <td>{i.usrEmail}</td>
          </tr>
        </table>
      )
    })
  }

  return (<>
    <MetaTags>
      <title>Flone | Admin</title>
    </MetaTags>
    
    <Layout
      headerContainerClass="container-fluid"
      headerPaddingClass="header-padding-1"
    >
      <Sidebar />
      <table style={{ display: "flex" }}>
        {user ? 
          { renderBody } 
          : <span>---</span>
        }
      </table>
    </Layout>
  </>)
}

export default UserAdmin