package com.test.ui.testcases;

import com.java.ui.driver.DriverManager;
import com.java.ui.driver.DriverManagerFactory;
import com.java.ui.driver.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class testGoogle {
    WebDriver driver ;
    DriverManager driverManager;
    @BeforeTest
    public void beforeTest() {
        driverManager = DriverManagerFactory.getManager(DriverType.CHROME);
    }
    @BeforeMethod
    public void beforeMethod() {
        driver = driverManager.getDriver();
    }
    @Test
    public void test(){
        driver.get("https://www.google.co.in/");
        Assert.assertEquals("Google", driver.getTitle());
    }
    @AfterMethod()
    public void afterMethod(){
        driverManager.quitDriver();
    }
}
