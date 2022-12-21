package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy (id = "signin_button")
    public WebElement signButton_loc;

    @FindBy (id = "user_login")
    public WebElement userName_loc;

    @FindBy (id = "user_password")
    public WebElement password_loc;

    @FindBy (xpath = "//input[@name='submit']")
    public WebElement loginButton_loc;

    @FindBy (xpath = "//div[@class='alert alert-error']")
    public WebElement errorMessage_loc;

    public void navigateToAccount(String account) {

        Driver.get().findElement(By.linkText(account)).click();
        //Driver.get().findElement(By.xpath("//a[.='"+account+"']")).click();

    }
}
