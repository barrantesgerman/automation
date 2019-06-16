package org.habv.automation.testcases;

import java.io.IOException;
import jxl.read.biff.BiffException;
import org.habv.automation.commons.UserCommons;
import org.habv.automation.configurations.selenium.TestCaseBase;
import org.habv.automation.pageobjects.LoginPage;
import org.habv.automation.utils.ExcelUtility;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class UserProviderSuite extends TestCaseBase {

    @Test(groups = {"full_regression", "login"})
    @Parameters({"username", "password", "new_user", "new_password", "change_password"})
    public void test01(String userName, String password, String newUser, String newPassword, String changePassword) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        UserCommons.createUser(loginPage, userName, password, newUser, newPassword);
        UserCommons.changePassword(loginPage, userName, password, newUser, changePassword);
        UserCommons.checkUser(loginPage, newUser, changePassword);
        UserCommons.deleteUser(loginPage, userName, password, newUser);
    }

    @DataProvider(name = "dataProviderMatriz")
    public static Object[][] dataProviderMatriz() {
        return new Object[][]{
            {"automation", "Automation123$", "JAVA", "MXtja+a7HWqx*R{4", "xUXF>#q8N3aT*@,U"},
            {"automation", "Automation123$", "MAVEN", "7#,vE6pRtDR?c/~K", "!9f.J*e=E'@TcH>_"},
            {"automation", "Automation123$", "SELENIUM", "9*T9=7srTL5.8TeS", "4qhtvZA2!qEA>'P+"},
            {"automation", "Automation123$", "TESTNG", "3{qXPR@>gp$E_C#a", "5;nd5XA*@9N-wY5T"}
        };
    }

    @Test(groups = {"full_regression", "login"}, dataProvider = "dataProviderMatriz")
    public void test02(String userName, String password, String newUser, String newPassword, String changePassword) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        UserCommons.createUser(loginPage, userName, password, newUser, newPassword);
        UserCommons.changePassword(loginPage, userName, password, newUser, changePassword);
        UserCommons.checkUser(loginPage, newUser, changePassword);
        UserCommons.deleteUser(loginPage, userName, password, newUser);
    }
    
    @DataProvider(name = "dataProviderXLS")
    public static Object[][] dataProviderXLS() throws IOException, BiffException {
        return new ExcelUtility("src/test/resources/Excel/usersXLS.xls").getData();
    }
    
    @Test(groups = {"full_regression", "usuarios"}, dataProvider = "dataProviderXLS")
    public void test03(String userName, String password, String newUser, String newPassword, String changePassword) {
        // llenar el formulario de login
        LoginPage loginPage = PageFactory.initElements(this.getDriver(), LoginPage.class);
        UserCommons.createUser(loginPage, userName, password, newUser, newPassword);
        UserCommons.changePassword(loginPage, userName, password, newUser, changePassword);
        UserCommons.checkUser(loginPage, newUser, changePassword);
        UserCommons.deleteUser(loginPage, userName, password, newUser);
    }
}
