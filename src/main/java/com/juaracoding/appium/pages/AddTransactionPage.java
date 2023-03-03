package com.juaracoding.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddTransactionPage {
    private AndroidDriver<MobileElement> driver;

    @FindBy(id = "com.chad.financialrecord:id/etAmount")
    private MobileElement amountText;


    @FindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement noteText;

    @FindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement btnSave;

    @FindBy(id = "com.chad.financialrecord:id/tvBalance")
    private MobileElement txtBalance;

    @AndroidFindBy(id="com.chad.financialrecord:id/fabMenu")
    private MobileElement btnMenu;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement btnIncome;

    public AddTransactionPage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void addExpenseTransaction(String amount, String note) {
        btnMenu.click();
        amountText.sendKeys(amount);
        noteText.sendKeys(note);
        btnSave.click();
        btnMenu.click();
    }
    public String txtBalance(){
        return txtBalance.getText();
    }
    public void addIncomeTransaction(String amount, String note) {
        btnIncome.click();
        amountText.sendKeys(amount);
        noteText.sendKeys(note);
        btnSave.click();
    }
}
