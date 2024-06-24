/*
package com.spring.springboot.testautomation.pages.applications.demoqa;

import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.LazyComponent;
import com.spring.springboot.testautomation.webframework.propertyconfig.ConfigLoader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static org.testng.Assert.assertTrue;

@LazyComponent
public class HomePage extends BasePage {

    @LazyAutowired
    private ConfigLoader configLoader;
    @LazyAutowired
    private LoginPage loginPage;

    // ********* Web Elements by using PageComponent Factory *********
    @FindBy(how = How.ID, using = "login")
    private WebElement loginButton;

    // ********* Web Elements by using By Class *********
    private By homePageLogoBy = By.xpath("//img[@src='/images/Toolsqa.jpg']");

    // ********* PageComponent Methods *********
    // Go to Login PageComponent
    public HomePage goToHomePage() {
        webDriver.get(configLoader.getApplicationConfig().getApplicationUrl());
        return this;
    }

    // Navigate to Login PageComponent
    public HomePage navigateToLoginPage() {
        pageActions.elementActions
                .click(loginButton);
        return this;
    }

    public HomePage verifyThatIAmAtHomePage() {
        assertTrue(pageActions.elementActions.verifyElementIsDisplayed(homePageLogoBy));
        return this;
    }

    @Override
    public boolean isAt() {
        pageActions.waitActions.waitForPageToBeLoaded();
        return pageActions.elementActions
                .verifyElementIsDisplayed(this.loginButton);
    }

}
*/
