package chn.scalar.api.pay.repository;

import chn.scalar.api.pay.domain.Payment;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import chn.scalar.api.pay.domain.Payment;

@Repository
public class PaymentRepositoryImpl extends QuerydslRepositorySupport 
									implements PaymentCustomRepository{
	// private final JPAQueryFactory qf;
	public PaymentRepositoryImpl() {
		super(Payment.class);
		// this.qf = qf;
	}
}
