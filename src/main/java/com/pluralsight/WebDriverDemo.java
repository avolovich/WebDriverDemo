package com.pluralsight;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class WebDriverDemo {

    public static void main(String[] args) throws Exception {
        googleTextSearchImageOpening();
       // remoteServerTest();
    }

    public static void remoteServerTest() throws Exception {
        WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        driver.get("http://www.google.com");
    }


    public static void googleTextSearchImageOpening() throws Exception {
        //   WebDriver driver = new FirefoxDriver();
       WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
      // WebDriver driver = new ChromeDriver();
        driver.get("http://www.google.com");

        // WebElement searchField = driver.findElement(By.xpath("//input[@name=\"q\"]"));

        WebElement searchField = driver.findElement(By.xpath("//input[@name=\"q\"]"));
        WebElement searchBtn = driver.findElement(By.xpath("//input[@name=\"btnK\"]"));
        searchField.sendKeys("Окарина");

//        new WebDriverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
        searchField.submit();

        // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Картинки")));

        WebElement imagesLink = driver.findElements(By.linkText("Картинки")).get(0);
        imagesLink.click();

        WebElement imageElement = driver.findElements(By.cssSelector("a[class=rg_l]")).get(0);
        WebElement imageLink = imageElement.findElements(By.tagName("img")).get(0);
        imageLink.click();
    }

}
