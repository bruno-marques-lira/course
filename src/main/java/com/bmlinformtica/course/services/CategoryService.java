package com.bmlinformtica.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bmlinformtica.course.entities.Category;
import com.bmlinformtica.course.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository Catrepo;
	
	public List<Category> findAll() {
		return Catrepo.findAll();
	}
	
	public Category findById(Integer id) {
		Optional<Category> obj = Catrepo.findById(id);
		return obj.get();
	}
}
