package com.juaracoding.appium;



import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;
import java.net.URL;

import com.juaracoding.appium.pages.AddTransactionPage;
import com.juaracoding.appium.pages.HomePage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.testng.annotations.Test;

public class TestAddTransaction {
    private static AndroidDriver<MobileElement> driver;

    private HomePage homePage;
    private AddTransactionPage addTransactionPage;


    @BeforeClass
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "sdk gphone_x86");
        capabilities.setCapability("uuid", "emulator-5554");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "11");
//		capabilities.setCapability("appPackage", "com.google.android.calculator");
//		capabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
        capabilities.setCapability("appPackage", "com.chad.financialrecord");
        capabilities.setCapability("appActivity", "com.rookie.catatankeuangan.feature.splash.SplashActivity");
        capabilities.setCapability("autoGrantPermissions", true);
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        homePage = new HomePage(driver);
        addTransactionPage = new AddTransactionPage(driver);
    }

    @Test(priority = 1)
    public void homePage() {
        homePage.clickDismissButton();
        Assert.assertEquals(homePage.txtTanggal(),"Harian");
    }
    @Test(priority = 2)
    public void testAddExpenses(){
        addTransactionPage.addExpenseTransaction("15000","makan siang");
        Assert.assertEquals(addTransactionPage.getTxtExpense(),"15.000");
    }
    @Test(priority = 3)
    public void testAddIncome(){
        addTransactionPage.addIncomeTransaction("100000","gaji bulanan");
        Assert.assertEquals(addTransactionPage.getTxtIncome(),"100.000");
    }
    @AfterClass
    public void closeApp(){
        driver.quit();
    }
}
