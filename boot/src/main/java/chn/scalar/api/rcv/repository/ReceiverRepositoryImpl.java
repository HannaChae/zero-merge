package chn.scalar.api.rcv.repository;

import chn.scalar.api.rcv.domain.Receiver;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import chn.scalar.api.rcv.domain.Receiver;

@Repository
public class ReceiverRepositoryImpl extends QuerydslRepositorySupport 
									implements ReceiverCustomRepository{
	// private final JPAQueryFactory qf;
	public ReceiverRepositoryImpl() {
		super(Receiver.class);
		// this.qf = qf;
	}
}
