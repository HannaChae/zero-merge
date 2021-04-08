import PropTypes from "prop-types"
import React from "react"
import { Link } from "react-router-dom"
import  { useHistory } from "react-router"
import axios from "axios"

const BlogPostDetail = ({ boards }) => {
  const history = useHistory()

  const remove = e => {
    e.preventDefault()
    const removeConfirm = window.confirm(`해당 게시글을 삭제하시겠습니까?`)
      if(removeConfirm) {
        axios({
          url: 'http://localhost:8080/boards/delete/' + boards.brdNo,
          method: 'delete',
          headers: {
            'Content-Type'  : 'application/json',
            'Authorization' : 'JWT fefege..'
          },
          data: {}
        })
        .then(res => {
          console.log(boards.brdNo + `번 게시글 삭제 성공`)
          history.push(`/blog-all`)
        })
        .catch(err => {
          console.log(`게시글 삭제 실패: ` + err)
          throw err
        })
      }
  }

  return (<>
      <div className="blog-details-top">
        <div className="blog-details-img">
          <img src={boards.brdImg} alt={boards.brdImg} /> 
        </div>

        <div className="blog-details-content">
          <div className="blog-meta-2">
            <ul>
              <li> {boards.brdWrtDate} </li>
              <li>
                <Link to={process.env.PUBLIC_URL + "/blog-detail"}>
                  <i className="fa fa-comments-o" />
                </Link>
              </li>
            </ul>
          </div>
          <h3 type="text"> {boards.brdTitle} </h3>
          <h4>{boards.usrNickname}</h4>
          <p>
            {boards.brdContent}
          </p>
        </div>
      </div>

      <div className="tag-share">
        <div>
          <a href="#" ><Link to={"/blog-update/" + boards.brdNo}>글 수정하기</Link></a><br/>
          <a href="#" onClick={remove}>글 삭제하기</a>
        </div>
        
        <div className="blog-share">
          <span>share :</span>
          <div className="share-social">
            <ul>
              <li>
                <a className="facebook" href="//facebook.com">
                  <i className="fa fa-facebook" />
                </a>
              </li>
              <li>
                <a className="twitter" href="//twitter.com">
                  <i className="fa fa-twitter" />
                </a>
              </li>
              <li>
                <a className="instagram" href="//instagram.com">
                  <i className="fa fa-instagram" />
                </a>
              </li>
            </ul>
          </div>
        </div>
      </div>
    <div className="next-previous-post"/>
  </>)
}

BlogPostDetail.propTypes = {
  location: PropTypes.object,
  board: PropTypes.object
}

export default BlogPostDetail