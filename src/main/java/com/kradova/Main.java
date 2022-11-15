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
        WebElement quickFind = driver.findElement(By.xpath("//input[@title = ' Quick Find ']"));
        System.out.println(quickFind.getAttribute("alt"));
        System.out.println(quickFind.getTagName());
        System.out.println(quickFind.getText());
        System.out.println(quickFind.getCssValue("background-color"));
        System.out.println(quickFind.getSize().height);
        System.out.println(quickFind.getRect().height);
        driver.close();
    }
}

