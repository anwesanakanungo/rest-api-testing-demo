package com.test.api.testcases;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class MethodBody {
    @Test
    public void test11(){
        Response response = given()
                .when().get("https://fake-json-api.mock.beeceptor.com/companies")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<Integer> a =jsonPath.get("id");
        System.out.println(a);
        List<String> str =jsonPath.get("name");
        System.out.println(str);
        str.stream().sorted().forEach(System.out::println);
    }
    @Test
    public void test111(){
        Response response = given()
                .when().get("https://2e472d90-2ec3-4961-b4c5-251bbeef4fc4.mock.pstmn.io/bigjson")
                .then()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
       String a =jsonPath.get("links.self");
        System.out.println(a);
        System.out.println("#############");
        String str =jsonPath.get("data[0].relationships.author.links.self");
        System.out.println(str);
        System.out.println("-------------------");
        String aa=jsonPath.get("included[0].type");
        System.out.println(aa);

    }
}
