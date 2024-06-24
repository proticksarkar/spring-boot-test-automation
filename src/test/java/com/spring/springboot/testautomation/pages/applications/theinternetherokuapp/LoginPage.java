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
public class LoginPage extends BasePage {

    // ********* Web Elements by using PageComponent Factory *********
    @FindBy(how = How.XPATH, using = "//h2[text()='Login PageComponent']")
    private WebElement pageHeading;
    @FindBy(how = How.ID, using = "username")
    private WebElement userNameTextBox;
    @FindBy(how = How.ID, using = "password")
    private WebElement passwordTextBox;
    @FindBy(how = How.CSS, using = "#flash.error")
    private WebElement invalidUserCredentialsErrorMessage;
    @FindBy(how = How.CSS, using = "#flash.success")
    private WebElement successfulLogoutMessage;

    // ********* Web Elements by using By Class *********
    private By loginButtonBy = By.xpath("//button[@type='submit']");

    // ********* PageComponent Methods *********
    public SecureAreaPage performLogin(String username, String password) {
        pageActions.elementActions
                .enterText(this.userNameTextBox, username)
                .enterText(this.passwordTextBox, password)
                .click(loginButtonBy);
        log.info("Logged in to website");
        return getBean(SecureAreaPage.class);
    }

    public LoginPage verifyFailedLoginUsingInvalidUsername(String expectedErrorMessage) {
        String actualErrorMessage = pageActions.elementActions
                .getText(invalidUserCredentialsErrorMessage)
                .replace("\n×", "")
                .trim();
        assertEquals(actualErrorMessage, expectedErrorMessage);
        log.info("Verified failed login error message: {}", actualErrorMessage);
        return this;
    }

    public LoginPage verifyFailedLoginUsingInvalidPassword(String expectedErrorMessage) {
        String actualErrorMessage = pageActions.elementActions
                .getText(invalidUserCredentialsErrorMessage)
                .replace("\n×", "")
                .trim();
        assertEquals(actualErrorMessage, expectedErrorMessage);
        log.info("Verified failed login error message: {}", actualErrorMessage);
        return this;
    }

    public LoginPage verifySuccessfulLogout(String expectedSuccessfulLogoutMessage) {
        String actualSuccessMessage = pageActions.elementActions
                .getText(successfulLogoutMessage)
                .replace("\n×", "")
                .trim();
        assertEquals(actualSuccessMessage, expectedSuccessfulLogoutMessage);
        log.info("Verified successful logout message: {}", actualSuccessMessage);
        return this;
    }

    @Override
    public boolean isAt() {
        pageActions.waitActions.waitForPageToBeLoaded();
        return pageActions.elementActions
                .verifyElementIsDisplayed(this.pageHeading);
    }

}
