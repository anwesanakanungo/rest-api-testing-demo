package com.test.api.testcases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.Optional;

import static io.restassured.RestAssured.given;


public class TestGet {
    @Test
    public void test(){
        Response response = given()
                .when().get("https://dummyjson.com/users")
                .then()
                .extract().response();
       JsonPath jsonPath = response.jsonPath();
        int a =jsonPath.get("users[0].id");
        System.out.println("********************8888");
        System.out.println(a);
        System.out.println("************");
        String address =jsonPath.get("users[0].address.city");
        System.out.println(address);
        int a1 =jsonPath.get("users[1].id");
        System.out.println("********************8888");
        System.out.println(a1);
        System.out.println("************");
        String address2 =jsonPath.get("users[1].address.city");
        System.out.println(address2);
        int total =jsonPath.get("limit");
        System.out.println(total);


    }
}
