package chn.scalar.api.crt.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import chn.scalar.api.pay.domain.Payment;

import lombok.Getter;

@Entity @Getter
public class Cart {
	   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	   @Column(name="cart_no") private long cartNo;
	   @Column(name="cart_amount") private long cartAmount;
	   
	   @OneToOne
	   @JoinColumn(name = "pay_no")
	   private Payment payment;
}
