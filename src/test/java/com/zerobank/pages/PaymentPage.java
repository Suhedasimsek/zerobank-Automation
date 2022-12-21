package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PaymentPage extends BasePage{

    @FindBy(id = "sp_payee")
    public WebElement addPayment_loc;

    @FindBy(linkText = "Add New Payee")
    public WebElement addNewPaye_loc;

    @FindBy(css = "#np_new_payee_name")
    public WebElement payeName_loc;

     @FindBy(css = "#np_new_payee_account")
     public WebElement account_loc;

     @FindBy(css = "#np_new_payee_address")
    public WebElement payeAdress_loc;

     @FindBy(css = "#np_new_payee_details")
    public WebElement payeDetails_loc;

     @FindBy(css = "#add_new_payee")
    public WebElement addButton_loc;

     @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement alertMessage_loc;

    public void addWithParameters(String PayeeName, String  PayeeAddress, String  Account, String  PayeeDetails){

      payeName_loc.sendKeys(PayeeName);
      payeAdress_loc.sendKeys(PayeeAddress);
      account_loc.sendKeys(Account);
      payeDetails_loc.sendKeys(PayeeDetails);
      addButton_loc.click();

}
}