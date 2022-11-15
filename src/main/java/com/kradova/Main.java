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
        //driver.get("http://practice.bpbonline.com/");
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().window().maximize();
        WebElement firstCheckbox = driver.findElement(By.cssSelector("#checkboxes"));
        System.out.println(firstCheckbox.isDisplayed());
        System.out.println(firstCheckbox.isEnabled());
        System.out.println(firstCheckbox.isSelected());
        firstCheckbox.click();
        System.out.println(firstCheckbox.isSelected());
        driver.close();
    }
}

