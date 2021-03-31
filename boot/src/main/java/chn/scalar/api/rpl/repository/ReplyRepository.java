package chn.scalar.api.rpl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chn.scalar.api.rpl.domain.Reply;
import chn.scalar.api.rpl.repository.IReplyRepository;

interface IReplyRepository{
	
}

public interface ReplyRepository extends JpaRepository<Reply, Long>,
									IReplyRepository{

}