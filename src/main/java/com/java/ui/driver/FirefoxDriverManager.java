package com.java.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class FirefoxDriverManager extends DriverManager {
    @Override
    protected WebDriver createDriver() {
        //System.out.println("Initializing Firefox Driver");
        return new FirefoxDriver(getFirefoxOptions());
    }

    private FirefoxOptions getFirefoxOptions() {
        // A few valid Options for Chrome, showcase purpose.
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }

}
