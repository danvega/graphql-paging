package dev.danvega.graphqlpaging.repository;

import dev.danvega.graphqlpaging.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {
}
