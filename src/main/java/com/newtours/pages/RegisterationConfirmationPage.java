package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterationConfirmationPage extends BasePage {

    @FindBy(partialLinkText = "sign-in")
    private WebElement signinLink;

    @FindBy(partialLinkText = "Flights")
    private WebElement fligthsLink;

    public RegisterationConfirmationPage(WebDriver driver) {
        super(driver);
    }

    public void goToFlightDetailsPage() {
        waitForVisibilityOf(signinLink);
        click(fligthsLink);
    }

}
