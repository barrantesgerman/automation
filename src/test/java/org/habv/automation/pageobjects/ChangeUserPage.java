package org.habv.automation.pageobjects;

import org.habv.automation.locators.ChangeUserLocators;
import org.openqa.selenium.WebDriver;

public class ChangeUserPage extends ChangeUserLocators {

    public ChangeUserPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleDisplayed() {
        return this.getBot().isElementDisplayed(this.titleElement);
    }

    public void checkStaff() {
        this.getBot().check(this.idIsStaffElement);
    }

    public void checkSuperuser() {
        this.getBot().check(this.idIsSuperUserElement);
    }

    public void submit() {
        this.submitElement.submit();
    }
}
