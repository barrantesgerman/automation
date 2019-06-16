package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashBoardLocators extends PageObjectBase {

    public DashBoardLocators(WebDriver driver) {
        super(driver);
    }
    
    protected String userNameElement = "//div[@id=\"user-tools\"]/strong[text()='%s']";

    @FindBy(css = "[href='/admin/logout/']")
    protected WebElement logOutElement;

    @FindBy(css = "[href='/admin/password_change/']")
    protected WebElement changePasswordElement;

    @FindBy(css = "[href='/admin/filer/folder/']")
    protected WebElement foldersLinkElement;
    
    @FindBy(css = "[href='/admin/auth/user/']")
    protected WebElement usersLinkElement;
}
