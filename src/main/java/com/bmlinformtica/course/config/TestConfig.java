package com.bmlinformtica.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bmlinformtica.course.entities.Order;
import com.bmlinformtica.course.entities.User;
import com.bmlinformtica.course.entities.enums.OrderStatus;
import com.bmlinformtica.course.repositories.OrderRepository;
import com.bmlinformtica.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	// Repositório: Acessa a tabela de usuários do banco de dados
	@Autowired
	private UserRepository userRepo;
	
	// Repositório: Acessa a tabela de pedidos do banco de dados
	@Autowired
	private OrderRepository orderRepo;
	
	// Programa: Linha de comando de execução pós Run as...
	@Override
	public void run(String... args) throws Exception {
		
		// Instanciando usuários e armazenando no banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		User u3 = new User(null, "Bruno Lira", "brunomarqueslira@outlook.com", "969192721", "123");
		User u4 = new User(null, "Patricia Bellemo Lira", "patriciabellemo@gmail.com", "969192721", "123");
		User u5 = new User(null, "Gilberto Bellemo", "gilbertobellemo@gmail.com", "969192721", "123");
		
		// Instanciando pedidos e armazenando no banco de dados
		// Datas no formato ISO 8601
		// Letra Z horário no padrão UTC - Horário de Greenwic (Time Zone GMT)
		Order o1 = new Order(null, Instant.parse("2020-08-14T10:09:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
		Order o4 = new Order(null, Instant.parse("2020-08-14T11:21:32Z"), OrderStatus.DELIVERED, u3);
		Order o5 = new Order(null, Instant.parse("2020-08-14T11:21:32Z"), OrderStatus.SHIPPED, u4);
		Order o6 = new Order(null, Instant.parse("2020-08-14T11:21:32Z"), OrderStatus.CANCELED, u5);
		
		// Armazenando usuários instanciados no banco de dados
		userRepo.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		
		// Armazenando pedidos instanciados no banco de dados
		orderRepo.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6));
	}
}
