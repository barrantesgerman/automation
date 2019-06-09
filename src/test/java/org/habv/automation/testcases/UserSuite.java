package org.habv.automation.testcases;

import org.habv.automation.commons.LoginCommons;
import org.habv.automation.configurations.selenium.TestCaseBase;
import org.habv.automation.pageobjects.AddUserPage;
import org.habv.automation.pageobjects.ChangeUserPage;
import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserSuite extends TestCaseBase {
    //Usuario logueado: //div[@id="user-tools"]/strong[text()='automation']

    @Test(groups = {"full_regression", "login"})
    @Parameters({"username", "password"})
    public void createUser(String userName, String password) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);
        // agregar usuario
        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        AddUserPage addUserPage = dashBoardPage.addUserLinkClick();
        Assert.assertTrue(addUserPage.isTitleDisplayed(), "No se mostro el titulo");
        addUserPage.fillUserName("PRUEBA");
        addUserPage.fillPasswod1("gbsystem01");
        addUserPage.fillPasswod2("gbsystem01");
        
        ChangeUserPage changeUserPage = addUserPage.submit();
        changeUserPage.checkStaff();
        changeUserPage.checkSuperuser();
        changeUserPage.submit();
    }
}
