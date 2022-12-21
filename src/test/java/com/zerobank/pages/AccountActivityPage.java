package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage extends BasePage{



    @FindBy(css = "#aa_accountId")
    public WebElement dropDownElement_loc;

    @FindBy(xpath = "//table//tr//th")
    public List<WebElement> rowHeader_loc;


    public List<String> getSelectMenu(){

        BrowserUtils.waitFor(3);
        Select select=new Select(dropDownElement_loc);
        List<WebElement> options = select.getOptions();
        List<String> elementsText = BrowserUtils.getElementsText(options);


        return elementsText;



    }

    }
