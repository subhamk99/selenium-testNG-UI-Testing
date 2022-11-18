package org.example;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FirstTestCase {

    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        options.addArguments("headless");

        System.setProperty("webdriver.chrome.driver", "/home/subhamk/Downloads/chromedriver_linux64/chromedriver");
        System.setProperty("slf4j.detectLoggerNameMismatch", "true");


        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");


        driver.close();
    }
}