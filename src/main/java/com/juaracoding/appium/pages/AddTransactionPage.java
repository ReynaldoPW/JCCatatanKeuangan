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

    @AndroidFindBy(id = "com.chad.financialrecord:id/etAmount")
    private MobileElement amountText;


    @AndroidFindBy(id = "com.chad.financialrecord:id/etNote")
    private MobileElement noteText;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btSave")
    private MobileElement btnSave;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[2]")
    private MobileElement txtExpense;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.view.ViewGroup[2]/android.widget.RelativeLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.TextView[1]")
    private MobileElement txtIncome;

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
    }
    public String getTxtExpense(){

        return txtExpense.getText();
    }
    public String getTxtIncome(){
        return txtIncome.getText();
    }
    public void addIncomeTransaction(String amount, String note) {
        btnMenu.click();
        btnIncome.click();
        amountText.sendKeys(amount);
        noteText.sendKeys(note);
        btnSave.click();
    }
}
