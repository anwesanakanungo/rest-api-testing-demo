package com.java.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager extends DriverManager {

    @Override
    protected WebDriver createDriver() {
       // System.out.println("Initializing Chrome Driver");
        return new ChromeDriver(getChromeOptions());
    }

    private ChromeOptions getChromeOptions() {
        // A few valid Options for Chrome, showcase purpose.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--start-maximized");
        options.addArguments("--disable-features=EnableEphemeralFlashPermission");
        options.addArguments("--disable-infobars");

        return options;
    }

}
