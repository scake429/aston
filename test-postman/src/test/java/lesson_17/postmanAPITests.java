package lesson_17;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;

public class postmanAPITests {
    @BeforeEach
    public void configRestAssForPostman() {
        baseURI = "https://postman-echo.com";
    }

    @Test
    @DisplayName("Testing the method GET")
    public void getTest() {
        given().queryParam("foo1", "bar1").queryParam("foo2", "bar2").log().body().contentType("application/json")
                .when().get("/get")
                .then().log().body().statusCode(200)
                .and().body("args['foo1']", Matchers.equalTo("bar1"))
                .and().body("args.foo2", Matchers.equalTo("bar2"));
    }

    @Test
    @DisplayName("Testing the method POST Raw Text")
    public void postRawTextTest() {
        given().log().body().contentType("application/json").body("{'test':'value'}")
                .when().post("/post")
                .then().log().body().statusCode(200)
                .and().body("data", Matchers.equalTo("{'test':'value'}"));
    }

    @Test
    @DisplayName("Testing the method POST Form Data")
    public void postFormDataTest() {
        given().log().body().contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .formParam("foo2", "bar2")
                .when().post("/post")
                .then().log().body().statusCode(200)
                .and().body("form.foo1", Matchers.equalTo("bar1"))
                .and().body("form.foo2", Matchers.equalTo("bar2"))
                .and().body("json.foo1", Matchers.equalTo("bar1"))
                .and().body("json.foo2", Matchers.equalTo("bar2"));
    }

    @Test
    @DisplayName("Testing the method PUT")
    public void putTest() {
        given().log().body().contentType("text/plain").body("Just checking the Put method")
                .when().put("/put")
                .then().log().body().statusCode(200)
                .and().body("data", Matchers.equalTo("Just checking the Put method"));
    }

    @Test
    @DisplayName("Testing the method PATCH")
    public void patchTest() {
        given().log().body().contentType("text/plain").body("Just checking the Patch method")
                .when().patch("/patch")
                .then().log().body().statusCode(200)
                .and().body("data", Matchers.equalTo("Just checking the Patch method"));
    }

    @Test
    @DisplayName("Testing the method DELETE")
    public void deleteTest() {
        given().log().body().contentType("application/x-www-form-urlencoded; charset=utf-8")
                .formParam("foo1", "bar1")
                .when().delete("/delete")
                .then().log().body().statusCode(200)
                .and().body("form.foo1", Matchers.equalTo("bar1"))
                .and().body("json.foo1", Matchers.equalTo("bar1"));
    }

}
