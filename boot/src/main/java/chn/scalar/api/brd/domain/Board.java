package chn.scalar.api.brd.domain;

import javax.persistence.Column;   
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;

import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.prd.domain.Product;
import chn.scalar.api.rpl.domain.Reply;
import chn.scalar.api.usr.domain.UserVo;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;



@Entity  @Getter
//@NamedQuery(name = "Board.findByTitle", query = "select b2 from Board b2 where b2.brd_title like :brdTitle")
public class Board {
	@Id @Column(name="brd_no") @GeneratedValue(strategy = GenerationType.IDENTITY) private long brdNo;
	@Column(name="brd_title") private String  brdTitle;
	@Column(name="brd_content") private String brdContent;
	@Column(name="brd_wrt_date") private String brdWrtDate;
	@Column(name="brd_rank") private String brdRank;
	@Column(name="brd_img") private String brdImg;
	@Column(name="brd_kind") private long brdKind;
	@Column(name="brd_count") private long brdCount;
	@Column(name="brd_like") private String brdLike;
	@Column(name="brd_pwd") private String brdPwd;
	@Column(name="usr_nickname") private String usrNikcname;
	
	@OneToMany(mappedBy="board")
	private List<Reply> replies = new ArrayList<>();
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="usr_no")
	private UserVo userVo;
	@ManyToOne
	@JoinColumn(name="pay_no")
	private Payment payment;
	@ManyToOne
	@JoinColumn(name="prd_no")
	private Product product;
	
	public void setBrdWrtDate(String brdWrtDate) {
		this.brdWrtDate = brdWrtDate;
	}
	public void setBrdCount(long brdCount) {
		this.brdCount = brdCount;
	}
	public void setBrdTitle(String brdTitle) {
		this.brdTitle = brdTitle;
	}
	public void setBrdContent(String brdContent) {
		this.brdContent = brdContent;
	}
	@Override
	public String toString() {
		return "Board [brdNo=" + brdNo + ", brdTitle=" + brdTitle + ", brdContent=" + brdContent + ", brdWrtDate="
				+ brdWrtDate + ", brdRank=" + brdRank + ", brdImg=" + brdImg + ", brdKind=" + brdKind + ", brdCount="
				+ brdCount + ", brdLike=" + brdLike + ", brdPwd=" + brdPwd + ", usrNikcname=" + usrNikcname
				+ ", replyList=" + replies + ", user=" + userVo + ", payment=" + payment + ", product=" + product + "]";
	}

	
	
}
