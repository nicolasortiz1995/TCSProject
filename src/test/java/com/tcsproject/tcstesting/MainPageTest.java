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


    }

    @AfterClass
    public void tearDown() {
        //driver.quit();
    }

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
        System.out.println(prop.getProperty("SauceDemoAssert"));
    }

    @Test(priority = 2)
    public void TC2_DemoQA_Widgets(){
        driver.get(prop.getProperty("DemoQaURL"));
        demoQAWidgetsPage.widgetsButton.click();
        basePage.waitToBeClickable(demoQAWidgetsPage.autoCompleteButton);
        basePage.getFocus(demoQAWidgetsPage.autoCompleteButton);
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

}
