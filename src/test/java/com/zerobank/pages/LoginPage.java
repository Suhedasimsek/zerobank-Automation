package com.zerobank.pages;

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


}
