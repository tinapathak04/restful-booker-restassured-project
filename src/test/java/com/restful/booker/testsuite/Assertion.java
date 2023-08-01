package com.restful.booker.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.hasItem;

public class Assertion {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://restful-booker.herokuapp.com/";
        response = given()
                .when()
                .get("/booking/1")
                .then().statusCode(200);
    }
    @Test
    public void test1(){
        response.body("firstname",hasItem("Jim"));
    }
    @Test
    public void test2(){
        response.body("lastname",hasItem("Smith"));
    }
    @Test
    public void test3(){
        response.body("totalprice",hasItem(658));
    }
    @Test
    public void test4(){
        response.body("depositpaid",hasItem("true"));
    }
    @Test
    public void test5(){
        response.body("additionalneeds",hasItem("Breakfast"));
    }

}
