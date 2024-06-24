package com.spring.springboot.testautomation.pages.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.webframework.annotations.PageComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertEquals;

@Slf4j
@PageComponent
public class NewWindowPage extends BasePage {

    // ********* Web Elements by using PageComponent Factory *********
    @FindBy(how = How.XPATH, using = "//h3[contains(text(),'New Window')]")
    private WebElement pageHeading;

    // ********* PageComponent Methods *********
    public NewWindowPage verifyNewWindowPageTitle(String expectedNewWindowPageTitle) {
        String actualNewWindowPageTitle = pageActions.elementActions.getPageTitle();
        assertEquals(actualNewWindowPageTitle, expectedNewWindowPageTitle);
        log.info("Verified new window page title: {}", pageActions.elementActions.getPageTitle());
        return this;
    }

    public NewWindowPage verifySuccessfulOpeningOfNewWindow(String expectedNewWindowPageHeading) {
        String actualNewWindowPageHeading = pageActions.elementActions.getText(pageHeading);
        assertEquals(actualNewWindowPageHeading, expectedNewWindowPageHeading);
        log.info("Verified new window page heading: {}", actualNewWindowPageHeading);
        return this;
    }

    @Override
    public boolean isAt() {
        pageActions.waitActions.waitForPageToBeLoaded();
        return pageActions.elementActions
                .verifyElementIsDisplayed(this.pageHeading);
    }

}
