package dev.danvega.graphqlpaging.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface PersonRepository extends PagingAndSortingRepository<Person,Integer> {
}
