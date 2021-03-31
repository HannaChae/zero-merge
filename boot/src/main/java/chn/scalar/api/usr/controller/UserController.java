package chn.scalar.api.usr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import chn.scalar.api.cmm.controller.AbstractController;
import chn.scalar.api.usr.domain.UserVo;
import chn.scalar.api.usr.repository.UserRepository;
import chn.scalar.api.usr.service.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usr")
public class UserController extends AbstractController<UserVo> {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final UserRepository userRepository;
	private final UserServiceImpl userService;
	
//	@PostMapping("/user/sendSignUpEmail")
//	public String sendSignUpEmail(@ModelAttribute @Valid Account account, BindingResult errors, Model model) throws DuplicateEmailException, SendEmailException{
//        if (errors.hasErrors()) {
//            Map<String, String> validatorResult = accountSecurityService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//            }
//            return "/user/register";
//        }
	
	
	@PostMapping("/save")
	public ResponseEntity<Long> save(@RequestBody UserVo userVo) {
		logger.info("User Register: " + userVo.toString());
		return ResponseEntity.ok(userService.save(userVo));
	}

	@PostMapping("/login")
	public ResponseEntity<Long> login(@RequestBody UserVo userVo) {
		logger.info("Login user" + userVo.toString());
		return ResponseEntity.ok(userService.login(userVo));
	}

	@GetMapping("/find/{name}")
	public ResponseEntity<List<UserVo>> findByName(@RequestBody UserVo userVo) {
		logger.info("Find user by name: " + userVo.getUsrName());
		return ResponseEntity.ok(userService.findUsersByName(userVo.getUsrName()));
	}

//	// 2.Read(3) - 비밀번호 찾기(로그인 시)
//	@GetMapping("/find/{password}")
//	public ResponseEntity<Optional<User>> findPassword(@RequestBody User user) {
//		logger.info("Find password:" + user.toString());
//		return ResponseEntity.ok(userService.findPassword(user.getUsrPwd()));
//	}

	@GetMapping("/all")
	public ResponseEntity<List<UserVo>> findAll() {
		logger.info("Find all users.");
		return ResponseEntity.ok(userService.findAll());
	}

	@PostMapping("/update/profile")
	public ResponseEntity<Optional<UserVo>> updateProfile(@RequestBody UserVo userVo) {
		logger.info("Update user profile: " + userVo.toString());
		return ResponseEntity.ok(userService.updateProfile(userVo));
	}
	
	@PostMapping("/update/password")
	public ResponseEntity<Optional<UserVo>> updatePassword(@RequestBody UserVo userVo) {
		logger.info("Update user profile: " + userVo.toString());
		return ResponseEntity.ok(userService.updateProfile(userVo));
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody UserVo userVo) {
		logger.info("Delete user :" + userVo.toString());
		return ResponseEntity.ok(userService.delete(userVo));
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<UserVo> getOne(@PathVariable long id) {
		return ResponseEntity.ok(userService.getOne(id));
	}

	@GetMapping("/check/findPw")
	public @ResponseBody Map<String, Boolean> passwordFind(@RequestBody UserVo userVo) {
		Map<String, Boolean> map = new HashMap<>();
		boolean userCheck = userService.userEmailCheck(userVo.getUsrEmail(), userVo.getUsrName());
		logger.info("Match(Email, Name) : " + userCheck);
		map.put("check", userCheck);
		return map;
	}

	
	
	
	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		logger.info("Query total count.");
		return ResponseEntity.ok(userService.count());
	}
	
	@Override public ResponseEntity<Optional<UserVo>> findById(long id) { return null; }
	@Override public ResponseEntity<Boolean> existsById(long id) { return null; }

}