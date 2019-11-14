package com.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    @FindBy(name="firstName")
    private WebElement firstNameTxt;

    @FindBy(name="lastName")
    private WebElement lastNameTxt;

    @FindBy(name="email")
    private WebElement usernameTxt;

    @FindBy(name="password")
    private WebElement passwordTxt;

    @FindBy(name="confirmPassword")
    private WebElement confirmPasswordTxt;

    @FindBy(name="register")
    private WebElement submitBtn;

    public RegistrationPage(WebDriver driver){
        super(driver);
    }

    public void goTo(){
        this.driver.get("http://newtours.demoaut.com/mercuryregister.php");
        waitForVisibilityOf(firstNameTxt);
    }

    public void enterUserDetails(String firstname, String lastname){
        setText(firstNameTxt,firstname);
        setText(lastNameTxt,lastname);
    }

    public void enterUserCredentials(String username, String password){
        setText(usernameTxt,username);
        setText(passwordTxt,password);
        setText(confirmPasswordTxt,password);
    }

    public void submit(){
        click(submitBtn);
    }


}
