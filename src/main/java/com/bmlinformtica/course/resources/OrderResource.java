package com.bmlinformtica.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmlinformtica.course.entities.Order;
import com.bmlinformtica.course.services.OrderService;

@RestController
@RequestMapping(value="/orders")
public class OrderResource {
	
	@Autowired
	private OrderService Orderservice;
	
	@GetMapping
	public ResponseEntity<List<Order>> findAll() {
		List<Order> list = Orderservice.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<Order> findById(@PathVariable Integer id) {
		Order obj = Orderservice.findById(id);
		return ResponseEntity.ok().body(obj);		
	}
}
