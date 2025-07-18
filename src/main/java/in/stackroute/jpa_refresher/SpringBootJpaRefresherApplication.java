package in.stackroute.jpa_refresher;

import in.stackroute.jpa_refresher.model.Product;
import in.stackroute.jpa_refresher.model.one2one.Profile;
import in.stackroute.jpa_refresher.model.one2one.User;
import in.stackroute.jpa_refresher.repository.ProductRepository;
import in.stackroute.jpa_refresher.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
@Slf4j
public class SpringBootJpaRefresherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaRefresherApplication.class, args);
	}

//	@Bean
	public CommandLineRunner runner(UserRepository repository) {
		return args -> {
			Profile profile = new Profile(LocalDate.now(),  "8989898989");
			User user = new User("ashish", profile);
			repository.save(user);
			repository.findAll().forEach(System.out::println);
		};
	}

//	@Bean
	public CommandLineRunner runner(ProductRepository repository) {
		return  args -> {
			log.info("Deleting all products");
			repository.deleteAll();
			log.info("Creating 3 products");
			repository.saveAll(
					List.of(
							new Product(25000.00, "Laptop", 12),
							new Product(45000.00, "Gaming Laptop", 12),
							new Product(2500.00, "Air Purifier", 10)
					)
			);
			log.info("All product count: {}", repository.findAll().size());
			repository.findAllProductsBelowReorderLevel(15).stream().forEach(System.out::println);
			repository.findByNameContainsIgnoreCase("laptop").stream().forEach(System.out::println);
			log.info("All products above re order level");
			repository.findAllProductsAboveReorderLevel(10).stream().forEach(System.out::println);
		};
	}

}
