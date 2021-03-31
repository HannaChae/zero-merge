package chn.scalar.api.rcv.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chn.scalar.api.rcv.domain.Receiver;
import chn.scalar.api.rcv.repository.ReceiverCustomRepository;

interface ReceiverCustomRepository{
	
}
public interface ReceiverRepository extends JpaRepository<Receiver, Long>,
ReceiverCustomRepository{

}
