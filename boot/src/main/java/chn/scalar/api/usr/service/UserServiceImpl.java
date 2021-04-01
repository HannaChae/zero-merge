package chn.scalar.api.usr.service;

import chn.scalar.api.cmm.service.AbstractService;
import chn.scalar.api.security.domain.SecurityProvider;
import chn.scalar.api.security.exception.SecurityRuntimeException;
import chn.scalar.api.usr.domain.Role;
import chn.scalar.api.usr.domain.UserDto;
import chn.scalar.api.usr.domain.UserVo;
import chn.scalar.api.usr.repository.UserRepository;
import lombok.Getter;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Service
@Getter
public class UserServiceImpl extends AbstractService<UserVo> implements UserService {
	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final SecurityProvider provider;
	private final AuthenticationManager manager;

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


	@Override
	public List<UserVo> findUsersByName(String name) {
		return userRepository.findByName(name);
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
		return userRepository.updateProfile(userVo.getUsrEmail(), userVo.getPassword());
	}

	@Override
	public long delete(UserVo userVo) {
		userRepository.delete(userVo);
		return getOne(userVo.getUsrNo()) != null ? 1 : 0;
	}


	@Override public UserDto create(UserDto user) { return null; }
	@Override public UserVo getOne(long id) { return userRepository.getOne(id); }
	@Override public boolean idCheck(UserVo userVo) { return false; }




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

	// security default method




	@Override
	public String signin(String username, String password) {
		try {
			//	manager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			System.out.println("ID:  "+username);
			String tok = provider.createToken(username, userRepository.findByUsername(username).getRoles());
			System.out.println("token :: "+tok);
			return tok;
		} catch (AuthenticationException e) {
			throw new SecurityRuntimeException("Invalid username/password supplied", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@Override
	public String signup(UserVo user) {
		if (!userRepository.existsByUsername(user.getUsername())) {
			user.setPassword(passwordEncoder.encode(user.getPassword()));
			List<Role> list = new ArrayList<>();
			list.add(Role.USER);
			user.setRoles(list);
			userRepository.save(user);
			return provider.createToken(user.getUsername(), user.getRoles());
		} else {
			throw new SecurityRuntimeException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	@Override
	public void delete(String username) {
		userRepository.deleteByUsername(username);
	}
	@Override
	public UserVo search(String username) {
		UserVo user = userRepository.findByUsername(username);
		if (user == null) {
			throw new SecurityRuntimeException("The user doesn't exist", HttpStatus.NOT_FOUND);
		}
		return user;
	}
	@Override
	public UserVo whoami(HttpServletRequest req) {
		return userRepository.findByUsername(provider.getUsername(provider.resolveToken(req)));
	}
	@Override
	public String refresh(String username) {
		return provider.createToken(username, userRepository.findByUsername(username).getRoles());
	}

}