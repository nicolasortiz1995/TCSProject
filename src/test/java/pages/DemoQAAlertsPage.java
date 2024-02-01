package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoQAAlertsPage {
    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div/div[3]")
    public WebElement alertsButton;

    @FindBy(xpath = "/html/body/div[2]/div/div/div[2]/div[1]/div/div/div[3]/div/ul/li[2]")
    public WebElement alertButton;

    @FindBy(id = "alertButton")
    public WebElement buttonAlert;

    @FindBy(id = "timerAlertButton")
    public WebElement buttonTimerAlert;

    @FindBy(id = "confirmButton")
    public WebElement buttonConfirm;

    @FindBy(id = "promtButton")
    public WebElement buttonPromt;

    public DemoQAAlertsPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }
}
