import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class AuthIntegrationTest {

    @BeforeAll
    static void setup(){
        RestAssured.baseURI = "http://localhost:4004";
    }

    @Test
    public void shouldReturnOKWithValidToken() {
        // 1. Arrange 2. act 3. assert
        String loginPayload = """
               {
                  "email": "Kishorpandey2121@gmail.com",
                  "password": "kishor@2233#"
               }
               """;

        Response response = given()
                .contentType("application/json") //Arrange
                .body(loginPayload)
                .when()  //act
                .post("/auth/login")
                .then()  //assert
                .statusCode(200)
                .body("token", notNullValue())
                .extract()
                .response();
        System.out.println("Generated Token: "+ response.jsonPath().getString("token"));
    }

    @Test
    public void shouldReturnUnauthorizedOnInvalidToken() {
        // 1. Arrange 2. act 3. assert
        String loginPayload = """
               {
                  "email": "Kishgdggy8338@gmail.com",
                  "password": "wrongest36dgd"
               }
               """;

        given()
                .contentType("application/json") //Arrange
                .body(loginPayload)
                .when()  //act
                .post("/auth/login")
                .then()  //assert
                .statusCode(401);
    }
}
