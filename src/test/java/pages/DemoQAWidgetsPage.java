package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQAWidgetsPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[4]")
    public WebElement widgetsButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[4]/div/ul/li[2]")
    public WebElement autoCompleteButton;

    @FindBy(xpath = "//*[@id='autoCompleteMultipleInput']")
    public WebElement multipleField;

    @FindBy(xpath = "//*[@id='react-select-2-option-0']")
    public WebElement multipleColor;

    @FindBy(xpath = "//*[@id='autoCompleteSingleInput']")
    public WebElement singleField;

    @FindBy(xpath = "//*[@id='react-select-3-option-0']")
    public WebElement singleColor;

    public DemoQAWidgetsPage (WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
