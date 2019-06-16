package org.habv.automation.commons;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginCommons {

    public static DashBoardPage login(LoginPage loginPage, String userName, String password) {
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        DashBoardPage dashBoardPage = loginPage.submit();
        Assert.assertTrue(dashBoardPage.isChangePasswordDisplayed(), "NO se mostro el link para cambio de contrasena");
        return dashBoardPage;
    }

    public static void logout(PageObjectBase pagina) {
        pagina.getDriver().findElement(By.cssSelector("[href='/admin/logout/']")).click();
        pagina.getDriver().findElement(By.cssSelector("[href='/admin/']")).click();
    }
}
