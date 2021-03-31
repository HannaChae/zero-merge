package chn.scalar.api.crt.controller;

import java.util.List;
import java.util.Optional;

import chn.scalar.api.cmm.controller.AbstractController;
import chn.scalar.api.crt.domain.Cart;
import chn.scalar.api.crt.service.CartServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chn.scalar.api.cmm.controller.AbstractController;
import chn.scalar.api.crt.domain.Cart;
import chn.scalar.api.crt.service.CartServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CartController extends AbstractController<Cart> {
	private final CartServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<Long> save(Cart t) {
		return ResponseEntity.ok(service.save(t));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(Cart t) {
		return ResponseEntity.ok(service.delete(t));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(service.count());
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Cart> getOne(@PathVariable long id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Cart>> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(service.existsById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Cart>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
