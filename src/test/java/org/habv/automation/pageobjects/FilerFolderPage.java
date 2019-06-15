package org.habv.automation.pageobjects;

import org.habv.automation.locators.FilerFolderLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class FilerFolderPage extends FilerFolderLocators {

    private String windowHandler;

    public FilerFolderPage(WebDriver driver) {
        super(driver);
    }

    public boolean isNewFolderDisplayed() {
        return this.getBot().isElementDisplayed(this.newFolderElement);
    }

    public boolean isEditFolderDisplayed(String name) {
        return this.getBot().isXPathDisplayed(this.editFolderElement, name);
    }

    public boolean isDeleteFolderDisplayed(String name) {
        return this.getBot().isXPathDisplayed(this.deleteFolderElement, name);
    }

    public boolean isFolderRowDisplayed(String name) {
        return this.getBot().isXPathDisplayed(this.folderRowElement, name);
    }

    public void updateWindow() {
        getDriver().switchTo().window(this.windowHandler);
    }

    public AddFolderPage newFolderClick() {
        this.newFolderElement.click();
        this.windowHandler = getDriver().getWindowHandle();
        for (String currentWindow : getDriver().getWindowHandles()) {
            if (getDriver().switchTo().window(currentWindow).getTitle().equals("Add new folder | Django site admin")) {
                break;
            }
        }
        return PageFactory.initElements(this.getDriver(), AddFolderPage.class);
    }

    public EditFolderPage editFolderClick(String name) {
        this.getBot().findByXPath(this.editFolderElement, name).click();
        return PageFactory.initElements(this.getDriver(), EditFolderPage.class);
    }

    public DeleteFolderPage deleteFolderClick(String name) {
        this.getBot().findByXPath(this.deleteFolderElement, name).click();
        return PageFactory.initElements(this.getDriver(), DeleteFolderPage.class);
    }
}
