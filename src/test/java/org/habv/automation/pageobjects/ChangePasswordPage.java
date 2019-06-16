package org.habv.automation.pageobjects;

import org.habv.automation.locators.ChangePasswordLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ChangePasswordPage extends ChangePasswordLocators {
    
    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }
    
    public boolean isPassword1Displayed() {
        return this.getBot().isElementDisplayed(this.idPassword1Element);
    }
    
    public boolean isPassword2Displayed() {
        return this.getBot().isElementDisplayed(this.idPassword2Element);
    }

    public void fillPassword1(String pass) {
        this.idPassword1Element.sendKeys(pass);
    }

    public void fillPassword2(String pass) {
        this.idPassword2Element.sendKeys(pass);
    }

    public ChangeUserPage submit() {
        this.submitElement.submit();
        return PageFactory.initElements(this.getDriver(), ChangeUserPage.class);
    }
    
}
