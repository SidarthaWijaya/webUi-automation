package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pages.LoginPage;

import static org.junit.Assert.*;

public class LoginSteps {
    private WebDriver driver;
    private LoginPage loginPage;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("driver.gecko.driver", "/Users/Sidarthawijaya/Downloads/geckodriver 3");
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        driver.get("");
        loginPage = new LoginPage(driver);
    }

    @When("I enter valid username and password")
    public void iEnterValidUsernameAndPassword() {
        loginPage.enterUsername("validUser");
        loginPage.enterPassword("validPass");
    }

    @When("I enter invalid username and password")
    public void iEnterInvalidUsernameAndPassword() {
        loginPage.enterUsername("invalidUser");
        loginPage.enterPassword("invalidPass");
    }

    @And("I click on login button")
    public void iClickOnLoginButton() {
        loginPage.clickLogin();
    }

    @Then("I should be redirected to the homepage")
    public void iShouldBeRedirectedToTheHomepage() {
        assertEquals("http://example.com/home", driver.getCurrentUrl());
        driver.quit();
    }

    @Then("I should see an error message")
    public void iShouldSeeAnErrorMessage() {
        assertTrue(driver.getPageSource().contains("Invalid credentials"));
        driver.quit();
    }
}

