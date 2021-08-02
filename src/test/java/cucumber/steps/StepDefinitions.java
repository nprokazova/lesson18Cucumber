package cucumber.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.concurrent.TimeUnit;

public class StepDefinitions {
//    @Given("We have user id in DB")
//    public void weHaveUserIdInDB() {
//        System.out.println("User in DB");
//    }
//
//    @When("User sent request to get info")
//    public void userSentRequestToGetInfo() {
//        System.out.println("User received information");
//    }
//
//    @Then("We saved information about user request id DB")
//    public void weSavedInformationAboutUserRequestIdDB() {
//        System.out.println("Information saved in DB");
//    }

    protected static WebDriver driver;

    @cucumber.api.java.en.Given("We have user id in DB")
    public void weHaveUserIdInDB() {
        System.out.println("User in DB");

    }

    @cucumber.api.java.en.When("User sent request to get info")
    public void userSentRequestToGetInfo() {
        System.out.println("User received information");
    }

    @cucumber.api.java.en.Then("We saved information about user request id DB")
    public void weSavedInformationAboutUserRequestIdDB() {
        System.out.println("Information saved in DB");
    }

    //-----------------Test1----------------

    @cucumber.api.java.en.Given("The page {string} is opened")
    public void thePageIsOpened(String name) {
        driver.get(name);
        System.out.println("The page is opened");
    }

    @cucumber.api.java.en.When("Checking that the title is not empty")
    public void checkingThatTheTitleIsNotEmpty() {
        Assertions.assertNotNull(driver.getTitle());
        System.out.println("Checking that the title is not empty: " + driver.getTitle());
    }

    @cucumber.api.java.en.Then("Header title check")
    public void headerTitleCheck() {
        Assertions.assertEquals(driver.getTitle(), "Онлайн‑курсы для профессионалов, дистанционное обучение современным профессиям");
        System.out.println("Header title check: " + driver.getTitle());
    }

    //-----------------Test2----------------

    @cucumber.api.java.en.Then("Go to the \"Contacts\" tab")
    public void goToTheContactsTab() {
        Assertions.assertTrue(driver.findElement(By.cssSelector("a.header2_subheader-link[href='/contacts/']")).isEnabled());
        driver.findElement(By.cssSelector("a.header2_subheader-link[href='/contacts/']")).click();
        System.out.println("Go to the \"Contacts\" tab");
    }

    @cucumber.api.java.en.Then("Checking that the address is correct")
    public void checkingThatTheAddressIsCorrect() {
        Assertions.assertEquals("125167, г. Москва, Нарышкинская аллея., д. 5, стр. 2, тел. +7 499 938-92-02", driver.findElement(By.cssSelector(".c0qfa0-1>.c0qfa0-5")).getText());
        System.out.println("Checking that the address is correct");
    }

    @cucumber.api.java.en.Then("Title check")
    public void titleCheck() {
        Assertions.assertEquals("Контакты | OTUS", driver.getTitle());
        System.out.println("Title check was successfully");
    }

    //-----------------Test3----------------

    @cucumber.api.java.en.When("Go to F.A.Q {string}")
    public void goToFAQ(String fqa) {
        driver.get(fqa);
        System.out.println("Going to F.A.Q is correct");
    }

    @cucumber.api.java.en.Then("Click on the question: \"Where can I see the program of the course of interest?\"")
    public void clickOnTheQuestion() {
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[text()='Где посмотреть программу интересующего курса?']")).click();
        System.out.println("Clicking on the question: 'Where can I see the program of the course of interest?' was successfully");
    }

    @cucumber.api.java.en.Then("Text check")
    public void textCheck() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[text()='Где посмотреть программу интересующего курса?']/..//*[@class='faq-question__answer js-faq-answer']"))));
        Assertions.assertEquals("Программу курса в сжатом виде можно увидеть на странице курса после блока с преподавателями. Подробную программу курса можно скачать кликнув на “Скачать подробную программу курса”", driver.findElement(By.xpath("//*[text()='Где посмотреть программу интересующего курса?']/..//*[@class='faq-question__answer js-faq-answer']")).getText());
        System.out.println("Text check was successfully");
    }

    //-----------------Test4----------------

    @cucumber.api.java.en.When("Filling in a test mailbox in the \"Subscribe to our news\" field")
    public void fillingInATestMailbox() {
        driver.findElement(By.cssSelector(".input.footer2__subscribe-input")).sendKeys("test@test.test");
        System.out.println("Clicking the 'Subscribe' button was successful");
    }

    @cucumber.api.java.en.Then("Clicking on the \"Subscribe\" button")
    public void clickOnTheSubscribButton() {
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".footer2__subscribe-button"))));
        driver.findElement(By.cssSelector(".footer2__subscribe-button")).submit();
        System.out.println("Completed test mailbox in the field 'Subscribe to our news'");
    }

    @cucumber.api.java.en.Then("Checking the message: \"You have successfully subscribed\"")
    public void messageCheck() {
        Assertions.assertEquals("Вы успешно подписались", driver.findElement(By.cssSelector(".subscribe-modal__success")).getText());
        System.out.println("A message appeared: You have successfully subscribed");
    }

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.out.println("Driver was set up");

        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
    }

    @After
    public void end() {

        if (driver != null)
            driver.quit();
    }
}
