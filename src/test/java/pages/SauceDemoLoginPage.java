package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SauceDemoLoginPage {

    @FindBy(id = "user-name")
    public WebElement inputUsername;

    @FindBy(id = "password")
    public WebElement inputPassword;

    @FindBy(id = "login-button")
    public WebElement inputLoginButton;

    @FindBy(xpath = "//select")
    public WebElement selectProductSortContainer;

    @FindBy(xpath = "//option[@value='hilo']")
    public WebElement optionHilo;

    @FindBy(xpath = "//*[text() = 'Sauce Labs Fleece Jacket']")
    public WebElement divSauceLabsFleeceJacket;

    @FindBy(id = "add-to-cart-sauce-labs-fleece-jacket")
    public WebElement buttonAddCart;

    @FindBy(id = "shopping_cart_container")
    public WebElement divShoppingCartContainer;

    @FindBy(id = "remove-sauce-labs-fleece-jacket")
    public WebElement waitButtonRemove;
    
    public SauceDemoLoginPage(WebDriver driver) {PageFactory.initElements(driver, this);}
}
