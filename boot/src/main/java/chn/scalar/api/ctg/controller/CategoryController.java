package chn.scalar.api.ctg.controller;

import java.util.List;
import java.util.Optional;

import chn.scalar.api.cmm.controller.AbstractController;
import chn.scalar.api.ctg.domain.Category;
import chn.scalar.api.ctg.service.CategoryServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import chn.scalar.api.cmm.controller.AbstractController;
import chn.scalar.api.ctg.domain.Category;
import chn.scalar.api.ctg.service.CategoryServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoryController extends AbstractController<Category> {
	private final CategoryServiceImpl service;

	@PostMapping("/save")
	public ResponseEntity<Long> save(Category t) {
		return ResponseEntity.ok(service.save(t));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Long> delete(Category t) {
		return ResponseEntity.ok(service.delete(t));
	}

	@GetMapping("/count")
	public ResponseEntity<Long> count() {
		return ResponseEntity.ok(service.count());
	}

	@GetMapping("/one/{id}")
	public ResponseEntity<Category> getOne(@PathVariable long id) {
		return ResponseEntity.ok(service.getOne(id));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Optional<Category>> findById(@PathVariable long id) {
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping("/exists/{id}")
	public ResponseEntity<Boolean> existsById(@PathVariable long id) {
		return ResponseEntity.ok(service.existsById(id));
	}

	@GetMapping("/all")
	public ResponseEntity<List<Category>> findAll() {
		return ResponseEntity.ok(service.findAll());
	}
}
