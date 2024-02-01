package com.tcsproject.tcstesting;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class MainPageTest {
    private WebDriver driver;
    private Properties prop;
    private BasePage basePage;
    private SauceDemoLoginPage sauceDemoLoginPage;
    private DemoQAWidgetsPage demoQAWidgetsPage;
    private DemoQAAlertsPage demoQAAlertsPage;

    @BeforeClass
    public void setUp() {
        this.prop = new Properties();
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            throw new RuntimeException("No se pudo cargar el archivo config.properties, verifique la ruta dado que es un archivo necesario para continuar.", e);
        }
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        sauceDemoLoginPage = new SauceDemoLoginPage(driver);
        basePage = new BasePage(driver);
        demoQAWidgetsPage = new DemoQAWidgetsPage(driver);
        demoQAAlertsPage = new DemoQAAlertsPage(driver);
    }

    @AfterClass
    public void tearDown() {driver.quit();}

    @Test(priority = 1)
    public void TC1_DemoSauce() {
        driver.get(prop.getProperty("SauceDemoURL"));
        sauceDemoLoginPage.inputUsername.sendKeys(prop.getProperty("SauceDemoURLUser"));
        sauceDemoLoginPage.inputPassword.sendKeys(prop.getProperty("SauceDemoURLPass"));
        sauceDemoLoginPage.inputLoginButton.click();
        basePage.waitToBeClickable(sauceDemoLoginPage.selectProductSortContainer);
        sauceDemoLoginPage.selectProductSortContainer.click();
        basePage.waitToBeClickable(sauceDemoLoginPage.optionHilo);
        sauceDemoLoginPage.optionHilo.click();
        basePage.waitToBeClickable(sauceDemoLoginPage.divSauceLabsFleeceJacket);
        sauceDemoLoginPage.divSauceLabsFleeceJacket.click();
        sauceDemoLoginPage.buttonAddCart.click();
        sauceDemoLoginPage.divShoppingCartContainer.click();
        basePage.waitToBeClickable(sauceDemoLoginPage.waitButtonRemove);
        Assert.assertTrue(driver.getPageSource().contains(prop.getProperty("SauceDemoAssert")));
    }

    @Test(priority = 2)
    public void TC2_DemoQA_Widgets(){
        driver.get(prop.getProperty("DemoQaURL"));
        demoQAWidgetsPage.widgetsButton.click();
        basePage.getFocus(demoQAWidgetsPage.autoCompleteButton);
        basePage.waitToBeClickable(demoQAWidgetsPage.autoCompleteButton);
        demoQAWidgetsPage.autoCompleteButton.click();
        basePage.waitToBeClickable(demoQAWidgetsPage.multipleField);
        demoQAWidgetsPage.multipleField.sendKeys(prop.getProperty("Color1"));
        basePage.waitToBeVisible(demoQAWidgetsPage.multipleColor);
        demoQAWidgetsPage.multipleColor.click();
        basePage.waitToBeClickable(demoQAWidgetsPage.singleField);
        demoQAWidgetsPage.singleField.sendKeys(prop.getProperty("Color2"));
        basePage.waitToBeVisible(demoQAWidgetsPage.singleColor);
        demoQAWidgetsPage.singleColor.click();
    }
    @Test(priority = 3)
    public void TC3_DemoQA_Alerts_See(){
        driver.get(prop.getProperty("DemoQaURL"));
        demoQAAlertsPage.alertsButton.click();
        basePage.waitToBeClickable(demoQAAlertsPage.alertButton);
        basePage.getFocus(demoQAAlertsPage.alertButton);
        demoQAAlertsPage.alertButton.click();
        demoQAAlertsPage.buttonAlert.click();
        basePage.waitAlertVisible();
        driver.switchTo().alert().accept();
    }

    @Test(priority = 4)
    public void TC4_DemoQA_Alerts_Wait(){
        demoQAAlertsPage.buttonTimerAlert.click();
        basePage.waitAlertVisible();
        driver.switchTo().alert().accept();
    }

    @Test(priority = 5)
    public void TC5_DemoQA_Alerts_Ok(){
        demoQAAlertsPage.buttonConfirm.click();
        basePage.waitAlertVisible();
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains(prop.getProperty("TC5Assert")));
    }

    @Test(priority = 6)
    public void TC6_DemoQA_Alerts_Cancel(){
        demoQAAlertsPage.buttonConfirm.click();
        basePage.waitAlertVisible();
        driver.switchTo().alert().dismiss();
        Assert.assertTrue(driver.getPageSource().contains(prop.getProperty("TC6Assert")));
    }
    @Test(priority = 7)
    public void TC7_DemoQA_Alerts_Enter(){
        demoQAAlertsPage.buttonPromt.click();
        basePage.waitAlertVisible();
        driver.switchTo().alert().sendKeys(prop.getProperty("TC7Assert"));
        driver.switchTo().alert().accept();
        Assert.assertTrue(driver.getPageSource().contains("You entered "+prop.getProperty("TC7Assert")));
    }
}
