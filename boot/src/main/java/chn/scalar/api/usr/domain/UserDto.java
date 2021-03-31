package chn.scalar.api.usr.domain;

import java.util.*;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;
//import javax.validation.constraints.Pattern;
//import javax.validation.constraints.Size;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@Lazy
@Getter
@Setter
@NoArgsConstructor
public class UserDto {

	private static final long serialVersionUID = 1L;
	private Long usrNo;

	// @Size(min = 2, max = 8, message = "이름을 2~8자 사이로 입력해주세요.")
	private String usrName;


	private String usrEmail;

	private String usrPwd;
	private String usrAges;
	private String usrCity;
	private String usrGender;
	private String usrPhone;
	private String usrAddr;
	private String usrNickname;
	private String usrId;

	@Builder
	public UserDto(String usrName, String usrEmail, String usrPwd, String usrPhone, String usrNickname) {
		super();
		this.usrName = usrName;
		this.usrEmail = usrEmail;
		this.usrPwd = usrPwd;
		this.usrPhone = usrPhone;
		this.usrNickname = usrNickname;
	}

	public UserDto(String usrEmail, String usrNickname) {
		this.usrEmail = usrEmail;
		this.usrNickname = usrNickname;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDto that = (UserDto) o;
		return Objects.equals(usrNo, that.usrNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(usrNo);
	}



}