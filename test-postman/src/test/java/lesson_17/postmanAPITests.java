package lesson_17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import io.restassured.RestAssured;
import io.restassured.RestAssured.*;

public class postmanAPITests {
    @BeforeEach
    public void configRestAssForPostman() {
        RestAssured.baseURI = "https://postman-echo.com";
        
    }

    @Test
    public void getTest() {
        RestAssured.given().queryParam("foo1", "bar1").queryParam("foo2", "bar2").log().body().contentType("application/json")
        .when().get("/get")
        .then().log().body().statusCode(200)
        .and().body("get(0).foo1", equalTo("bar1"))
        .and().body("get(1).foo2", equalTo("bar2"));
    }
}
