package com.bmlinformtica.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmlinformtica.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
