package org.habv.automation.testcases;

import org.habv.automation.commons.LoginCommons;
import org.habv.automation.configurations.selenium.TestCaseBase;
import org.habv.automation.pageobjects.AddUserPage;
import org.habv.automation.pageobjects.AuthUserPage;
import org.habv.automation.pageobjects.ChangePasswordPage;
import org.habv.automation.pageobjects.ChangeUserPage;
import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.DeleteUserPage;
import org.habv.automation.pageobjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserSuite extends TestCaseBase {

    @Test(groups = {"full_regression", "login"})
    @Parameters({"username", "password", "new_user", "new_password"})
    public void createUser(String userName, String password, String newUser, String newPassword) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        Assert.assertTrue(dashBoardPage.isUsersLinkDisplayed(), "NO se mostro el link de Users");

        AuthUserPage authUserPage = dashBoardPage.usersLinkClick();
        Assert.assertTrue(authUserPage.isTitleDisplayed(), "NO se mostro el titulo");
        Assert.assertTrue(authUserPage.isAddUserLinkDisplayed(), "NO se mostro el boton de Add Users");

        AddUserPage addUserPage = authUserPage.addUserClick();
        Assert.assertTrue(addUserPage.isTitleDisplayed(), "No se mostro el titulo");

        addUserPage.fillUserName(newUser);
        addUserPage.fillPasswod1(newPassword);
        addUserPage.fillPasswod2(newPassword);
        ChangeUserPage changeUserPage = addUserPage.submit();
        Assert.assertTrue(changeUserPage.isTitleDisplayed(), "No se mostro el titulo");

        changeUserPage.checkStaff();
        changeUserPage.checkSuperuser();
        authUserPage = changeUserPage.submit();

        Assert.assertTrue(authUserPage.isUserLinkDisplayed(newUser), "No se mostro el nuevo usuario");
    }

    @Test(groups = {"full_regression", "login"}, dependsOnMethods = {"createUser"})
    @Parameters({"username", "password", "new_user", "change_password"})
    public void changePassword(String userName, String password, String newUser, String changePassword) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        Assert.assertTrue(dashBoardPage.isUsersLinkDisplayed(), "NO se mostro el link de Users");

        AuthUserPage authUserPage = dashBoardPage.usersLinkClick();
        Assert.assertTrue(authUserPage.isTitleDisplayed(), "NO se mostro el titulo");
        Assert.assertTrue(authUserPage.isUserLinkDisplayed(newUser), "NO se mostro el link del usuario");

        ChangeUserPage changeUserPage = authUserPage.userLinkClick(newUser);
        Assert.assertTrue(changeUserPage.isChangePasswordLinkDisplayed(), "No se mostro el link para cambiar la clave");

        ChangePasswordPage changePasswordPage = changeUserPage.changePasswordClick();
        Assert.assertTrue(changePasswordPage.isPassword1Displayed(), "No se mostro el campo Password1");
        Assert.assertTrue(changePasswordPage.isPassword2Displayed(), "No se mostro el campo Password2");

        changePasswordPage.fillPassword1(changePassword);
        changePasswordPage.fillPassword2(changePassword);
        changeUserPage = changePasswordPage.submit();

        Assert.assertTrue(changeUserPage.isTitleDisplayed(), "No se mostro el titulo");
    }

    @Test(groups = {"full_regression", "login"}, dependsOnMethods = {"changePassword"})
    @Parameters({"new_user", "change_password"})
    public void checkUser(String newUser, String changePassword) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, newUser, changePassword);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        Assert.assertTrue(dashBoardPage.isUserNameDisplayed(newUser), "NO se mostro el nombre de usuario");
    }

    @Test(groups = {"full_regression", "login"}, dependsOnMethods = {"checkUser"})
    @Parameters({"username", "password", "new_user"})
    public void deleteUser(String userName, String password, String newUser) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        Assert.assertTrue(dashBoardPage.isUsersLinkDisplayed(), "NO se mostro el link de Users");

        AuthUserPage authUserPage = dashBoardPage.usersLinkClick();
        Assert.assertTrue(authUserPage.isTitleDisplayed(), "NO se mostro el titulo");
        Assert.assertTrue(authUserPage.isUserLinkDisplayed(newUser), "NO se mostro el link del usuario");

        ChangeUserPage changeUserPage = authUserPage.userLinkClick(newUser);
        Assert.assertTrue(changeUserPage.isDeleteLinkDisplayed(), "No se mostro el link para cambiar la clave");

        DeleteUserPage deleteUserPage = changeUserPage.deleteLinkClick();
        authUserPage = deleteUserPage.submit();
        Assert.assertFalse(authUserPage.isUserLinkDisplayed(newUser), "SI se mostro el link del usuario");
    }

}
