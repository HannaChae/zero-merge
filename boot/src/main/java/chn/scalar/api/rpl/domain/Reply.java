package chn.scalar.api.rpl.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import chn.scalar.api.brd.domain.Board;
import chn.scalar.api.usr.domain.UserVo;

import lombok.Getter;

@Entity @Getter
public class Reply {
	@Id @Column(name="rpl_no") @GeneratedValue(strategy = GenerationType.IDENTITY) private long rplNo;
	@Column(name="rpl_content") private String rplContent;
	
	
	@ManyToOne
	@JoinColumn(name="brd_no")
	private Board board;

	@ManyToOne
	@JoinColumn(name = "usr_no")
	private UserVo userVo;
	

}