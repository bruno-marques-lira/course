package com.bmlinformtica.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bmlinformtica.course.entities.Order;
import com.bmlinformtica.course.entities.User;
import com.bmlinformtica.course.repositories.OrderRepository;
import com.bmlinformtica.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		
		// Instanciando usuários e armazenando no banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		// Armazenando usuários instanciados no banco de dados
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		// Instanciando pedidos e armazenando no banco de dados
		// Datas no formato ISO 8601
		// Letra Z horário no padrão UTC - Horário de Greenwic (Time Zone GMT)
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), 1, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), 2, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), 3, u1);
		
		// Armazenando pedidos instanciados no banco de dados
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
	}
}
