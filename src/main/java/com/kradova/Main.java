package com.kradova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.bpbonline.com/");
        System.out.println(driver.getTitle());
        if (driver.getPageSource().contains("Welcome to BPB PUBLICATIONS")) {
            System.out.println("Page is loaded");
        }
        driver.manage().window().maximize();
        driver.navigate().to("http://www.selenium.dev");
        if (driver.getCurrentUrl().contains("selenium")) {
            System.out.println("Page is now changed to Selenium website");
        }
        driver.close();
    }
}