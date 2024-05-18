package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.LoginPage;

import static org.junit.Assert.assertNotNull;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginPage;

    @Given("I open the login page")
    public void iOpenTheLoginPage() {
        System.setProperty("webdriver.gecko.driver.marionette", "/Users/sidarthawijaya/Downloads/geckodriver");
        driver = new FirefoxDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @When("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the products page")
    public void iShouldSeeTheProductsPage() {
        Assert.assertTrue("Products page not displayed!", driver.getPageSource().contains("Products"));
    }

    @Then("the user should see an error message {string}")
    public void theUserShouldSeeAnErrorMessage(String arg0) {
    }
    public static void quitDriver() throws InterruptedException {
        Thread.sleep(2000);
        quitDriver();
    }


}
