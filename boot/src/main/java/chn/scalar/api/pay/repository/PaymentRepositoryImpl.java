package chn.scalar.api.pay.repository;

import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.usr.domain.UserVo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;
import static chn.scalar.api.usr.domain.QUserVo.userVo;
import static chn.scalar.api.pay.domain.QPayment.payment;
import chn.scalar.api.pay.domain.Payment;

@Repository
public class PaymentRepositoryImpl extends QuerydslRepositorySupport 
									implements PaymentCustomRepository{
	 private final JPAQueryFactory qf;
	public PaymentRepositoryImpl(JPAQueryFactory qf) {
		super(Payment.class);
		 this.qf = qf;
	}

//	@Override
//	public UserVo joinUser() {
//		return qf.select(userVo)
//				.from(payment)
//				.join(payment.userVo, userVo)
//				.where(userVo.usrNo.eq(payment.payNo)).fetchOne();
//	}
}
