package com.display.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.JavascriptExecutor;

public class BasePage {
    protected WebDriver driver;

    // Added class variables for EULA and checksum keys and values
    protected static final String EULA_KEY = "eula_agreed";
    protected static final String EULA_VALUE = "1";
    protected static final String CHECKSUM_KEY = "eula_checksum";
    protected static final String CHECKSUM_VALUE = "d41d8cd98f00b204e9800998ecf8427e";

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setConsent() {
     
        if (driver != null && driver instanceof JavascriptExecutor) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            try {
                // Set in local storage
                js.executeScript("window.localStorage.setItem('" + EULA_KEY + "', '" + EULA_VALUE + "');");
                js.executeScript("window.localStorage.setItem('" + CHECKSUM_KEY + "', '" + CHECKSUM_VALUE + "');");
            } catch (Exception e) {
                System.err.println("Error while setting consent in local storage: " + e.getMessage());
            }
        } else {
            System.err.println("Driver is null or not an instance of JavascriptExecutor");
        }
    }
}
