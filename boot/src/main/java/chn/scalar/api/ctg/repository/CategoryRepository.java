package chn.scalar.api.ctg.repository;

import chn.scalar.api.ctg.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import chn.scalar.api.ctg.domain.Category;

interface ICategoryRepository {}

public interface CategoryRepository extends JpaRepository<Category, Long>, ICategoryRepository {
	
}