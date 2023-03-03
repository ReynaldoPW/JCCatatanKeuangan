package com.juaracoding.appium.pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    private AndroidDriver<MobileElement> driver;

    @AndroidFindBy(id="android:id/button2")
    private MobileElement btnTutup;

    @AndroidFindBy(xpath="//androidx.appcompat.app.a.c[@content-desc=\"Daily\"]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.TextView")
    private MobileElement txtTanggal;
    @AndroidFindBy(id = "com.chad.financialrecord:id/btnExpense")
    private MobileElement btnExpense;

    @AndroidFindBy(id = "com.chad.financialrecord:id/btnIncome")
    private MobileElement btnIncome;

    public HomePage(AndroidDriver<MobileElement> driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickDismissButton() {
        btnTutup.click();
    }

    public String txtTanggal(){
        return txtTanggal.getText();
    }
}
