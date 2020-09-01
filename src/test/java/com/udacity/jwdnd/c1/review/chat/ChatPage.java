package com.udacity.jwdnd.c1.review.chat;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class ChatPage {

    @FindBy(name = "messageText")
    private WebElement messageText;

    @FindBy(xpath = "/html/body/div/form/button")
    private WebElement submitButton;

    @FindBy(css = "body > div > div:nth-child(7) > span:nth-child(2)")
    private WebElement messagesOutput;

    public ChatPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getMessageResults() {
        try {
            Thread.sleep(5000);
            messageText.clear();
            Thread.sleep(5000);
            messageText.sendKeys("Example text");
            submitButton.click();
            Thread.sleep(5000);
        } catch (StaleElementReferenceException e) {
            System.out.println(e.getMessage());
            return "Failed";
        } catch (Exception e) {
            return "Failed";
        }
        return messagesOutput.getText();
    }
}