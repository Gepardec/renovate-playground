package org.acme.getting.started;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

import org.junit.jupiter.api.Test;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
class GreetingResourceTest {

    @Test
    void testHelloEndpoint() {
        given()
                .when().get("/hello")
                .then()
                .statusCode(200)
                .body(is("hello"));
    }

    @Test
    void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
                .pathParam("name", uuid)
                .when().get("/hello/greeting/{name}")
                .then()
                .statusCode(200)
                .body(is("hello " + uuid));
    }
}
