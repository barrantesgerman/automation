package org.habv.automation.locators;

import org.habv.automation.configurations.selenium.PageObjectBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FilerFolderLocators extends PageObjectBase {

    public FilerFolderLocators(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "a[href^='/admin/filer/folder/make_folder/?parent_id=']")
    protected WebElement newFolderElement;

//    @FindBy(css = "a[title='Change folder details']")
//    protected WebElement editFolderElement;
    protected String editFolderElement = "//table[@id=\"result_list\"]/tbody/tr[@data-folder-name='%s']/td[@class='column-action']/a[@title='Change folder details']";

//    @FindBy(css = "a[title='Remove folder']")
//    protected WebElement deleteFolderElement;
    protected String deleteFolderElement = "//table[@id=\"result_list\"]/tbody/tr[@data-folder-name='%s']/td[@class='column-action']/a[@title='Remove folder']";
    
    protected String folderRowElement = "//table[@id=\"result_list\"]/tbody/tr[@data-folder-name='%s']";

}
