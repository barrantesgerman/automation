package org.habv.automation.testcases;

import org.habv.automation.configurations.selenium.TestCaseBase;
import org.habv.automation.pageobjects.AddFolderPage;
import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.FilerFolderPage;
import org.habv.automation.pageobjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Practica02 extends TestCaseBase {

    @Test(groups = {"sesion2"})
    @Parameters({"username", "password"})
    public void createFiler(String userName, String password) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        loginPage.fillUserName(userName);
        loginPage.fillPassword(password);
        DashBoardPage dashBoardPage = loginPage.submit();

        // verificar que el login fue exitoso
        Assert.assertTrue(dashBoardPage.isFoldersLinkDisplayed(), "NO se mostro el link de Folders");

        FilerFolderPage filerFolderPage = dashBoardPage.foldersLinkClick();
        // verificar que la navegacion fue exitosa
        Assert.assertTrue(filerFolderPage.isNewFolderDisplayed(), "NO se mostro el boton de New Folder");
        AddFolderPage addFolderPage = filerFolderPage.newFolderClick();
        addFolderPage.fillFolderName("HERMAN");
        addFolderPage.submit();
    }
}
