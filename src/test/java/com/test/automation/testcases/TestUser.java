package com.test.automation.testcases;

import com.github.javafaker.Faker;
import com.java.automation.anotation.FrameworkAnnotation;
import com.java.automation.builder.SpecResourceBuilder;
import com.java.automation.builder.SpecResponseBuilder;
import com.test.automation.TestConstants.TestConstants;
import com.test.automation.pojo.Users;
import com.test.automation.pojo.UsersResponse;
import com.test.automation.utils.DataStore;
import com.test.automation.utils.RandomUtil;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.java.automation.enums.TestCategoryType.SANITY;
import static io.restassured.RestAssured.given;


public class TestUser {
    private static Users users;
    @FrameworkAnnotation(TestCategoryType = {SANITY})
    @Test
    public static void testCreateUser() {
        users = Users.builder()
                .setName(RandomUtil.getFirstName())
                .setEmail(RandomUtil.getEmail())
                .setGender(RandomUtil.getGender())
                .setStatus(RandomUtil.getStatus())
                .build();
        Response response = given()
                .spec(SpecResourceBuilder.resourcePostBulider())
                .body(users)
                .when()
                .post(TestConstants.USERSCREATIONAPI)
                .then()
                .spec(SpecResponseBuilder.createResponseSpecification(201))
                .extract().response();
        ResponseBody body = response.getBody();
        UsersResponse responseBody = body.as(UsersResponse.class);
        DataStore.setValue("id", responseBody.getId());
        Assert.assertEquals("male", responseBody.getGender());
    }
    @Test
    public static void testGetUserDetails() {
        Response response = given().spec(SpecResourceBuilder.resourceGetBulider())
                .when()
                .get(TestConstants.USERSGETAPI + DataStore.getValue("id"))
                .then()
                .spec(SpecResponseBuilder.createResponseSpecification(200))
                .extract()
                .response();
        int user_id = response.path("id");
        String gender = response.path("gender");
        Assert.assertEquals(DataStore.getValue("id"), user_id);
        Assert.assertEquals("male", gender);
    }
    @Test
    public static void testUpdateUserDetails() {
        users = Users.builder()
                .setName(RandomUtil.getFirstName())
                .setEmail(RandomUtil.getEmail())
                .setStatus(RandomUtil.getStatus())
                .build();
        Response response = given().spec(SpecResourceBuilder.resourceGetBulider())
                .body(users)
                .when()
                .patch(TestConstants.USERSGETAPI + DataStore.getValue("id"))
                .then()
                .spec(SpecResponseBuilder.createResponseSpecification(200))
                .extract()
                .response();
        ResponseBody body = response.getBody();
        UsersResponse responseBody = body.as(UsersResponse.class);
        int user_id = response.path("id");
        String gender = response.path("gender");
        Assert.assertEquals(DataStore.getValue("id"), user_id);
        Assert.assertEquals("male", gender);
    }

    @Test
    public static void testZDeleteUserDetails() {

        Response response = given().spec(SpecResourceBuilder.resourceGetBulider())
                .when()
                .delete(TestConstants.USERSGETAPI + DataStore.getValue("id"))
                .then()
                .spec(SpecResponseBuilder.createResponseSpecificationNoContent(204))
                .extract()
                .response();

    }
}