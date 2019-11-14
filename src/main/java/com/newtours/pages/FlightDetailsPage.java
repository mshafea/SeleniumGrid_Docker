package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FlightDetailsPage extends BasePage {

    @FindBy(name="passCount")
    private WebElement passengers;

    @FindBy(name="findFlights")
    private WebElement submitBtn;

    public FlightDetailsPage(WebDriver driver){
        super(driver);
    }

    public void selectPassengers(String noOfPassengers){
        waitForElementToBeClickable(passengers);
        selectOptionFromListByValue(passengers,noOfPassengers);
    }

    public void goToFindFlightsPage(){
        click(submitBtn);
    }

}
