package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static helper.Utility.driver;
import static org.assertj.core.api.Assertions.assertThat;

public class WebPage {


    By input_username = By.id("user-name");
    By input_pwd = By.id("password");
    By btn_login = By.id("login-button");
    By icon_cart = By.xpath("//*[@class=\"shopping_cart_link\"]");
    By icon_cart_item = By.xpath("//span[@class=\"shopping_cart_badge\"]");
    By addItem = By.xpath("(//*[text () = 'Add to cart'])[1]");
    By removeItem = By.xpath("(//*[text () = 'Remove'])[1]");
    By sortItem = By.xpath("//select");
    By sortItemHilo = By.xpath("//option[@value=\"hilo\"]");
    By sortItemZtoA = By.xpath("//option[@value=\"za\"]");
    By firstItem = By.xpath("(//*[@class=\"inventory_item_name \"])[1]");
    By cartIcon = By.className("shopping_cart_link");
    By checkoutButton = By.id("checkout");
    By firstNameField = By.id("first-name");
    By lastNameField = By.id("last-name");
    By zipCodeField = By.id("postal-code");
    By continueButton = By.id("continue");
    By finishButton = By.id("finish");
    By checkoutCompleteContainer = By.id("checkout_complete_container");
    By checkoutOverviewTitle = By.xpath("//span[contains(text(),'Checkout: Overview')]");





    By err_msg(String errmsg) {
        return By.xpath("//*[contains(text(),' " + errmsg + "')]");
    }

    public void goToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    public void inputUsername(String username) {
        driver.findElement(input_username).sendKeys(username);
    }

    public void inputPassword(String pwd) {
        driver.findElement(input_pwd).sendKeys(pwd);
    }

    public void clickBtnLogin() {
        driver.findElement(btn_login).click();

    }

    public void verifyIconCart() {
        driver.findElement(icon_cart).isDisplayed();
    }

    public void verifyErrMsg(String errMsg) {
        driver.findElement(err_msg(errMsg)).isDisplayed();
    }

    public void itemAddToCart() {
        driver.findElement(addItem).click();
    }

    public void itemRemoveToCart() {
        driver.findElement(removeItem).click();
    }

    public void verifyItemCart(String itemExpected) {
        String itemActual = driver.findElement(icon_cart_item).getText();
        assertThat(itemActual).isEqualTo(itemExpected);
    }

    public void clickSortItemHighToLow() {
        String itemBefore, itemAfter;

        itemBefore = driver.findElement(firstItem).getText();
        driver.findElement(sortItem).click();
        driver.findElement(sortItemHilo).click();
        itemAfter = driver.findElement(firstItem).getText();

        assertThat(itemBefore).isNotEqualTo(itemAfter);
    }

    public void clickSortItemZtoA() {
        String itemBefore, itemAfter;

        itemBefore = driver.findElement(firstItem).getText();
        driver.findElement(sortItem).click();
        driver.findElement(sortItemZtoA).click();
        itemAfter = driver.findElement(firstItem).getText();

        assertThat(itemBefore).isNotEqualTo(itemAfter);
    }

    public void clickcart(){
        driver.findElement(cartIcon).click();
    }


    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }


    public void inputFirstName(String firstName) {
        driver.findElement(firstNameField).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        driver.findElement(lastNameField).sendKeys(lastName);
    }

    public void inputZipCode(String zipCode) {
        driver.findElement(zipCodeField).sendKeys(zipCode);
    }

    public void clickContinue() {
        driver.findElement(continueButton).click();
    }

    public void clickFinish() {
        driver.findElement(finishButton).click();
    }


    public boolean isOnCheckoutOverviewPage() {
        return driver.findElement(By.xpath("//span[contains(text(),'Checkout: Overview')]")).isDisplayed();
    }

    public boolean isOnCheckoutCompletePage() {
        return driver.findElement(By.xpath("//h2[contains(text(),'THANK YOU FOR YOUR ORDER')]")).isDisplayed();
    }
}

