package com.example.curso.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.curso.entities.Category;
import com.example.curso.repositories.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository repository;

	public List<Category> findAll() {
		return repository.findAll();

	}

	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

	public Category insert(Category obj) {
		return repository.save(obj);
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Category update(Long id, Category obj) {
		Category entity = repository.getOne(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());	
	}
}