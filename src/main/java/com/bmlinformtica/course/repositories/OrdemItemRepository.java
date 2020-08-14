package com.bmlinformtica.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmlinformtica.course.entities.OrderItem;

public interface OrdemItemRepository extends JpaRepository<OrderItem, Long>{

}
