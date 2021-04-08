import React, { useCallback, useState } from "react"
import  { useHistory } from "react-router"
import axios from "axios"

const BlogPostWrite = () => {
  const history = useHistory()
  const [boardAdd, setBoardAdd] = useState({
    brdTitle: "",
    brdContent: "",
    brdWrtDate: "",
    brdRank: "",
    brdImg: "",
    brdLike: "",
    usrNickname: ""
  })
  const { brdTitle, brdContent, brdWrtDate, brdRank, brdImg, brdLike, usrNickname } = boardAdd
  const onChange = useCallback(e => {
    setBoardAdd({...boardAdd, [e.target.name]: e.target.value})
  })

  const write = e => {
    e.preventDefault()
    axios({
      url: 'http://localhost:8080/boards/save',
      method: 'post',
      headers: {
        'Content-Type'  : 'application/json',
        'Authorization' : 'JWT fefege..'
      },
      data: boardAdd
    })
    .then((res) => {
      console.log(`게시글 작성 성공`)
      history.push('/blog-all')
    })
    .catch((err) => {
          console.log(`게시글 작성 실패: ` + err)
          throw err
    })
  }
  
  return (<>
    <div className="blog-details-top">
        <form>
          <div>
            <h5>사진 업로드: 
              <input
                type="file"
                accept="image/*"
                name="brdImg"
                value={brdImg}
                onChange={onChange}
              />
            </h5>
          </div>
          <div className="blog-details-content">
            <tr>
              <h3>
                <input 
                  type="text"
                  name="brdTitle"
                  placeholder="글 제목 입력"
                  value={brdTitle}
                  onChange={onChange}
                />
              </h3>
            </tr>
            <tr>
            <textarea
              rows="30" cols="200"
              name="brdContent"
              placeholder="글 내용 입력"
              value={brdContent}
              onChange={onChange}
            />
            </tr>
          </div>
        </form>
    </div>
    <div className="dec-img-wrapper">
      <div className="row">
        <div className="col-md-6">
        </div>
      </div>
    </div>
    <button type="submit" onClick={write}>글 작성 완료</button>
  </>
  )
}

export default BlogPostWrite