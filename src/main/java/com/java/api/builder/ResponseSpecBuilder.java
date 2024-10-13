package com.java.api.builder;

import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ResponseSpecBuilder {
    public static ResponseSpecification createResponseSpecification(int statusCode) {
        return new io.restassured.builder.ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(ALL).expectResponseTime(lessThanOrEqualTo(3000L))
                .expectContentType(ContentType.JSON)
                .build();
    }
    public static ResponseSpecification createResponseSpecificationNoContent(int statusCode) {
        return new io.restassured.builder.ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .log(ALL).expectResponseTime(lessThanOrEqualTo(3000L))
                .build();
    }
}
