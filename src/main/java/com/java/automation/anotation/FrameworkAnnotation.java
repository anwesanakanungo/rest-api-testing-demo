package com.java.automation.anotation;

import com.java.automation.enums.TestCategoryType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


@Retention(RUNTIME)
@Target(METHOD)
@Documented
public @interface FrameworkAnnotation {

    TestCategoryType[] TestCategoryType();
}
