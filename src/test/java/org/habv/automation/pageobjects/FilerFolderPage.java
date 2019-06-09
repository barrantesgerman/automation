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

    public boolean isEditFolderDisplayed() {
        return this.getBot().isElementDisplayed(this.editFolderElement);
    }

    public boolean isDeleteFolderDisplayed() {
        return this.getBot().isElementDisplayed(this.deleteFolderElement);
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

    public EditFolderPage editFolderClick() {
        this.editFolderElement.click();
        return PageFactory.initElements(this.getDriver(), EditFolderPage.class);
    }

    public DeleteFolderPage deleteFolderClick() {
        this.deleteFolderElement.click();
        return PageFactory.initElements(this.getDriver(), DeleteFolderPage.class);
    }
}
