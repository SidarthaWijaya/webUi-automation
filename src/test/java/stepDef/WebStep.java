package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.WebPage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class WebStep {
    WebPage webPage;

    public WebStep() {
        this.webPage = new WebPage();
    }

    @Given("user go to login page")
    public void userGoToLoginPage() {
        webPage.goToLoginPage();
    }

    @And("user input username {string}")
    public void userInputUsername(String username) {
        webPage.inputUsername(username);
    }

    @And("user input pwd {string}")
    public void userInputPwd(String pwd) {
        webPage.inputPassword(pwd);
    }

    @And("user click login button")
    public void userClickLoginButton() {
        webPage.clickBtnLogin();
    }

    @Then("user verify see cart icon")
    public void userVerifySeeCartIcon() {
        webPage.verifyIconCart();
    }

    @Then("user verify see errmsg {string}")
    public void userVerifySeeErrmsg(String errMsg) {
        webPage.verifyErrMsg(errMsg);
    }

    @And("user click add to cart")
    public void userClickAddToCart() {
        webPage.itemAddToCart();
    }

    @Then("verify cart item has {string}")
    public void verifyCartItemHas(String itemExpected) {
        webPage.verifyItemCart(itemExpected);
    }

    @And("user click remove item chart")
    public void userClickRemoveItemChart() {
        webPage.itemRemoveToCart();
    }

    @And("user click sort item high to low")
    public void userClickSortItemHighToLow() {
        webPage.clickSortItemHighToLow();
        
    }

    @And("user click sort item Z to A")
    public void userClickSortItemZToA() {
        webPage.clickSortItemZtoA();
    }

    @And("user click cart")
    public void user_click_cart(){
        webPage.clickcart();
    }



    @Then("user click checkout button")
    public void the_user_click_checkout() {
        webPage.clickCheckout();
    }



    @When("user inputs first name")
    public void the_user_inputs_first_name() {
        webPage.inputFirstName("John");
    }

    @When("user inputs last name")
    public void the_user_inputs_last_name() {
        webPage.inputLastName("Doe");
    }

    @When("user inputs zipcode")
    public void the_user_inputs_zipcode() {
        webPage.inputZipCode("12345");
    }

    @When("user clicks continue")
    public void the_user_clicks_continue() {
        webPage.clickContinue();
    }

    @Then("user should be on the checkout overview page")
    public void the_user_should_be_on_the_checkout_overview_page() {
        assertThat(webPage.isOnCheckoutOverviewPage()).isTrue();
    }

    @When("user clicks finish")
    public void the_user_clicks_finish() {
        webPage.clickFinish();
    }

}
