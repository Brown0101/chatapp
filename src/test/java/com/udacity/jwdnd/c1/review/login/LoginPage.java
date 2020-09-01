package com.udacity.jwdnd.c1.review.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(name = "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void loginToAccount() {
        try{
            Thread.sleep(2000);
            System.out.println("Sending Keys to input fields!");
            username.sendKeys("fdukes");
            Thread.sleep(2000);
            password.sendKeys("superSecret");
            Thread.sleep(2000);
            submitButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}