package com.spring.springboot.testautomation.pages.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.webframework.annotations.PageComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertEquals;

@Slf4j
@PageComponent
public class OpenNewWindowPage extends BasePage {

    // ********* Web Elements by using PageComponent Factory *********
    @FindBy(how = How.XPATH, using = "//h3[text()='Opening a new window']")
    private WebElement pageHeading;
    @FindBy(how = How.LINK_TEXT, using = "Click Here")
    private WebElement clickHereLink;

    // ********* PageComponent Methods *********
    public NewWindowPage openNewWindow() {
        pageActions.elementActions
                .click(clickHereLink);
        log.info("Opened new window");
        return getBean(NewWindowPage.class);
    }

    public OpenNewWindowPage verifySuccessfulSwitchingBack(String expectedPageHeading) {
        String actualPageHeading = pageActions.elementActions.getText(pageHeading);
        assertEquals(actualPageHeading, expectedPageHeading);
        log.info("Verified parent window page heading: {}", actualPageHeading);
        return this;
    }

    @Override
    public boolean isAt() {
        pageActions.waitActions.waitForPageToBeLoaded();
        return pageActions.elementActions
                .verifyElementIsDisplayed(this.pageHeading);
    }

}
