package chn.scalar.api.ctg.repository;

import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import com.amazonaws.services.alexaforbusiness.model.Category;

@Repository
public class CategoryRepositoryImpl extends QuerydslRepositorySupport implements ICategoryRepository {
	public CategoryRepositoryImpl() {
		super(Category.class);
	}
}