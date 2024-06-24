/*
package com.spring.springboot.testautomation.pages.applications.demoqa;

import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertEquals;

@LazyComponent
public class LoginPage extends BasePage {

    //********* Web Elements by using PageComponent Factory *********
    @FindBy(how = How.ID, using = "userName")
    private WebElement userName;

    @FindBy(how = How.ID, using = "password")
    private WebElement password;

    // ********* Web Elements by using By Class *********
    private By loginButtonBy = By.id("login");
    private By loggedInUserName = By.xpath("//label[@id='userName-value']");
    private By invalidUserCredentialsErrorMessageBy = By.xpath("//*[text() = 'Invalid username or password!']");

    // ********* PageComponent Actions *********
    public LoginPage login(String userName, String password) {
        pageActions.elementActions
                .enterText(this.userName, userName)
                .enterText(this.password, password)
                .click(loginButtonBy);
        return this;
    }

    public LoginPage verifySuccessfulLogin(String expectedLoggedInUserName) {
//        pageActions.waitActions
//                .waitForElementToBeVisible(loggedInUserName);
        assertEquals(expectedLoggedInUserName, pageActions.elementActions.getText(loggedInUserName));
        return this;
    }

    public LoginPage verifyInvalidUserCredentialsErrorMessage(String expectedMessage) {
//        pageActions.waitActions
//                .waitForElementToBeVisible(invalidUserCredentialsErrorMessageBy);
        assertEquals(expectedMessage,  pageActions.elementActions.getText(invalidUserCredentialsErrorMessageBy));
        return this;
    }

    @Override
    public boolean isAt() {
        pageActions.waitActions.waitForPageToBeLoaded();
        return pageActions.elementActions
                .verifyElementIsDisplayed(this.userName);
    }

}
*/
