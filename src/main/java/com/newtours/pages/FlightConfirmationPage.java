package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FlightConfirmationPage extends BasePage {

    @FindBy(xpath="//font[contains(text(),'Confirmation')]")
    private WebElement flightConfirmationHeader;

    @FindBy(xpath="//font[contains(text(),'USD')]")
    private List<WebElement> prices;

    @FindBy(linkText="SIGN-OFF")
    private WebElement signOffLink;

    @FindBy(name="findFlights")
    private WebElement submitBtn;

    public FlightConfirmationPage(WebDriver driver){
        super(driver);
    }

    public String getPrice(){
        waitForVisibilityOf(flightConfirmationHeader);
        System.out.println(flightConfirmationHeader.getText());
        System.out.println(prices.get(1).getText());
        String price= prices.get(1).getText();
        click(signOffLink);
        return price;
    }
}
