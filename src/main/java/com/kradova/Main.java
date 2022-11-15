package com.kradova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.get("http://practice.bpbonline.com/");
        driver.manage().window().maximize();
        WebElement searchField = driver.findElement(By.name("keywords"));
        searchField.clear();
        searchField.sendKeys("mouse");
        WebElement quickFind = driver.findElement(By.xpath("//input[@title = ' Quick Find ']"));
        quickFind.click();

        driver.close();
    }
}

