import React, { useState, useCallback } from "react"
import  { useHistory } from "react-router"
import axios from "axios"

const BlogPostUpdate = ({ boards }) => {
  const history = useHistory()
  const [board, setBoard] = useState([])

  const [boardUpdate, setBoardUpdate] = useState({
    brdTitle: board.brdTitle,
    brdContent: board.brdContent,
    brdWrtDate: board.brdWrtDate,
    brdRank: board.brdRank,
    brdImg: board.brdImg,
    brdLike: board.brdLike,
    usrNickname: board.usrNickname
  })
  const { brdTitle, brdContent, brdWrtDate, brdRank, brdImg, brdLike, usrNickname } = boardUpdate
  const onChange = useCallback(e => {
    setBoardUpdate({...boardUpdate, [e.target.name]: e.target.value})
  })

  const blogUpdate = e => {
    e.preventDefault()
    axios({
      url: 'http://localhost:8080/boards/update/' + localStorage.getItem(`brdNo`),
      method: 'put',
      headers: {
        'Content-Type': 'application/json',
        'Authorization': 'JWT fefege..'
      },
      data: { 
        brdNo: localStorage.getItem(`brdNo`), 
        brdTitle, brdContent, brdWrtDate, brdRank, brdImg, brdLike, usrNickname
      }
    })
    .then((res) => {
      console.log(boards.brdNo + `번 게시글 수정 성공`)
      history.push(`/blog-all`)
    })
    .catch(err => {
      console.log(boards.brdNo + `번 게시글 수정 실패: ` + err)
      throw err
    })
  }

  return (<>
    <div>
      <label>제목: </label>
      <label>
        <input
          type="text"
          name="brdTitle"
          value={brdTitle}
          placeholder={boards.brdTitle}
          onChange={onChange}
        />
      </label>
    </div> 
    <div >
      <label>내용: </label>
      <div>
        <textarea 
          rows="55" cols="250"
          name="brdContent"
          value={brdContent}
          placeholder={boards.brdContent}
          onChange={onChange}
        />
      </div>
    </div>
    <div>
      <button onClick={blogUpdate}>수정완료</button>
    </div>
  </>)
}

export default BlogPostUpdate