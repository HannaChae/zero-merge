package chn.scalar.api.usr.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import chn.scalar.api.usr.domain.UserVo;
import chn.scalar.api.usr.repository.UserRepository;
// import org.springframework.mail.SimpleMailMessage;
// import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import chn.scalar.api.cmm.domain.Swear;
import chn.scalar.api.cmm.service.AbstractService;
import chn.scalar.api.usr.domain.UserDto;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceImpl extends AbstractService<UserVo> implements UserService {
	private final UserRepository userRepository;
	// private JavaMailSender mailSender;
	
	

	@Override
	public long save(UserVo userVo) {
		return userRepository.save(userVo) != null ? 1 : 0;
	}
	
	@Override
	public boolean checkDuplicateId(String userId) {
		if (userId != null) {
			return userRepository.checkId(userId);
		}
		return false;
	}

	@Override
	public boolean checkDuplicateEmail(String userId) {
		if (userId != null) {
			return userRepository.findByEmail(userId);
		}
		return false;
	}

	public boolean userEmailCheck(String userEmail, String userName) {
		
		
		if (userEmail != null && userName != null) {
			Optional<UserVo> findUser = userRepository.findUserByEmail(userEmail);
			return findUser.isPresent() && findUser.get().getUsrName().equals(userName) ? true : false;
		}
		return false;
	}

	public long login(UserVo userVo) { return 3; }

	@Override
	public List<UserVo> findUsersByName(String name) {
		return userRepository.findByName(name);
	}

	@Override
	public String findIdByEmail(String userEmail) {
		if (userEmail != null) {
			return userRepository.findIdByEmail(userEmail);
		}
		return "";
	}

	@Override
	public List<UserVo> findAllUser() {
		return userRepository.findAllUser();
	}

	@Override
	public List<UserVo> findAll() {
		return userRepository.findAll().stream().sorted(Comparator.comparing(UserVo::getUsrName).reversed())
				.collect(Collectors.toList());
	}

	@Override
	public Optional<UserVo> updateProfile(UserVo userVo) {
		return userRepository.updateProfile(userVo.getUsrEmail(), userVo.getUsrPwd());
	}

	@Override
	public long delete(UserVo userVo) {
		userRepository.delete(userVo);
		return getOne(userVo.getUsrNo()) != null ? 1 : 0;
	}
	
	
	
	
	
	
	
	/**				 
	 * 
	 *  회원가입 Logic
	 *  
	 * */
	
//	@Override
//	public boolean idFormatCheck(String id) {
//		String reg = "^[a-zA-Z0-9][\\w]{7,17}$";
//		return Pattern.compile(reg).matcher(id).matches();
//	}
//	
//	@Override
//	public boolean mailFormatCheck(String email) {
//		String reg = "^[a-zA-Z0-9]*[\\w-]{4,17}$";
//		return Pattern.compile(reg).matcher(email).matches() ? true : false;
//	}
//
//	@Override
//	public boolean nickNameFormatCheck(String nickName) {
//		String reg = "^[\\w가-힣]{2,15}$";
//		return Pattern.compile(reg).matcher(nickName).matches() ? true : false;
//	}

//	@Override
//	public boolean phoneFormatCheck(String phone) {
//		String reg = "[^0-9a-zA-Z])(01[0|1|6|7|8|9][\\s-:\\.]?)(\\d{3,4}[\\s-:\\.]?)(\\d{4})(?=[^0-9a-zA-Z])$";
//		return Pattern.compile(reg).matcher(phone).matches() ? true : false;
//	}

//	@Override
//	public boolean nameFormatCheck(String usrName) {
//		String reg = "^[a-zA-Z가-힣]{2,12}$";
//		return Pattern.compile(reg).matcher(usrName).matches() ? true : false;
//	}
	
	
	



	

	
	public Map<?, ?> userDetail(UserDto usrDto) {
		var map = new HashMap<>();
		return map;
	}

	
	@Override public UserDto create(UserDto user) { return null; }
	@Override public UserVo getOne(long id) { return userRepository.getOne(id); }
	@Override public boolean idCheck(UserVo userVo) { return false; }


	@Override
	public boolean swearFilter(String word) {
		if (word != null) {
			String reg = String.format("^[\\w가-힣\\s]*%s[\\s\\w가-힣\\s]*$", word);
			return Swear.KOREAN_SWEAR_LIST.getSwearList().stream()
					.anyMatch(x -> Pattern.compile(reg).matcher(word).matches());
		}
		return false;
	}

	@Override
	public boolean emailCheck(UserVo userVo) {
		return false;
	}

	@Override
	public void updatePassword(String str, String userEmail) {
		
	}

	@Override
	public String createTempPassword() {
		return null;
	}

	@Override
	public long count() {
		return 0;
	}

	@Override
	public Optional<UserVo> findById(long id) {
		return null;
	}

	@Override
	public boolean existsById(long id) {
		return false;
	}

}