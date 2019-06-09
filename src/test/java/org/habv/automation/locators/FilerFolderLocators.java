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

    /**
     * Selector: //table[@id="result_list"]/tbody/tr[@data-folder-name='HERMAN']/td[@class='column-action']/a[@title='Change folder details']
     */
    @FindBy(css = "a[title='Change folder details']")
    protected WebElement editFolderElement;

    /**
     * Selector: //table[@id="result_list"]/tbody/tr[@data-folder-name='HERMAN']/td[@class='column-action']/a[@title='Remove folder']
     */
    @FindBy(css = "a[title='Remove folder']")
    protected WebElement deleteFolderElement;

    @FindBy(id = "result_list")
    protected WebElement resultList;
}
