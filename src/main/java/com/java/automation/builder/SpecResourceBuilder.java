package com.java.automation.builder;

import com.java.automation.config.ConfigReader;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class SpecResourceBuilder {

    public static RequestSpecification resourceGetBulider() {
        return new RequestSpecBuilder().setBaseUri(ConfigReader.getValue("base-url"))
                .addHeader("Authorization", ConfigReader.getValue("access-token"))
                .log(LogDetail.ALL)
                .build();
    }

    public static RequestSpecification resourcePostBulider() {
        return new RequestSpecBuilder().setBaseUri(ConfigReader.getValue("base-url"))
                .addHeader("Authorization", ConfigReader.getValue("access-token"))
                .log(LogDetail.ALL)
                .setContentType(ContentType.JSON)
                .addHeader("Accept", "application/json")
                .build();
    }
}
