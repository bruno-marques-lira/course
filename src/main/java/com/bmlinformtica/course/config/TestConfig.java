package com.bmlinformtica.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bmlinformtica.course.entities.Category;
import com.bmlinformtica.course.entities.Order;
import com.bmlinformtica.course.entities.Product;
import com.bmlinformtica.course.entities.User;
import com.bmlinformtica.course.entities.enums.OrderStatus;
import com.bmlinformtica.course.repositories.CategoryRepository;
import com.bmlinformtica.course.repositories.OrderRepository;
import com.bmlinformtica.course.repositories.ProductRepository;
import com.bmlinformtica.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
	
	// Repositório: Acessa a tabela de usuários do banco de dados
	@Autowired
	private UserRepository userRepository;
	
	// Repositório: Acessa a tabela de pedidos do banco de dados
	@Autowired
	private OrderRepository orderRepository;
	
	// Repositório: Acessa a tabela de categorias do banco de dados
	@Autowired
	private CategoryRepository categoryRepository;
	
	// Repositório: Acessa a tabela de produtos do banco de dados
	@Autowired
	private ProductRepository productsRepository;
	
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
		userRepository.saveAll(Arrays.asList(u1, u2, u3, u4, u5));
		
		// Armazenando pedidos instanciados no banco de dados
		orderRepository.saveAll(Arrays.asList(o1, o2, o3, o4, o5, o6));
		
		// Instanciando categorias e armazenando no banco de dados
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		// Armazenando categorias instanciadas no banco de dados
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		// Instanciando produtos e armazenando no banco de dados
		Product p1 = new Product(null, "The Lord of the Rings", "A Sociedade do Anel", 90.50, "");
		Product p2 = new Product(null, "The Lord of the Rings", "As duas Torres", 90.50, "");
		Product p3 = new Product(null, "The Lord of the Rings", "O Retorno do Rei", 90.50, "");
		Product p4 = new Product(null, "The Lord of the Rings", "Jogos Vorazes", 90.50, "");
		Product p5 = new Product(null, "The Lord of the Rings", "As Crônicas do Rei Arthur", 90.50, "");
		Product p6 = new Product(null, "Smart TV", "60'", 2190.0, "");
		Product p7 = new Product(null, "Macbook Pro", "512GB SSD, 16GB RAM, Placa de Vídeo 4GB Gforce", 10599.00, "");
		Product p8 = new Product(null, "PC Gammer", "512GB SSD, 16GB RAM, Placa de Vídeo 4GB Gforce", 1200.00, "");
		Product p9 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		// Armazenando produtos instanciados no banco de dados
		productsRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9));		
	}
}
