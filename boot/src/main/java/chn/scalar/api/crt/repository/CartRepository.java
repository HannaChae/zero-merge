package chn.scalar.api.crt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import chn.scalar.api.crt.domain.Cart;

interface ICartRepository {}

public interface CartRepository extends JpaRepository<Cart, Long>, ICartRepository {

}
