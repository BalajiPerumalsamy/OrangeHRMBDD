package com.OrangeHRMPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Base_Page
{
    public Properties properties;
    public static WebDriver driver;
    public static WebDriverWait wait;
    public Base_Page()
    {
        String filePath="C://Users//ELCOT//IdeaProjects//Selenium_with_BDD//src//main//java//com//OrangeHRMPages//InputDaTa.properties";
        properties =new Properties();
        try
        {
            FileInputStream file=new FileInputStream(filePath);
            properties.load(file);
        }
        catch(IOException e)
        {
            System.out.println(e);
        }
    }
    public void navigateTOApplication() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait=new WebDriverWait(driver,Duration.ofSeconds(20));
        driver.get(properties.getProperty("url"));
    }
    public void writeText(String text,WebElement element)
    {
        wait.until(ExpectedConditions.visibilityOf(element)).sendKeys(text);
    }
    public void clickButton(WebElement element)
    {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    public void quitToApplications()
    {
        driver.quit();
    }
}
