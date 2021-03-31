import React, { useState, Fragment,useEffect } from 'react'
import { Link, Route, Router } from "react-router-dom";
import {makeStyles} from '@material-ui/styles'
import axios from 'axios';
import { useForm } from 'react-hook-form'
import  { useHistory} from 'react-router'
const useStyles = makeStyles (()=>({
        image: {height:40, width:40}
}))

export const BlogPostUpdate = ({match,props}) => {
const [board, setBoard] = useState([])
const URL =  `/board/opt/`+localStorage.getItem('brdNo')
const HT = `http://localhost:8080/board/update/`+localStorage.getItem(`brdNo`)
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
const brdWrt = e => {
  e.preventDefault()
  axios({
    url: `http://localhost:8080/board/update`+localStorage.getItem('brdNo'),
    method: 'PUT',
    headers: {'Content-Type': 'application/json','Authorization': 'JWT fefege..'},
  data: {brdTitle,brdContent,brdWrtDate,brdRank,brdImg,brdLike,brdNikcname}
  })
  .then(resp => {
    alert('글수정 성공')
    history.push('/blog-list')
  })
  .catch(err => {
    alert('글수정 실패')
  })
  }
  const blogUpdate = () => {
    const blogPostUpdate = window.confirm("해당 글을 수정하시겠습니까?")
    if(blogPostUpdate)axios.put(`http://localhost:8080/board/update/`+localStorage.getItem('brdNo'),
      {
      brdNo: localStorage.getItem('brdNo'),brdTitle,brdContent,brdWrtDate,brdRank,brdImg,brdLike,brdNikcname}
    )
    .then(resp => {
      alert('수정되었습니다')
      history.push('/blog-list')
    })
    .catch(err => {
      alert(`글수정 실패`)
    })
    }
  return (
    <Fragment>
    <div>
      <div>
        {
          board ? (
            <>
              {/* <div>
                <label>번호: </label>
                <label onChange = { e => {setBrdNo(`${board.brdNo}`)}}>{board.brdNo}</label>
              </div> */}
              <div>
                <label>작성날짜: </label>
                <label>{board.brdWrtDate}</label>
              </div>
              <div >
                <label>제목: </label>
                <label><input type="text" placeholder={board.brdTitle}   onChange = { e => {setBrdTitle(`${e.target.value}`)}}/></label>
              </div> 
              
              <div >
                <label>내용: </label>
                <div>
                <textarea rows="55" cols="250"  placeholder={board.brdContent}  onChange = { e => {setBrdContent(`${e.target.value}`)}}
          />
                </div>
              </div>
              <a href="#"  key={board.brdNo} onClick={blogUpdate} >수정완료</a>
            </>
          ) : '해당 게시글을 찾을 수 없습니다.'
        }
        </div>
        </div>
        </Fragment>

    
  );
};

export default BlogPostUpdate;
