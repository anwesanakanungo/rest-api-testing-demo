package com.test.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static java.lang.Thread.sleep;

public class HomePage {
    private final WebDriver driver;

    private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");
    private final By logoutIcon= By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
    private final By adminButton=By.xpath("//span[normalize-space()='Admin']");
    private final By userRoleSelect =By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[1]");
    private final By userstatus =By.xpath("(//div[@class='oxd-select-text oxd-select-text--active'])[2]");
    private final By employeeName =By.xpath("//input[@placeholder='Type for hints...']");
    private final By password =By.xpath("(//input[@type='password'])[1]");
    private final By repassword =By.xpath("(//input[@type='password'])[2]");
    private final By plusbuton=By.xpath("(//i[@class='oxd-icon bi-plus oxd-button-icon'])[1]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }
    public LoginPage clickLogout() throws InterruptedException {
        sleep(2000);
        driver.findElement(logoutIcon).click();
        driver.findElement(logoutButton).click();

        return new LoginPage(driver);
    }
    public HomePage createUser(String role,String status ,String emploeename,String password1 ,String repassword1) throws InterruptedException {
        sleep(2000);
        driver.findElement(userRoleSelect).click();
        driver.findElement(By.xpath("(//div[@role='listbox']//child::div)[3]")).click();
        sleep(2000);
        WebElement element = driver.findElement(userstatus);
        element.click();
        driver.findElement(employeeName).sendKeys(emploeename);
        driver.findElement(password).sendKeys(password1);
        driver.findElement(repassword).sendKeys(repassword1);
        return this;
    }
    public HomePage goToUser() throws InterruptedException {
        sleep(2000);
        driver.findElement(adminButton).click();
        driver.findElement(plusbuton).click();
        return this; }

}
