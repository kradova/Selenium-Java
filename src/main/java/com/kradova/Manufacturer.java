package com.kradova;

import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Manufacturer {
    static void checkTable(@NotNull ChromeDriver driver) {
        //driver.get("http://practice.bpbonline.com/");
        //driver.get("https://the-internet.herokuapp.com/checkboxes");
        driver.get("http://www.practice.bpbonline.com/index.php");
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        Select manufacturers = new Select(driver.findElement(By.xpath("//select[@name = 'manufacturers_id']")));
        List<WebElement> allmanfs = manufacturers.getOptions();
        allmanfs.remove(0);

        ArrayList<String> allNames = getAllNames(allmanfs);

        for (String manname : allNames) {
            manufacturers.selectByVisibleText(manname);
            manufacturers = new Select(driver.findElement(By.xpath("//select[@name='manufacturers_id']")));
            if (driver.getPageSource().contains("There are no products available in this category.")) {
                System.out.println("the manufacturer has no products");
            } else {
                WebElement productTable = driver.findElement(By.className("productListingHeader"));
                System.out.println("\n\nThe manufacturer - " + manname + " products are listed--");
                List<WebElement> rows = productTable.findElements(By.xpath("//*/tbody/tr"));
                showRowData(rows);
            }
        }
        driver.close();
    }// checkTable

    private static @NotNull ArrayList<String> getAllNames(List<WebElement> allmanfs) {
        ArrayList<String> allNames = new ArrayList<String>();
        for (WebElement man : allmanfs) {
            allNames.add(man.getText());
        }
        return allNames;
    }// getAllNames

    private static void showRowData(@NotNull List<WebElement> rows){
        for (WebElement row : rows) {
            List<WebElement> cols = row.findElements(By.xpath("td"));
            for (WebElement col : cols) {
                String content = col.getText();
                System.out.println(content);
            }
        }
    }// showRowData()
}
