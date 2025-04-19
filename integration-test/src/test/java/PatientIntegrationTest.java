import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class PatientIntegrationTest {

    @BeforeAll
    static void setUp() {
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnPatientsWithValidToken() {
        // 1. Arrange 2. act 3. assert
        String loginPayload = """
               {
                  "email": "Kishorpandey2121@gmail.com",
                  "password": "kishor@2233#"
               }
               """;

        String token = given()     //Start building the HTTP request
                .contentType("application/json") //Arrange
                .body(loginPayload)
                .when()  //act
                .post("/auth/login")
                .then()  //assert
                .statusCode(200)
                .extract()
                .jsonPath()
                .get("token");

        given()
                .header("Authorization", "Bearer " +token)
                .when()
                .get("api/patients")
                .then()
                .statusCode(200)
                .body("patients", notNullValue());
    }

}
