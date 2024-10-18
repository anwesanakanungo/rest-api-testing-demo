package com.test.api.testcases;

import com.java.api.anotation.FrameworkAnnotation;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.testng.annotations.Test;

import java.io.File;

import static com.java.api.enums.TestCategoryType.SMOKE;
import static io.restassured.RestAssured.given;

public class Test1 {
    @FrameworkAnnotation(TestCategoryType = {SMOKE})
    @Test
    public void test1(){
        given()
                .when().get("https://2e472d90-2ec3-4961-b4c5-251bbeef4fc4.mock.pstmn.io/getheader")
                .then()
                .log().all()
                .statusCode(200).assertThat()
                .body(JsonSchemaValidator.
                        matchesJsonSchema(new File("src/main/resources/test.json")));
    }
}
