package com.kradova;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HtmlTable {
    static void checkTable(@NotNull ChromeDriver driver) {
        //driver.get("http://practice.bpbonline.com/");
        //driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.get("http://www.practice.bpbonline.com/index.php");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        WebElement productTable = driver.findElement(By.tagName("table"));
        List<WebElement> rows = productTable.findElements(By.xpath("//*/tbody/tr"));
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            for (WebElement col : cols) {
                String content = col.getText();
                System.out.println(content);
            }
        }


    }
}
