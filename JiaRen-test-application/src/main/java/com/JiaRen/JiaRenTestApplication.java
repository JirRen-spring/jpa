package com.JiaRen;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import com.JiaRen.dao.CustomCustomerRepository;
import com.JiaRen.dao.CustomerDao;
import com.JiaRen.dao.CustomerRepository;
import com.JiaRen.model.Customer;

@SpringBootApplication
@EntityScan(basePackages = "com.JiaRen.model")
public class JiaRenTestApplication {

	private static final Logger log = LoggerFactory.getLogger(JiaRenTestApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(JiaRenTestApplication.class);
	}

	public CommandLineRunner demo(CustomerRepository repository, CustomCustomerRepository repository1, CustomerDao customerDao) {
		return (args) -> {
			// save a couple of customers
//			List<Map<String, Object>> map = customerDao.getList(null);
//			repository1.customMethod();
			repository.save(new Customer("Jack", "Bauer"));
			repository.save(new Customer("Chloe", "O'Brian"));
			repository.save(new Customer("Kim", "Bauer"));
			repository.save(new Customer("David", "Palmer"));
			repository.save(new Customer("Michelle", "Dessler"));

			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Customer customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("");

			// fetch an individual customer by ID
			Customer customer = repository.findOne(1L);
			log.info("Customer found with findOne(1L):");
			log.info("--------------------------------");
			log.info(customer.toString());
			log.info("");

			// fetch customers by last name
			log.info("Customer found with findByLastName('Bauer'):");
			log.info("--------------------------------------------");
			for (Customer bauer : repository.findByLastName("Bauer")) {
				log.info(bauer.toString());
			}
			log.info("");
		};
	}
}
