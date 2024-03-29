package com.display.test.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

	private By InternetSectionTitle = By.xpath("//h3[@class='title']");
	public By getDisplayLogo = By.xpath("//img[@class='airline-company-logo']");
	private By InternetPlansSeeAllLink = By.xpath("//a[@class='fstl-base catalog-link']");
	public By VoucherButton = By.cssSelector("[data-testid=\"voucher-node ts-link\"]");
	private By VoucherPopup = By.xpath("//section[@class='VoucherPopup']");
	private By voucherInput = By.cssSelector("input[placeholder='Voucher code']");
	private By voucherSubmit = By.cssSelector(".btn-brand-primary-large");
	private By errorMessage = By.cssSelector("div[class='error ']");
	private By internetPlansText = By.id("internetPlansText");
	private By mainPageText = By.cssSelector("[data-testid=\"internet-connectivity-link\"] > font");

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public boolean isInternetSectionTitleDisplayed() {

		WebElement internetPlansSection = driver.findElement(InternetSectionTitle);
		return internetPlansSection.isDisplayed();
	}

	public void getLogo() {
		driver.findElement(getDisplayLogo).click();
	}

	public void clickSeeAllLink() {
		driver.findElement(InternetPlansSeeAllLink).click();
	}

	public boolean isVoucherPopupDisplayed() {
		WebElement voucherPopup = driver.findElement(VoucherPopup);
		return voucherPopup.isDisplayed();
	}

	public void enterVoucherCode(String code) {
		driver.findElement(voucherInput).sendKeys(code);
	}

	public void submitVoucherCode() {
		driver.findElement(voucherSubmit).click();
	}

	public boolean isErrorMessageDisplayed() {
		WebElement ErrorText = driver.findElement(errorMessage);
		return ErrorText.isDisplayed();
	}

	public String getInternetPlansText() {
		return driver.findElement(internetPlansText).getText();
	}

	public String getMainPageText() {
		return driver.findElement(mainPageText).getText();
	}
}
