package chn.scalar.api.pay.controller;

import java.util.List;
import java.util.Optional;

import chn.scalar.api.cmm.controller.AbstractController;
import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.pay.service.PaymentServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chn.scalar.api.cmm.controller.AbstractController;
import chn.scalar.api.pay.domain.Payment;
import chn.scalar.api.pay.service.PaymentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/payment")
public class PaymentController extends AbstractController<Payment> {
	final PaymentServiceImpl service;
	
	@PostMapping("/save")
	public ResponseEntity<Long> save(@RequestBody Payment t) {
		return ResponseEntity.ok(service.save(t));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(@RequestBody Payment t) {
		return ResponseEntity.ok(service.delete(t));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(service.count());
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Payment> getOne(@PathVariable long id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Payment>> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(service.existsById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Payment>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
	
}
