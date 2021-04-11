package chn.scalar.api.pay.service;

import java.util.List;
import java.util.Optional;

import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.usr.domain.UserVo;
import chn.scalar.api.usr.repository.UserRepository;
import org.springframework.stereotype.Service;

import chn.scalar.api.cmm.service.AbstractService;
import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.pay.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl extends AbstractService<Payment>
								implements PaymentService{
	private final PaymentRepository repo;
	private final UserRepository userRepo;
	@Override public long save(Payment t) {
		System.out.println("================");
		UserVo userVo = userRepo.getOne(t.getUserNumber());
		System.out.println(userVo.toString());
		t.setUser(userVo);
		return (repo.save(t)!=null) ? 1 : 0 ;}
	@Override public long count() {return (long) repo.count();}
	@Override public Payment getOne(long id) {return repo.getOne(id);}
	@Override public Optional<Payment> findById(long id) {return repo.findById(id);}
	@Override public boolean existsById(long id) {return repo.existsById(id);}
	@Override public List<Payment> findAll() {return repo.findAll();}
	@Override public long delete(Payment t) {
		repo.delete(t); 
		return (getOne(t.getPayNo())==null) ? 1 : 0;
	}
}
