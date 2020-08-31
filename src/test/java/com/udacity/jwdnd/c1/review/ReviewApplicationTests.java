package com.udacity.jwdnd.c1.review;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ReviewApplicationTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private RegisterPage registerPage;
//	private LoginPage loginPage;
//	private ChatPage chatPage;

	@BeforeAll
	public static void beforeAll() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void afterAll() {
		driver.quit();
	}

	@BeforeEach
	public void beforeEach() {
		driver.get("http://localhost:" + port + "/login");
		registerPage = new RegisterPage(driver);
//		loginPage = new LoginPage(driver);
//		chatPage = new ChatPage(driver);
	}

	@Test
	public void testAccessingRegistrationPage() {
		registerPage.clickRegisterLink();
        System.out.println(driver.getCurrentUrl());
		assertEquals(driver.getTitle(), "Sign Up");
	}

	@Test
	public void testRegisteringNewAccount() {
		registerPage.clickRegisterLink();
		registerPage.registerAccount();
		assertEquals(driver.getTitle(), "Sign Up");
		assertEquals(true, registerPage.getRegistrationResult());
	}
//
//	@Test
//	public void testReset() {
//		counter.resetCount(10);
//		assertEquals(10, counter.getDisplayedCount());
//		counter.resetCount(0);
//		assertEquals(0, counter.getDisplayedCount());
//	}

}
