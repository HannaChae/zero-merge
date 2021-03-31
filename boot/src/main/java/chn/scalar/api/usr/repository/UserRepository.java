package chn.scalar.api.usr.repository;

import java.util.List;
import java.util.Optional;

import chn.scalar.api.usr.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

interface IUserRepository {
	public List<UserVo> findByName(String name);
	public boolean findByEmail(String email);
	public boolean checkId(String id);
	public String findIdByEmail(String email);
	public Optional<UserVo> findUserById(String email);
	public Optional<UserVo> findUserByEmail(String email);
	public Optional<UserVo> findPassword(String password);
	public Optional<UserVo> updateProfile(String email, String password);
	public Optional<UserVo> updatePassword(String password);
	public void updateUserPassword(String id, String password);
	public List<UserVo> findAllUser();
}


public interface UserRepository extends JpaRepository<UserVo, Long>, IUserRepository {
	
}