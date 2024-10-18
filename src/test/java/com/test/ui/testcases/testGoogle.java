package com.test.ui.testcases;

import com.java.ui.driver.DriverManager;
import com.java.ui.driver.DriverManagerFactory;
import com.java.ui.driver.DriverType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;


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
    @Test (dataProvider = "testData")
    public void test(String uname,String password){
        driver.get("https://www.google.co.in/");
        Assert.assertEquals("Google", driver.getTitle());
        List<WebElement> elements = driver.findElements(By.tagName("a")) ;
        for (WebElement e : elements){
            System.out.println(e.getAttribute("href"));
        }
        System.out.println(uname);
        System.out.println(password);
    }
    @AfterMethod()
    public void afterMethod(){
        driverManager.quitDriver();
    }
    @DataProvider (name="testData")
    public Object [] [] testData(){
        Object [][] twitterData=new Object[2][2];
        twitterData [0][0]="abc@gmail.com";
        twitterData [0][1]="password";
        twitterData [1][0]="bcd@gmail.com";
        twitterData [1][1]="bcd@gmail.com";
        return twitterData ;
    }
}
