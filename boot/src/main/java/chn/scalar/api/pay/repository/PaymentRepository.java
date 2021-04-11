package chn.scalar.api.pay.repository;

import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.usr.domain.UserVo;
import org.springframework.data.jpa.repository.JpaRepository;

import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.pay.repository.PaymentCustomRepository;

interface PaymentCustomRepository{
    // UserVo joinUser();

}
public interface PaymentRepository extends JpaRepository<Payment, Long>,
PaymentCustomRepository{

}