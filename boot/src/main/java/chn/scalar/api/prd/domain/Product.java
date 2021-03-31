package chn.scalar.api.prd.domain;

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

import chn.scalar.api.ctg.domain.Category;
import chn.scalar.api.pay.domain.Payment;

import lombok.Getter;
import lombok.ToString;

@Entity @Getter @ToString
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="prd_no") private long prdNo;
	@Column(name="prd_name") private String prdName;
	@Column(name="ctg_name") private String ctgName;
	@Column(name="prd_img") private String prdImg;
	@Column(name="prd_price") private String prdPrice;
	@Column(name="prd_inv") private String prdInv;

	@ManyToOne
	@JoinColumn(name="ctg_no")
	private Category category;
	
	@OneToMany(mappedBy = "product")
	private List<Payment> payments = new ArrayList<>();

	public void setPrdName(String prdName) { this.prdName = prdName; }
	public void setCtgName(String ctgName) { this.ctgName = ctgName; }
	public void setPrdImg(String prdImg) { this.prdImg = prdImg; }
	public void setPrdPrice(String prdPrice) { this.prdPrice = prdPrice; }
	public void setPrdInv(String prdInv) { this.prdInv = prdInv; }
}