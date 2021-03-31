package chn.scalar.api.rpl.repository;

import chn.scalar.api.rpl.domain.Reply;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import chn.scalar.api.rpl.domain.Reply;
import com.querydsl.jpa.impl.JPAQueryFactory;

@Repository
public class ReplyRepositoryImpl extends QuerydslRepositorySupport 
									implements IReplyRepository{
	// private final JPAQueryFactory qf;
	public ReplyRepositoryImpl() {
		super(Reply.class);
		// this.qf = qf;
	}

}
