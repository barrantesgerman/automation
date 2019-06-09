package org.habv.automation.commons;

import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.LoginPage;
import org.testng.Assert;

public class LoginCommons {

    public static void login(LoginPage loginPage, String userName, String password) {
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        DashBoardPage dashBoardPage = loginPage.submit();
        Assert.assertTrue(dashBoardPage.isChangePasswordDisplayed(),
                "NO se mostro el link para cambio de contrasena");
    }
}
