import React, { useState, Fragment,useEffect } from 'react'
import { Link, Route, Router } from "react-router-dom";
import {makeStyles} from '@material-ui/styles'
import axios from 'axios';
import { useForm } from 'react-hook-form'
import  { useHistory} from 'react-router'
import { BarChartRounded } from '@material-ui/icons';
const useStyles = makeStyles (()=>({
        image: {height:40, width:40}
}))

export const BlogPostDetail = () => {
const [board, setBoard] = useState([])
const URL =  `/board/opt/`+localStorage.getItem('brdNo')
const Ur = `http://localhost:8080/board/delete/`+localStorage.getItem('brdNo')
const history = useHistory()
const [brdNo, setBrdNo] = useState('')
  const [brdTitle, setBrdTitle] = useState('')
  const [brdContent, setBrdContent] = useState('')
  const [brdWrtDate, setBrdWrtDate] = useState('')
  const [brdRank, setBrdRank] = useState('')
  const [brdImg, setBrdImg] = useState('')
  const [brdLike, setBrdLike] = useState('')
  const [brdNikcname, setBrdNikcname] = useState('')

  const { register,handleSubmit} = useForm() 



useEffect(()=>{
 axios.get(URL, )
 .then(({data}) => {
  setBoard(data)
  setBrdNo(data)
 })
 .catch((error) => {
   alert('실패')
   throw error;
 })
 
},[])

const remove = () => {
  const removeBlog = window.confirm("해당 글을 삭제하시겠습니까?")
  if(removeBlog){axios.delete(Ur, {data: brdNo}
        )
  .then(resp => {
    alert('글이 삭제 되었습니다')
    history.push('/blog-list')
  })
  .catch(err => {
    alert('글 삭제 실패')
    throw err
  })
  }
}
  return (
    <Fragment>
        {board ? (<>
        <div className="blog-details-top">
        <div className="blog-details-img">
        <img
                src={board.brdImg} alt={board.brdImg} /> 
        </div>
        <div className="blog-details-content">
          <div className="blog-meta-2">
            <ul>
              <li>{board.brdWrtDate}</li>
              <li>
                <Link to={process.env.PUBLIC_URL + "/blog-details-standard"}>
                   <i className="fa fa-comments-o" />
                </Link>
              </li>
            </ul>
          </div>
          <h3 type="text">{board.brdTitle}</h3>
          <p>
          {board.brdContent}
          </p>
         
        </div>
      </div>
    
      <div className="tag-share">
      <div>
      <a href="#" ><Link to={"/blog-update/"+board.brdNo}>글 수정하기</Link></a><br/>
       <a href="#"  onClick={remove}>글 삭제하기</a>
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
      
      <div className="next-previous-post">
    
      </div> </> ) : '해당 게시글을 찾을 수 없습니다.'}
        </Fragment>

    
  );
};

export default BlogPostDetail;
