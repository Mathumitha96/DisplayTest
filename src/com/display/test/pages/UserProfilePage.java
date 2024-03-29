package com.display.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UserProfilePage extends BasePage {
	private By languageSetting = By.cssSelector("[data-test-id=\"burger-item-72e699e2950ecb7f7f3189b7c12177b3\"]");
	private By languageSwitcher = By.cssSelector("[data-testid=\"language\"]");
	// French language isn't displayed in the dropdown
	private By frenchLanguageOption = By.cssSelector("[data-testid=\"language-fr\"]");
	private By submitButton = By.xpath("//button[@type='submit']");
	private By languageTitle = By.xpath("//h1[@class='form-title']/font");
	private By userProfileText = By.xpath("//h1[@class='form-title your-profile-title']/font");

	public UserProfilePage(WebDriver driver) {
		super(driver);
	}

	public void switchLanguageToFrench() {
		driver.findElement(languageSetting).click();
		driver.findElement(languageSwitcher).click();
		driver.findElement(frenchLanguageOption).click();
		driver.findElement(submitButton).click();
	}

	public String getLangugeTitle() {
		return driver.findElement(languageTitle).getText();
	}

	public String getUserProfileText() {
		return driver.findElement(userProfileText).getText();
	}

}
