package chn.scalar.api.pay.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import chn.scalar.api.brd.domain.Board;
import chn.scalar.api.crt.domain.Cart;
import chn.scalar.api.prd.domain.Product;
import chn.scalar.api.rcv.domain.Receiver;
import chn.scalar.api.usr.domain.UserVo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

@Setter
@Entity @Getter
public class Payment {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY) @Column(name="pay_no") private long payNo;
   @Column(name="pay_price") private String payPrice;
   @Column(name="pay_info") private String payInfo;
   @Column(name="pay_date") private String payDate;
   @Column(name="pay_state") private String payState;
   @Column(name="user_number") private long userNumber;

   @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
   @ManyToOne
   @JoinColumn(name="usr_no")
   private UserVo userVo;
   
   @ManyToOne
   @JoinColumn(name="prd_no")
   private Product product;

   @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)
   @OneToMany(mappedBy="payment")
   private List<Receiver> receivers = new ArrayList<>();

   @OneToMany(mappedBy="payment")
   private List<Board> boards = new ArrayList<>();
   
   @OneToOne(mappedBy="payment")
   private Cart cart;

  public void setUser(UserVo userVo){
     this.userVo = userVo;
     userVo.getPayments().add(this);
  }





   
}