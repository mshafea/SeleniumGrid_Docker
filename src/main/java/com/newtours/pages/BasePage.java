package com.newtours.pages;


import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class BasePage {
	
	protected WebDriver driver;
	public int time = 60;
	Actions action;
	final WebDriverWait wait;
	File file;
    JavascriptExecutor jse;
	
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		action = new Actions(driver);
		wait = new WebDriverWait(driver, time);
		jse = (JavascriptExecutor)driver;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void clear(WebElement element) {
		element.clear();
	}
		
	public void selectOptionFromListByValue(WebElement element, String value) {
		Select selectOption = new Select(element);
		selectOption.selectByValue(value);
	}
	
	public void selectOptionFromListByText(WebElement element, String text) {
		Select selectOption = new Select(element);
		selectOption.selectByVisibleText(text);
	}
	
	public void setText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}

	public void setPhoto(WebElement element, String photoPath) {
			File f = new File(photoPath);
			element.sendKeys(f.getAbsolutePath());
	}
	
	public String getElementText(WebElement element) {
		try {
			element.isDisplayed();
			return element.getText().toString().trim();
		} catch (NoSuchElementException e) {
			return ("No such element exception is returned");		 
		}
	}
	
	public String getElementTextByHref(WebElement element, String attributeValue) {
		try {
			element.isDisplayed();
			return element.getAttribute(attributeValue).toString().trim();
		} catch (NoSuchElementException e) {
			return ("No such element exception is returned");		 
		}
	}
	
	public boolean isElementDisplayed(WebElement element) {
		try {
			return element.isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isElementSelected(WebElement element, String SelectBy, String attributeContains) {
		try {
			return element.getAttribute(SelectBy).contains(attributeContains);
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public void hover(WebElement element) {
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public void dragAndDropByLocation(WebElement element, int x, int y) {
		action.dragAndDropBy(element, x, y).build().perform();
	}

	public void dragAndDropByElement(WebElement draggable,WebElement droppable) {
		action.dragAndDrop(draggable,droppable).build().perform();
	}

	public void waitForVisibilityOf(final WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public void waitForElementToBeClickable(final WebElement element) {
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public boolean isElementNotVisible(final WebElement element) {
		return wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void clickByAction(WebElement element){
	    action.moveToElement(element).click().build().perform();
	}
	
	public void clickByJavaExecutor(WebElement element){
        jse.executeScript("arguments[0].click();", element);
	}
	
	public void acceptAlert() {
		driver.switchTo().alert().accept();
	}
	
	public void dismissAlert() {
		driver.switchTo().alert().dismiss();
	}
	
	public void switchToFrameByWebElement(WebElement element) {
		driver.switchTo().frame(element);
	}
	
	public void switchToFrameByIndex(int index) {
		driver.switchTo().frame(index);
	}
	
	public void switchToAnotherFrame() {
		driver.switchTo().frame(driver.findElement(By.tagName("iframe")));
	}
	
	public void switchToOriginalFrame() {
		driver.switchTo().defaultContent();
	}

	public String getAlertText() {
		return driver.switchTo().alert().getText();
	}

	public static void sleep(int time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

//	public static void waitUntilJqueryIsDone(WebDriver driver){
//		waitUntilJqueryIsDone(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
//	}
//
//	public static void waitUntilJqueryIsDone(WebDriver driver, Long timeoutInSeconds){
//		until(driver, (d) ->
//			{
//			Boolean isJqueryCallDone = (Boolean)((JavascriptExecutor) driver).executeScript("return jQuery.active==0");
//			if (!isJqueryCallDone);
//			return isJqueryCallDone;
//			}, timeoutInSeconds);
//	}
//
//	public static void waitUntilPageLoadComplete(WebDriver driver) {
//		waitUntilPageLoadComplete(driver, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
//	}
//
//	public static void waitUntilPageLoadComplete(WebDriver driver, Long timeoutInSeconds){
//		until(driver, (d) ->
//			{
//				Boolean isPageLoaded = (Boolean)((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
//				if (!isPageLoaded);
//				return isPageLoaded;
//			}, timeoutInSeconds);
//	}
//
//	public static void waitUntil(WebDriver driver, Function<WebDriver, Boolean> waitCondition){
//		until(driver, waitCondition, FileReaderManager.getInstance().getConfigReader().getImplicitlyWait());
//	}
//
//	@SuppressWarnings("deprecation")
//	private static void until(WebDriver driver, Function<WebDriver, Boolean> waitCondition, Long timeoutInSeconds){
//		WebDriverWait webDriverWait = new WebDriverWait(driver, timeoutInSeconds);
//		webDriverWait.withTimeout(timeoutInSeconds, TimeUnit.SECONDS);
//		try{
//			webDriverWait.until(waitCondition);
//		}catch (Exception e){
//			System.out.println(e.getMessage());
//		}
//	}
//
//	public String generateRandomEmail() throws NoSuchAlgorithmException {
//		Random rand = SecureRandom.getInstanceStrong();
//		int randomInt = rand.nextInt(9000);
//		return "username"+randomInt+"@test.com";
//	}
//
//	public String generateRandomCompanyName() throws NoSuchAlgorithmException {
//		Random rand = SecureRandom.getInstanceStrong();
//		int randomInt = rand.nextInt(9000);
//		return "Automated Prof User "+randomInt;
//	}

}
