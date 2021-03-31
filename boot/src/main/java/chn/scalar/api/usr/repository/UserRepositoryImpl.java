package chn.scalar.api.usr.repository;

import java.util.List;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import chn.scalar.api.usr.domain.UserVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import static chn.scalar.api.usr.domain.QUserVo.userVo;
import static chn.scalar.api.pay.domain.QPayment.payment;

@Repository
public class UserRepositoryImpl extends QuerydslRepositorySupport implements IUserRepository {

	private final JPAQueryFactory queryFactory;
	private final EntityManager entityManager;

	public UserRepositoryImpl(EntityManager entityManager, JPAQueryFactory queryFactory) {
		super(UserVo.class);
		this.entityManager = entityManager;
		this.queryFactory = queryFactory;
	}
	
	@Override
	public List<UserVo> findAllUser() {
		return queryFactory.selectFrom(userVo)
				.orderBy(userVo.usrName.desc())
				.fetch();
	}


	@Override
	public List<UserVo> findByName(String name) {
		return queryFactory.selectFrom(userVo)
				.where(userVo.usrName.eq(name)).fetch();
	}


	@Override
	public boolean findByEmail(String email) {
		return queryFactory.selectFrom(userVo)
				.where(userVo.usrEmail.eq(email))
				.fetchOne() != null ? true : false;
	}

	@Override
	public boolean checkId(String id) {
		return queryFactory.selectFrom(userVo)
				.where(userVo.usrId.eq(id))
				.fetchOne() != null ? true : false;
	}


	@Override
	public String findIdByEmail(String email) {
		return queryFactory.select(userVo.usrId).from(userVo).fetchOne();
	}

	@Override
	public Optional<UserVo> findUserById(String email) {
		return Optional.ofNullable(queryFactory.selectFrom(userVo)
				.where(userVo.usrEmail.eq(email))
				.fetchOne());
	}

	@Override
	public Optional<UserVo> findUserByEmail(String email) {
		return Optional.ofNullable(queryFactory.selectFrom(userVo)
				.where(userVo.usrEmail.eq(email)).fetchOne());
	}


	@Override
	public Optional<UserVo> updatePassword(String password) {
		return Optional.ofNullable(queryFactory
				.selectFrom(userVo)
				.where(userVo.usrPwd.eq(password))
				.fetchOne());
	}

	@Override
	public void updateUserPassword(String id, String password) {

	}

	@Override
	public Optional<UserVo> updateProfile(String email, String password) {

		return Optional.ofNullable(
				queryFactory.selectFrom(userVo)
					.where(userVo.usrEmail.eq(email).and(userVo.usrPwd.eq(password)))
					.fetchOne());
	}

	@Override
	public Optional<UserVo> findPassword(String password) {
		return Optional.ofNullable(queryFactory.selectFrom(userVo)
				.where(userVo.usrPwd.eq(password))
				.fetchOne());
	}


}