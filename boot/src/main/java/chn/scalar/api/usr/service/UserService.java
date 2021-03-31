package chn.scalar.api.usr.service;

import java.util.List;
import java.util.Optional;

import chn.scalar.api.usr.domain.UserVo;
import chn.scalar.api.usr.domain.UserDto;

public interface UserService {
	
	public boolean checkDuplicateId(String userId);
	public boolean checkDuplicateEmail(String userId);
	public List<UserVo> findUsersByName(String name);
	public List<UserVo> findAllUser();
	public String findIdByEmail(String userEmail);
	public UserDto create(UserDto user);
	
	
	public Optional<UserVo> updateProfile(UserVo userVo);
	
	public boolean emailCheck(UserVo userVo);
	public boolean idCheck(UserVo userVo);
	public boolean swearFilter(String keyword);
	

	public void updatePassword(String str, String userEmail);
	public String createTempPassword();
	
}