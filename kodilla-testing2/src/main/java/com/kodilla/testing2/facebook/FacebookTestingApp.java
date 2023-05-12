package com.kodilla.testing2.facebook;

import com.kodilla.testing2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class FacebookTestingApp {

    public static final String XPATH_COOKIES = "//button[2]";
    public static final String XPATH_CREATE_ACCOUNT = "//a[@data-testid='open-registration-form-button']";
    public static final String XPATH_FIRSTNAME = "//input[@class='inputtext _58mg _5dba _2ph-' and @name='firstname']";
    public static final String XPATH_LASTNAME = "//input[@class='inputtext _58mg _5dba _2ph-' and @name='lastname']";
    public static final String XPATH_DAY = "//select[@name='birthday_day' and @id='day']";
    public static final String XPATH_MONTH = "//select[@name='birthday_month' and @id='month']";
    public static final String XPATH_YEAR = "//select[@name='birthday_year' and @id='year']";
    public static final String XPATH_SEX = "//input[@name='sex' and @value='2']";

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.findElement(By.xpath(XPATH_COOKIES)).click();
        driver.findElement(By.xpath(XPATH_CREATE_ACCOUNT)).click();

        WebElement firstnameField = driver.findElement(By.xpath(XPATH_FIRSTNAME));
        firstnameField.sendKeys("Kodilla");

        WebElement lastnameFIeld = driver.findElement(By.xpath(XPATH_LASTNAME));
        lastnameFIeld.sendKeys("Task_31.2");

        WebElement dayField = driver.findElement(By.xpath(XPATH_DAY));
        Select daySelect = new Select(dayField);
        daySelect.selectByValue("31");

        WebElement monthField = driver.findElement(By.xpath(XPATH_MONTH));
        Select monthSelect = new Select(monthField);
        monthSelect.selectByValue("2");

        WebElement yearField = driver.findElement(By.xpath(XPATH_YEAR));
        Select yearSelect = new Select(yearField);
        yearSelect.selectByValue("2000");

        driver.findElement(By.xpath(XPATH_SEX)).click();

        Thread.sleep(5000);
        driver.quit();
    }
}
