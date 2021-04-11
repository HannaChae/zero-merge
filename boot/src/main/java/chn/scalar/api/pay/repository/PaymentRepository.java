package chn.scalar.api.pay.repository;

import chn.scalar.api.pay.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.pay.repository.PaymentCustomRepository;

interface PaymentCustomRepository{
	
}
public interface PaymentRepository extends JpaRepository<Payment, Long>,
PaymentCustomRepository{

}