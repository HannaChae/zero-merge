package chn.scalar.api.prd.repository;

import java.util.List;

import chn.scalar.api.prd.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import chn.scalar.api.prd.domain.Product;

interface IProductRepository {
	public List<Product> findByPrdNo(long prdNo);
	public List<Product> findByCtgName(String ctgName);
//	public List<Product> findByPrdName(String prdName);
}

public interface ProductReporitory extends JpaRepository<Product, Long>, IProductRepository {
	@Query(value = "update Product prd set prd.prd_name = :prdName, "+ "prd.ctg_name = :ctgName " + "prd.prd_price = :prdPrice, " + "prd.prd_inv = :prdInv " + "prd.prd_img = :prdImg" 
					+ " where prd.prd_no = :prdNo", nativeQuery = true)
	public long update(@Param("prdNo") long prdNo, @Param("ctgName") String ctgName, @Param("prdPrice") String prdPrice,
					   @Param("prdInv") String prdInv, @Param("prdImg") String prdImg, @Param("prdName") String prdName);
}