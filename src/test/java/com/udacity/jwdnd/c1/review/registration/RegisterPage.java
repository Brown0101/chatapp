package com.udacity.jwdnd.c1.review.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

    @FindBy(id = "signup-link")
    private WebElement signupLink;

    @FindBy(name = "firstName")
    private WebElement firstName;

    @FindBy(name = "lastName")
    private WebElement lastName;

    @FindBy(name= "username")
    private WebElement username;

    @FindBy(name = "password")
    private WebElement password;

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
            Thread.sleep(2000);
            System.out.println("Sending Keys to input fields!");
            firstName.sendKeys("Frank");
            lastName.sendKeys("Dukes");
            username.sendKeys("fdukes");
            password.sendKeys("superSecret");
            submitButton.click();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Boolean getRegistrationResult() {
        try {
            Thread.sleep(5000);
            if(successMsg.getText() != null) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}