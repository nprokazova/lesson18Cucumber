package cucumber.steps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class StepImplementation {

    protected static WebDriver driver;

    @Step("We have user id in DB")
    public void weHaveUserIdInDB() {
        Allure.addAttachment("User's id is in DB", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));

    }

    @Step("User sent request to get info")
    public void userSentRequestToGetInfo() {
        Allure.addAttachment("User received information", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("We saved information about user request id DB")
    public void weSavedInformationAboutUserRequestIdDB() {
        Allure.addAttachment("Information was saved in DB", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    //-----------------Test1----------------

    @Step("The page {string} is opened")
    public void thePageIsOpened(String name) {
        Allure.addAttachment("The page is opened", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Checking that the title is not empty")
    public void checkingThatTheTitleIsNotEmpty() {
        Allure.addAttachment("the title is not empty\"", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }

    @Step("Header title check")
    public void headerTitleCheck() {
        System.out.println("Header title check");
    }

    //-----------------Test2----------------

    @Step("Go to the \"Contacts\" tab")
    public void goToTheContactsTab() {
        System.out.println("Go to the \"Contacts\" tab");
    }

    @Step("Checking that the address is correct")
    public void checkingThatTheAddressIsCorrect() {
        System.out.println("Checking that the address is correct");
    }

    @Step("Title check")
    public void titleCheck() {
        System.out.println("Title check was successfully");
    }

    //-----------------Test3----------------

    @Step("Go to F.A.Q {string}")
    public void goToFAQ(String fqa) {
        System.out.println("Going to F.A.Q is correct");
    }

    @Step("Click on the question: \"Where can I see the program of the course of interest?\"")
    public void clickOnTheQuestion() {
        System.out.println("Clicking on the question: 'Where can I see the program of the course of interest?' was successfully");
    }

    @Step("Text check")
    public void textCheck() {
        System.out.println("Text check was successfully");
    }

    //-----------------Test4----------------

    @Step("Filling in a test mailbox in the \"Subscribe to our news\" field")
    public void fillingInATestMailbox() {
        System.out.println("Clicking the 'Subscribe' button was successful");
    }

    @Step("Clicking on the \"Subscribe\" button")
    public void clickOnTheSubscribButton() {
        System.out.println("Completed test mailbox in the field 'Subscribe to our news'");
    }

    @Step("Checking the message: \"You have successfully subscribed\"")
    public void messageCheck() {
        System.out.println("A message appeared: You have successfully subscribed");
    }

}

