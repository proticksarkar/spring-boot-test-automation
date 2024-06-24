package com.spring.springboot.testautomation.pages.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.webframework.annotations.PageComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertEquals;

@Slf4j
@PageComponent
public class SecureAreaPage extends BasePage {

    // ********* Web Elements by using PageComponent Factory *********
    @FindBy(how = How.XPATH, using = "//h2[contains(text(),'Secure Area')]")
    private WebElement pageHeading;
    @FindBy(how = How.CSS, using = "#flash.success")
    private WebElement successfulLoginMessage;

    // ********* Web Elements by using By Class *********
    private By logoutButtonBy = By.xpath("//i[contains(text(),'Logout')]");

    // ********* PageComponent Methods *********
    public SecureAreaPage verifySuccessfulLogin(String expectedSuccessfulLoginMessage) {
        String actualSuccessMessage = pageActions.elementActions
                .getText(successfulLoginMessage)
                .replace("\n×", "")
                .trim();
        assertEquals(actualSuccessMessage, expectedSuccessfulLoginMessage);
        log.info("Verified successful login message: {}", actualSuccessMessage);
        return this;
    }

    public LoginPage performLogout() {
        pageActions.elementActions
                .click(logoutButtonBy);
        log.info("Logged out of website");
        return getBean(LoginPage.class);
    }

    @Override
    public boolean isAt() {
        pageActions.waitActions.waitForPageToBeLoaded();
        return pageActions.elementActions
                .verifyElementIsDisplayed(this.pageHeading);
    }

}
