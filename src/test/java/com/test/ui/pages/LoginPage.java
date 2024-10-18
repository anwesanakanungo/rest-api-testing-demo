package com.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;

    private final By usernameField = By.xpath("//input[@placeholder='Username']");
    private final By passwordField = By.xpath("//input[@placeholder='Password']");
    private final By loginButton = By.xpath("//button[normalize-space()='Login']");


    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
    public static LoginPage using(WebDriver driver) {
        return new LoginPage(driver);
    }


    public LoginPage launch() {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        return this;
    }
public LoginPage setUsername(String username){
        driver.findElement(usernameField).sendKeys(username);
        return this;
}
    public LoginPage setPassword(String password){
        driver.findElement(passwordField).sendKeys(password);
        return this;
    }
    public HomePage clickSubmit(){
        driver.findElement(loginButton).click();
        return new HomePage(driver);
    }
}
