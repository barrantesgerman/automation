package org.habv.automation.commons;

import org.habv.automation.pageobjects.AddUserPage;
import org.habv.automation.pageobjects.AuthUserPage;
import org.habv.automation.pageobjects.ChangePasswordPage;
import org.habv.automation.pageobjects.ChangeUserPage;
import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.DeleteUserPage;
import org.habv.automation.pageobjects.LoginPage;
import org.testng.Assert;

public class UserCommons {

    public static void createUser(LoginPage loginPage, String userName, String password, String newUser, String newPassword) {
        // llenar el formulario de login
        DashBoardPage dashBoardPage = LoginCommons.login(loginPage, userName, password);

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
        LoginCommons.logout(authUserPage);
    }

    public static void changePassword(LoginPage loginPage, String userName, String password, String newUser, String changePassword) {
        DashBoardPage dashBoardPage = LoginCommons.login(loginPage, userName, password);

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
        LoginCommons.logout(changeUserPage);
    }

    public static void checkUser(LoginPage loginPage, String newUser, String changePassword) {
        DashBoardPage dashBoardPage = LoginCommons.login(loginPage, newUser, changePassword);

        Assert.assertTrue(dashBoardPage.isUserNameDisplayed(newUser), "NO se mostro el nombre de usuario");
        LoginCommons.logout(dashBoardPage);
    }
    
    public static void deleteUser(LoginPage loginPage, String userName, String password, String newUser) {
        // llenar el formulario de login
        DashBoardPage dashBoardPage = LoginCommons.login(loginPage, userName, password);

        Assert.assertTrue(dashBoardPage.isUsersLinkDisplayed(), "NO se mostro el link de Users");

        AuthUserPage authUserPage = dashBoardPage.usersLinkClick();
        Assert.assertTrue(authUserPage.isTitleDisplayed(), "NO se mostro el titulo");
        Assert.assertTrue(authUserPage.isUserLinkDisplayed(newUser), "NO se mostro el link del usuario");

        ChangeUserPage changeUserPage = authUserPage.userLinkClick(newUser);
        Assert.assertTrue(changeUserPage.isDeleteLinkDisplayed(), "No se mostro el link para cambiar la clave");

        DeleteUserPage deleteUserPage = changeUserPage.deleteLinkClick();
        authUserPage = deleteUserPage.submit();
        Assert.assertFalse(authUserPage.isUserLinkDisplayed(newUser), "SI se mostro el link del usuario");
        LoginCommons.logout(authUserPage);
    }
}
