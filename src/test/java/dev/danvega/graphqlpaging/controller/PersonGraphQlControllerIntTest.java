package dev.danvega.graphqlpaging.controller;

import dev.danvega.graphqlpaging.model.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.graphql.test.tester.HttpGraphQlTester;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * An example of using HttpGraphQlTester
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PersonGraphQlControllerIntTest {

    private HttpGraphQlTester graphQlTester;

    @LocalServerPort
    int port;

    @BeforeEach
    void setUp() {
        WebTestClient client = WebTestClient.bindToServer()
                .baseUrl(String.format("http://localhost:%s/graphql", port))
                .build();

        graphQlTester = HttpGraphQlTester.create(client);
    }

    @Test
    void contextLoads() {
        assertNotNull(graphQlTester);
    }

    @Test
    void shouldRespondWithAllPeople() {

        String document = """
            query {
                allPeople {
                    firstName
                    lastName
                    phoneNumber
                    email
                }
            }        
        """;

        graphQlTester.document(document)
                .execute()
                .path("allPeople")
                .entityList(Person.class)
                .hasSize(100);
    }

    @Test
    void shouldRespondWithPeoplePaged() {

        String document = """
            query getPeople($page: Int, $size: Int) {
                allPeoplePaged(page: $page, size: $size) {
                    firstName
                    lastName
                    phoneNumber
                    email
                }
        }
        """;

        graphQlTester.document(document)
                .variable("page",0)
                .variable("size",10)
                .execute()
                .path("allPeoplePaged")
                .entityList(Person.class)
                .hasSize(10);
    }


}
