package com.test.api.testcases;

import com.java.api.anotation.FrameworkAnnotation;
import com.java.api.builder.RequestSpecBuilder;
import com.java.api.builder.ResponseSpecBuilder;
import com.test.api.TestConstants.TestConstants;
import com.test.api.pojo.Users;
import com.test.api.pojo.UsersResponse;
import com.test.api.utils.DataStore;
import com.test.api.utils.RandomUtil;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.java.api.enums.TestCategoryType.SANITY;
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
                .spec(RequestSpecBuilder.requestPostBuilder())
                .body(users)
                .when()
                .post(TestConstants.USERSCREATIONAPI)
                .then()
                .spec(ResponseSpecBuilder.createResponseSpecification(201))
                .extract().response();
        ResponseBody body = response.getBody();
        UsersResponse responseBody = body.as(UsersResponse.class);
        DataStore.setValue("id", responseBody.getId());
        Assert.assertEquals("male", responseBody.getGender());
    }
    @Test
    public static void testGetUserDetails() {
        Response response = given().spec(RequestSpecBuilder.requestGetBuilder())
                .when()
                .get(TestConstants.USERSGETAPI + DataStore.getValue("id"))
                .then()
                .spec(ResponseSpecBuilder.createResponseSpecification(200))
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
        Response response = given().spec(RequestSpecBuilder.requestGetBuilder())
                .body(users)
                .when()
                .patch(TestConstants.USERSGETAPI + DataStore.getValue("id"))
                .then()
                .spec(ResponseSpecBuilder.createResponseSpecification(200))
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

        Response response = given().spec(RequestSpecBuilder.requestGetBuilder())
                .when()
                .delete(TestConstants.USERSGETAPI + DataStore.getValue("id"))
                .then()
                .spec(ResponseSpecBuilder.createResponseSpecificationNoContent(204))
                .extract()
                .response();

    }
}