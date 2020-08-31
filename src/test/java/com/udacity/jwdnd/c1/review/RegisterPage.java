package com.udacity.jwdnd.c1.review;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(id = "signup-link")
    private WebElement signupLink;

    @FindBy(id = "inputFirstName")
    private WebElement inputFirstName;

    @FindBy(id = "inputLastName")
    private WebElement inputLastName;

    @FindBy(id = "inputUsername")
    private WebElement inputUsername;

    @FindBy(id = "inputPassword")
    private WebElement inputPassword;

    @FindBy(id = "submit-button")
    private WebElement submitButton;

    @FindBy(id = "success-msg")
    private WebElement successMsg;

    public RegisterPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void clickRegisterLink() {
        signupLink.click();
    }

    public void registerAccount() {
        try{
            inputFirstName.wait(500);
            inputFirstName.sendKeys("Frank");
            inputLastName.sendKeys("Dukes");
            inputUsername.sendKeys("fdukes");
            inputPassword.sendKeys("superSecret");
            submitButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean getRegistrationResult() {
        try {
            // TODO: Need to fix. Site goes to login and does not stay on sign up page.
            // TODO: Page is unable to find success data on page.
            successMsg.wait(5000);
            successMsg.click();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}