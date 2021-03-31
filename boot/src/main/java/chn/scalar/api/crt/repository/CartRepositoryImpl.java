package chn.scalar.api.crt.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import chn.scalar.api.crt.domain.Cart;

@Repository
public class CartRepositoryImpl extends QuerydslRepositorySupport implements ICartRepository {
	public CartRepositoryImpl() {
		super(Cart.class);
	}
}