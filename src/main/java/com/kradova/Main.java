package com.kradova;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

//        UserProfile.updateProfile(driver);
//        HtmlTable.checkTable(driver);
          Manufacturer.checkTable(driver);
    }
}



