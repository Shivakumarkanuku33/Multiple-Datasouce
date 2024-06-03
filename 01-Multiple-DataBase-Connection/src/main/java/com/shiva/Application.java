package com.shiva;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.shiva.orderentity.Order;
import com.shiva.orderrepository.OrderDAO;
import com.shiva.productentity.Product;
import com.shiva.productrepository.ProductDAO;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	private OrderDAO orderDAO;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		System.out.println("-------Data Inserting in DB-----------------");
		
		Product product = new Product(1, "Mobile", 20000.00);
		productDAO.save(product);
		
		Order order = new Order(2, "Shivakumar", LocalDate.now());
		orderDAO.save(order);
		
		System.out.println("---------Data Inserted in DB---------------");
	}

}
