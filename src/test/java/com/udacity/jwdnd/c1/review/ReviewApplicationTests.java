package com.udacity.jwdnd.c1.review;

import com.udacity.jwdnd.c1.review.chat.ChatPage;
import com.udacity.jwdnd.c1.review.login.LoginPage;
import com.udacity.jwdnd.c1.review.registration.RegisterPage;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ReviewApplicationTests {

	@LocalServerPort
	private Integer port;

	private static WebDriver driver;
	private RegisterPage registerPage;
	private LoginPage loginPage;
	private ChatPage chatPage;

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
		loginPage = new LoginPage(driver);
		chatPage = new ChatPage(driver);
	}

	@Test
	@Order(2)
	public void testAccessingRegistrationPage() {
		registerPage.clickRegisterLink();
        assertEquals(true, driver.getCurrentUrl().contains("signup"));
	}

	@Test
	@Order(3)
	public void testRegisteringNewAccount() {
		System.out.println("Open Signup Page!");
		registerPage.clickRegisterLink();
		System.out.println("Let Register our account!");
		registerPage.registerAccount();
		System.out.println("Check if registration is successful!" + registerPage.getRegistrationResult());
		assertEquals(true, registerPage.getRegistrationResult());
	}

	@Test
	@Order(1)
	public void testAccessingLoginPage() {
		System.out.println(driver.getCurrentUrl());
		assertEquals(true, driver.getCurrentUrl().contains("login"));
	}

	@Test
	@Order(4)
	public void testLoggingInWithNewAccount() {
		loginPage.loginToAccount();
		assertEquals(true, driver.getCurrentUrl().contains("chat"));
	}

	@Test
	@Order(5)
	public void testSendingAMessage() {
		loginPage.loginToAccount();
		assertEquals("Example text", chatPage.getMessageResults());
	}
}
