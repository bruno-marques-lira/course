package com.bmlinformtica.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.bmlinformtica.course.entities.Category;
import com.bmlinformtica.course.entities.Order;
import com.bmlinformtica.course.entities.OrderItem;
import com.bmlinformtica.course.entities.Product;
import com.bmlinformtica.course.entities.User;
import com.bmlinformtica.course.entities.enums.OrderStatus;
import com.bmlinformtica.course.repositories.CategoryRepository;
import com.bmlinformtica.course.repositories.OrdemItemRepository;
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
	
	// Repositório: Acessa a tabela de itens de pedido do banco de dados
	@Autowired
	private OrdemItemRepository ordemItemRepository;
	
	// Programa: Linha de comando de execução pós Run as...
	@Override
	public void run(String... args) throws Exception {
		
		// Instanciando categorias e armazenando no banco de dados
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		
		// Instanciando produtos e armazenando no banco de dados
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		productsRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		// Associando Produtos a Categorias
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p3.getCategories().addAll(Arrays.asList(cat1, cat3));
		p4.getCategories().addAll(Arrays.asList(cat1, cat3));
		p5.getCategories().add(cat2);
		productsRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));	
		
		// Instanciando usuários e armazenando no banco de dados
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		userRepository.saveAll(Arrays.asList(u1, u2));
		
		// Instanciando pedidos e armazenando no banco de dados
		// Datas no formato ISO 8601
		// Letra Z horário no padrão UTC - Horário de Greenwic (Time Zone GMT)
		Order o1 = new Order(null, Instant.parse("2020-08-14T10:09:00Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.CANCELED, u1);
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		// Instanciando pedidos e armazenando no banco de dados
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		ordemItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));		
	}
}
