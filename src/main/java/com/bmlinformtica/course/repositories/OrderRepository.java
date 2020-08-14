package com.bmlinformtica.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmlinformtica.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
