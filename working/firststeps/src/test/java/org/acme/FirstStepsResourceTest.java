package org.acme;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.anyOf;

@QuarkusTest
@QuarkusTestResource(WiremockGreetingService.class)     // (1)
@TestHTTPEndpoint(FirstStepsResource.class)
public class FirstStepsResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get()
          .then()
             .statusCode(200)
             .body(is("hello"));
    }

    @Test
    public void testRestClient() {
        given()
                .accept(ContentType.JSON)
                .when().get("/list")
                .then()
                .body("[0]", is("Howdy from app.prop"))    // (1)
                .body("[1]", is("Hola from app.prop"))     // (1)
                .body("[2]", is("Hello from app.prop"));   // (1)
    }

    @Test
    public void testRestClientRandom() {
        String string =
                given()
                        .accept(ContentType.TEXT)
                        .when().get("/random")
                        .body().asString();                    // (1)

        assertThat(string,                             // (2)
                anyOf(is("Howdy from app.prop"),       // (3)
                        is("Hola from app.prop"),
                        is("Hello from app.prop")));
    }
}