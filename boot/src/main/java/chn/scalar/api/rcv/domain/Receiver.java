package chn.scalar.api.rcv.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import chn.scalar.api.pay.domain.Payment;

import lombok.Getter;

@Entity  @Getter
public class Receiver {
      @Id 
      @GeneratedValue(strategy = GenerationType.IDENTITY)
      @Column(name="rcv_no") private long rcvNo;
      @Column(name="rcv_name") private String rcvName;
      @Column(name="rcv_phone") private String rcvPhone;
      @Column(name="rcv_addr") private String rcvAddr;
      
      @ManyToOne
      @JoinColumn(name="pay_no")
      private Payment payment;
}