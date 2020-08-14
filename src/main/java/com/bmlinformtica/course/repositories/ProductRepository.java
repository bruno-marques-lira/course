package com.bmlinformtica.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmlinformtica.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
