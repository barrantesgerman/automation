package org.habv.automation.testcases;

import org.habv.automation.commons.LoginCommons;
import org.habv.automation.configurations.selenium.TestCaseBase;
import org.habv.automation.pageobjects.AddFolderPage;
import org.habv.automation.pageobjects.DashBoardPage;
import org.habv.automation.pageobjects.DeleteFolderPage;
import org.habv.automation.pageobjects.EditFolderPage;
import org.habv.automation.pageobjects.FilerFolderPage;
import org.habv.automation.pageobjects.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
        WebElement tableRow = getDriver().findElement(By.xpath("//tr[@data-folder-name='" + newFolder + "']"));
        Assert.assertTrue(tableRow.isDisplayed(), "NO se mostro el Folder: " + newFolder);
    }

    @Test(groups = {"full_regression", "folders"}, dependsOnMethods = {"createFolder"})
    @Parameters({"username", "password", "edit_folder"})
    public void editFolder(String userName, String password, String editFolder) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        // verificar que el login fue exitoso
        Assert.assertTrue(dashBoardPage.isFoldersLinkDisplayed(), "NO se mostro el link de Folders");

        FilerFolderPage filerFolderPage = dashBoardPage.foldersLinkClick();
        // verificar que la navegacion fue exitosa
        Assert.assertTrue(filerFolderPage.isEditFolderDisplayed(), "NO se mostro el boton de New Folder");
        EditFolderPage editFolderPage = filerFolderPage.editFolderClick();
        editFolderPage.fillFolderName(editFolder);
        editFolderPage.submit();
        WebElement tableRow = getDriver().findElement(By.xpath("//tr[@data-folder-name='" + editFolder + "']"));
        Assert.assertTrue(tableRow.isDisplayed(), "NO se mostro el Folder: " + editFolder);
    }

    @Test(groups = {"full_regression", "folders"}, dependsOnMethods = {"editFolder"})
    @Parameters({"username", "password"})
    public void deleteFolder(String userName, String password) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        LoginCommons.login(loginPage, userName, password);

        DashBoardPage dashBoardPage = PageFactory.initElements(this.getDriver(), DashBoardPage.class);
        // verificar que el login fue exitoso
        Assert.assertTrue(dashBoardPage.isFoldersLinkDisplayed(), "NO se mostro el link de Folders");

        FilerFolderPage filerFolderPage = dashBoardPage.foldersLinkClick();
        // verificar que la navegacion fue exitosa
        Assert.assertTrue(filerFolderPage.isDeleteFolderDisplayed(), "NO se mostro el boton de New Folder");
        DeleteFolderPage deleteFolderPage = filerFolderPage.deleteFolderClick();
        deleteFolderPage.submit();
        WebElement tableRow = getDriver().findElement(By.cssSelector("td[class='no-files']"));
        Assert.assertTrue(tableRow.isDisplayed(), "NO se mostro el mensaje 'Drop files here or use the \"Upload Files\" button'");
    }
}
