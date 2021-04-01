package chn.scalar.api.usr.controller;
import java.util.List;
import java.util.Optional;

import io.swagger.annotations.*;
import chn.scalar.api.usr.domain.UserDto;
import chn.scalar.api.usr.domain.UserVo;
import chn.scalar.api.usr.service.UserServiceImpl;
import org.modelmapper.ModelMapper;
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
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/usr")
@Api(tags="usr")
public class UserController{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private final UserServiceImpl userService;
	private final ModelMapper modelMapper;

	@PostMapping("/signin")
	@ApiOperation(value="${UserController.signin}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 422, message = "Invalid username/password supplied") })
	public ResponseEntity<String> signin(@RequestBody UserVo user) {
		logger.info("User Login Info: " + user.toString());
		return ResponseEntity.ok(userService.signin(user.getUsername(), user.getPassword()));
	}

	@PostMapping("/signup")
	@ApiOperation(value = "${UserController.signup}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 422, message = "Username is already in use") })
	public ResponseEntity<String> signup(@ApiParam("Signup User") @RequestBody UserDto user) {
		logger.info("User Join Info:" + user.toString());
		return ResponseEntity.ok(userService.signup(modelMapper.map(user, UserVo.class)));
	}

	@GetMapping("/find/{name}")
	public ResponseEntity<List<UserVo>> findByName(@RequestBody UserVo userVo) {
		logger.info("Find user by name: " + userVo.getUsrName());
		return ResponseEntity.ok(userService.findUsersByName(userVo.getUsrName()));
	}



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


	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		logger.info("Query total count.");
		return ResponseEntity.ok(userService.count());
	}



}