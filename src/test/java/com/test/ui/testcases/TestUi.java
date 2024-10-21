package com.test.ui.testcases;

import com.java.ui.driver.DriverManager;
import com.java.ui.driver.DriverManagerFactory;
import com.java.ui.driver.DriverType;
import com.test.ui.pages.HomePage;
import com.test.ui.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestUi {
    WebDriver driver;
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
    public void test() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         HomePage home= LoginPage.using(driver)
                        .launch()
                         .setUsername("Admin")
                         .setPassword("admin123")
                         .clickSubmit();
         home.clickLogout();

    }
    @Test
    public void testCreateUser() throws InterruptedException {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        HomePage home= LoginPage.using(driver)
                .launch()
                .setUsername("Admin")
                .setPassword("admin123")
                .clickSubmit();
        home.goToUser()
                .createUser("Admin","Active" ,"abbaba","aabbaba","aaaa")
                .clickLogout();


    }

}