package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AuthUserLocators extends PageObjectBase {

    public AuthUserLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[text()='Select user to change']")
    protected WebElement titleElement;

    @FindBy(css = "[href='/admin/auth/user/add/']")
    protected WebElement addUserLinkElement;

    protected String userLinkElement = "//table[@id=\"result_list\"]/tbody/tr/th/a[text()='%s']";
    
}
