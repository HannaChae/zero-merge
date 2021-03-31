package chn.scalar.api.usr.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import chn.scalar.api.lvl.domain.Level;
import chn.scalar.api.lvl.domain.Level;
import chn.scalar.api.pay.domain.Payment;

import lombok.Builder;
import lombok.Getter;

@Entity
@Getter
public class UserVo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usr_no")
	private Long usrNo;

	@Column(name = "usr_name")
	private String usrName;

	@Column(name = "usr_nickname")
	private String usrNickname;

	@Column(name = "usr_email")
	private String usrEmail;

	@Column(name = "usr_pwd")
	private String usrPwd;

	@Column(name = "usr_ages")
	private String usrAges;

	@Column(name = "usr_city")
	private String usrCity;

	@Column(name = "usr_gender")
	private String usrGender;

	@Column(name = "usr_phone")
	private String usrPhone;

	@Column(name = "usr_id")
	private String usrId;

	@Column(name = "usr_addr")
	private String usrAddr;

	@ManyToOne
	@JoinColumn(name = "level")
	private Level level;

	 @OneToMany(mappedBy = "userVo")
	 private List<Payment> payments = new ArrayList<>();

	@Builder
	public UserVo(Long usrNo, String usrName, String usrNickname, String usrGender, String usrPhone, String usrEmail,
				  String usrAges, String usrCity, String usrAddr) {
		this.usrNo = usrNo;
		this.usrName = usrName;
		this.usrNickname = usrNickname;
		this.usrGender = usrGender;
		this.usrPhone = usrPhone;
		this.usrEmail = usrEmail;
		this.usrAges = usrAges;
		this.usrCity = usrCity;
		this.usrAddr = usrAddr;
	}

	public UserVo() {
	}

}