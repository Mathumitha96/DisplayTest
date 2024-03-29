package com.display.test.tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.display.test.pages.BasePage;
import com.display.test.pages.HomePage;
import com.display.test.pages.UserProfilePage;

public class MainTest {
	private WebDriver driver;
	static String chromedriverpath = "/Users/mathumitha.murugan/Projects/chromedriver";
	static String URL = "https://portal-ugo.ife.ugo.aero/";

	private UserProfilePage userProfilePage;
	private HomePage homePage;
	private BasePage basePage;

	@BeforeMethod
	public void initialize() {
		initializeWebDriver();
		userProfilePage = new UserProfilePage(driver);
		homePage = new HomePage(driver);
		basePage = new BasePage(driver);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		navigateToPortal();
	}

	private void initializeWebDriver() {
		System.setProperty("webdriver.chrome.driver", chromedriverpath);
		ChromeOptions options = new ChromeOptions();
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}

	private void navigateToPortal() {
		driver.get(URL);
		basePage.setConsent();
		driver.get(URL);
	}

	@Test
	public void verifyLanguageFrench() {
		userProfilePage.switchLanguageToFrench();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("lng=fr"));

		String languagleTitleText = userProfilePage.getLangugeTitle();
		Assert.assertEquals(languagleTitleText, "Langue");

		String userProfileTitleText = userProfilePage.getUserProfileText();
		Assert.assertEquals(userProfileTitleText, "Vos informations personnelles");

		driver.findElement(homePage.getDisplayLogo).click();
		String internetPlansText = homePage.getMainPageText();
		Assert.assertTrue(internetPlansText.contains("Internet disponible"));
	}

	@Test
	public void verifyInternetPlansSection() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)", "");

		Assert.assertTrue(homePage.isInternetSectionTitleDisplayed());

		homePage.clickSeeAllLink();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertTrue(currentUrl.contains("/services/connectivity/325"));

		driver.findElement(homePage.VoucherButton).click();
		Assert.assertTrue(homePage.isVoucherPopupDisplayed());

		homePage.enterVoucherCode("TEST");
		homePage.submitVoucherCode();
		Assert.assertTrue(homePage.isErrorMessageDisplayed());
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
