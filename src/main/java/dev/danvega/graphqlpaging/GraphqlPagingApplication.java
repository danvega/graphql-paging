package dev.danvega.graphqlpaging;

import com.github.javafaker.Faker;
import dev.danvega.graphqlpaging.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
public class GraphqlPagingApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlPagingApplication.class, args);
	}

	@Bean
	public Faker faker() {
		return new Faker();
	}

//	@Bean
//	public CommandLineRunner runner(PersonRepository repository) {
//		return args -> {
//			// do stuff
//		};
//	}
}
