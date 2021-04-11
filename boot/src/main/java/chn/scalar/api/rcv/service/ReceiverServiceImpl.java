package chn.scalar.api.rcv.service;

import java.util.List;
import java.util.Optional;

import chn.scalar.api.cmm.service.AbstractService;
import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.pay.repository.PaymentRepository;
import chn.scalar.api.rcv.domain.Receiver;
import chn.scalar.api.rcv.repository.ReceiverRepository;
import org.springframework.stereotype.Service;

import chn.scalar.api.cmm.service.AbstractService;
import chn.scalar.api.rcv.domain.Receiver;
import chn.scalar.api.rcv.repository.ReceiverRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReceiverServiceImpl extends AbstractService<Receiver>
								implements ReceiverService{
	private final ReceiverRepository repo;
	private final PaymentRepository payRepo;
	@Override public long save(Receiver t) {
		// Payment payment = payRepo.getOne(t.)

		return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public long count() {return (long) repo.count();}
	@Override public Receiver getOne(long id) {return repo.getOne(id);}
	@Override public Optional<Receiver> findById(long id) {return repo.findById(id);}
	@Override public boolean existsById(long id) {return repo.existsById(id);}
	@Override public List<Receiver> findAll() {return repo.findAll();}
	@Override public long delete(Receiver t) {
		repo.delete(t); 
		return (getOne(t.getRcvNo())==null) ? 1 : 0;
	}
}