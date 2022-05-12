package dev.danvega.graphqlpaging.data;

import com.github.javafaker.Faker;
import dev.danvega.graphqlpaging.model.Address;
import dev.danvega.graphqlpaging.model.Person;
import dev.danvega.graphqlpaging.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.IntStream;

@Component
public class SampleDataLoader implements CommandLineRunner {

    private final PersonRepository repository;
    private final Faker faker;

    public SampleDataLoader(PersonRepository repository, Faker faker) {
        this.repository = repository;
        this.faker = faker;
    }

    @Override
    public void run(String... args) throws Exception {

        // create 100 rows of people in the database
        List<Person> people = IntStream.rangeClosed(1,100)
                .mapToObj(i -> new Person(
                    faker.name().firstName(),
                    faker.name().lastName(),
                    faker.phoneNumber().cellPhone(),
                    faker.internet().emailAddress(),
                    new Address(
                            faker.address().streetAddress(),
                            faker.address().city(),
                            faker.address().state(),
                            faker.address().zipCode()
                    )
                )).toList();

        repository.saveAll(people);
    }
}
