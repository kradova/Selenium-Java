package com.kradova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        //driver.get("http://practice.bpbonline.com/");
        //driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://www.practice.bpbonline.com/");
        driver.findElement(By.linkText("My Account")).click();
        driver.findElement(By.name("email_address")).sendKeys("bpb@bpb.com");
        driver.findElement(By.name("password")).sendKeys("bpb@123");
        driver.findElement(By.id("tdb1")).click();

        driver.findElement(By.linkText("View or change my account information.")).click();
        //new WebDriverWait(driver,  Duration.ofSeconds(10)).until(ExpectedConditions.presenceOfElementLocated(By.linkText("Log Off")));

        if (driver.findElement(By.xpath("//input[@value = 'm']")).isSelected()) {
            driver.findElement(By.xpath("//input[@value = 'f']")).click();
        } else {
            driver.findElement(By.xpath("//input[@value = 'm']")).click();
        }
        driver.findElement(By.name("telephone")).clear();
        driver.findElement(By.name("telephone")).sendKeys("23838393");
        driver.findElement(By.id("tdb5")).click();
        if (driver.getPageSource().contains("account has been successfully updated")) {
            System.out.println("Change profile successful");
        } else {
            System.out.println("Profile information not changed");
        }

        driver.findElement(By.linkText("Log Off")).click();
        driver.findElement(By.linkText("Continue")).click();
        driver.close();
    }
}


