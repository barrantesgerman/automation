package org.habv.automation.pageobjects;

import org.habv.automation.locators.LoginLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LoginLocators {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String userName) {
        this.userNameElement.sendKeys(userName);
    }

    public void fillPassword(String password) {
        this.passwordElement.sendKeys(password);
    }

    public DashBoardPage submit() {
        this.submitElement.submit();
        return PageFactory.initElements(this.getDriver(), DashBoardPage.class);
    }
}
