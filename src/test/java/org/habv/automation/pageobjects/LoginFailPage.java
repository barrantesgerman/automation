package org.habv.automation.pageobjects;

import org.habv.automation.locators.LoginFailLocators;
import org.openqa.selenium.WebDriver;

public class LoginFailPage extends LoginFailLocators {

    public LoginFailPage(WebDriver driver) {
        super(driver);
    }

    public void fillUserName(String userName) {
        this.userNameElement.sendKeys(userName);
    }

    public void fillPassword(String password) {
        this.passwordElement.sendKeys(password);
    }

    public void submit() {
        this.submitElement.submit();
    }

    public boolean isErrorNoteDisplayed() {
        return this.getBot().isElementDisplayed(this.errorNoteElement);
    }
}
