package org.acme;

import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.security.TestSecurity;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
@TestSecurity(user="john", roles= {"admin", "user"})                  // (1)
//@TestSecurity(authorizationEnabled = false)                         // (2)
@TestHTTPEndpoint(TrainingResource.class)
public class SecurityTest {
    @Test
    void testTraining() {
        given()
                .when().get()
                .then()
                .statusCode(200)
                .body("[1].name", is("Quarkus and MicroProfile!"))    // (3)
                .body("[1].students[1].id", is(6))                    // (4)
                .body("[1].students[1].name", is("Jane Quarkus"));    // (5)
    }
}

