package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FindFlightPage extends BasePage {

    @FindBy(name="reserveFlights")
    private WebElement firstSubmitBtn;

    @FindBy(name="buyFlights")
    private WebElement secondSubmitBtn;

    public FindFlightPage(WebDriver driver){
        super(driver);
    }

    public void submitFindFlightPage(){
        waitForElementToBeClickable(firstSubmitBtn);
        click(firstSubmitBtn);
    }

    public void goToFlightConfirmationPage(){
        waitForElementToBeClickable(secondSubmitBtn);
        click(secondSubmitBtn);
    }

}
