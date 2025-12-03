package com.OrangeHRMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Login_Page extends Base_Page
{
    public Login_Page()
    {
        super();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath="//input[@name='username']")
    WebElement userName;
    @FindBy(xpath="//input[@name='password']")
    WebElement password;
    @FindBy(xpath="//button[@type='submit']")
    WebElement loginBtn;

    public void enterUserInput()
    {
        writeText(properties.getProperty("userName"),userName);
        writeText(properties.getProperty("password"),password);
    }
    public void login()
    {
        clickButton(loginBtn);
    }
    public boolean verifyLogin()
    {
        try
        {
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//img[@alt='client brand banner']")));
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
    public String getErrorMessage()
    {
        WebElement msg=wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//p[contains(@class,'alert-content-text')]")));
        return msg.getText();
    }
}