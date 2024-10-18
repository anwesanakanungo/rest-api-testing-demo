package com.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static java.lang.Thread.sleep;

public class HomePage {
    private final WebDriver driver;

    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");
    private final By logoutIcon= By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickLogout() throws InterruptedException {
        sleep(2000);
        driver.findElement(logoutIcon).click();
        driver.findElement(logoutButton).click();
        return new LoginPage(driver);
    }
}
