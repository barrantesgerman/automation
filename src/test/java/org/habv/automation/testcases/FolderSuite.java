package org.habv.automation.testcases;

import org.habv.automation.commons.LoginCommons;
import org.habv.automation.configurations.selenium.TestCaseBase;
import org.habv.automation.pageobjects.AddFolderPage;
import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.DeleteFolderPage;
import org.habv.automation.pageobjects.EditFolderPage;
import org.habv.automation.pageobjects.FilerFolderPage;
import org.habv.automation.pageobjects.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class FolderSuite extends TestCaseBase {

    @Test(groups = {"full_regression", "folders"})
    @Parameters({"username", "password", "new_folder"})
    public void createFolder(String userName, String password, String newFolder) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        // verificar que el login fue exitoso
        Assert.assertTrue(dashBoardPage.isFoldersLinkDisplayed(), "NO se mostro el link de Folders");

        FilerFolderPage filerFolderPage = dashBoardPage.foldersLinkClick();
        // verificar que la navegacion fue exitosa
        Assert.assertTrue(filerFolderPage.isNewFolderDisplayed(), "NO se mostro el boton de New Folder");
        AddFolderPage addFolderPage = filerFolderPage.newFolderClick();
        addFolderPage.fillFolderName(newFolder);
        addFolderPage.submit();
        // verificar que se muestra mensaje
        filerFolderPage.updateWindow();
        Assert.assertTrue(filerFolderPage.isFolderRowDisplayed(newFolder), "NO se mostro el Folder: " + newFolder);
    }

    @Test(groups = {"full_regression", "folders"}, dependsOnMethods = {"createFolder"})
    @Parameters({"username", "password", "new_folder", "edit_folder"})
    public void editFolder(String userName, String password, String newFolder, String editFolder) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        // verificar que el login fue exitoso
        Assert.assertTrue(dashBoardPage.isFoldersLinkDisplayed(), "NO se mostro el link de Folders");

        FilerFolderPage filerFolderPage = dashBoardPage.foldersLinkClick();
        // verificar que la navegacion fue exitosa
        Assert.assertTrue(filerFolderPage.isEditFolderDisplayed(newFolder), "NO se mostro el boton de edit Folder");
        EditFolderPage editFolderPage = filerFolderPage.editFolderClick(newFolder);
        editFolderPage.fillFolderName(editFolder);
        editFolderPage.submit();
        Assert.assertTrue(filerFolderPage.isFolderRowDisplayed(editFolder), "NO se mostro el Folder: " + editFolder);
    }

    @Test(groups = {"full_regression", "folders"}, dependsOnMethods = {"editFolder"})
    @Parameters({"username", "password", "edit_folder"})
    public void deleteFolder(String userName, String password, String editFolder) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        // verificar que el login fue exitoso
        Assert.assertTrue(dashBoardPage.isFoldersLinkDisplayed(), "NO se mostro el link de Folders");

        FilerFolderPage filerFolderPage = dashBoardPage.foldersLinkClick();
        // verificar que la navegacion fue exitosa
        Assert.assertTrue(filerFolderPage.isDeleteFolderDisplayed(editFolder), "NO se mostro el boton de Delete Folder");
        DeleteFolderPage deleteFolderPage = filerFolderPage.deleteFolderClick(editFolder);
        deleteFolderPage.submit();
        Assert.assertFalse(filerFolderPage.isFolderRowDisplayed(editFolder), "SI se mostro el Folder: " + editFolder);
    }
}
