package org.habv.automation.testcases;

import org.habv.automation.configurations.selenium.TestCaseBase;
import org.habv.automation.pageobjects.LoginFailPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practica01 extends TestCaseBase {

    @Test(groups = {"sesion2"})
    @Parameters({"wrong_username", "wrong_password"})
    public void invalidLogin(String userName, String password) {
        // llenar el formulario de login mal
        LoginFailPage loginPage = PageFactory.initElements(this.getDriver(), LoginFailPage.class);
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        loginPage.submit();

        // verificar que el login fue fallido
        Assert.assertTrue(loginPage.isErrorNoteDisplayed(), "NO se mostro el mensaje de error");
    }
}
