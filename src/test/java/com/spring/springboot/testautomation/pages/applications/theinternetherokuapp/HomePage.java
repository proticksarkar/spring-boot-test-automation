package com.spring.springboot.testautomation.pages.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.webframework.annotations.PageComponent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@PageComponent
public class HomePage extends BasePage {

    @Value("${application.url}")
    private String applicationUrl;

    // ********* Web Elements by using PageComponent Factory *********
    @FindBy(how = How.XPATH, using = "//h1[text()='Welcome to the-internet']")
    private WebElement pageHeading;
    @FindBy(how = How.LINK_TEXT, using = "Form Authentication")
    private WebElement formAuthenticationLink;

    // ********* Web Elements by using By Class *********
    private By multipleWindowsLinkBy = By.linkText("Multiple Windows");

    // ********* PageComponent Methods *********
    // Go to Home PageComponent
    public HomePage goToHomePage() {
//        webDriver.get(configLoader.getApplicationConfig().getApplicationUrl());
        webDriver.get(applicationUrl);
        log.info("Opened website: {}", pageActions.elementActions.getPageTitle());
        return this;
    }

    // Navigate to Login PageComponent
    public LoginPage navigateToFormAuthenticationLoginPage() {
        pageActions.elementActions
                .click(formAuthenticationLink);
        log.info("Navigated to Form Authentication Login page");
        return getBean(LoginPage.class);
    }

    // Navigate to Open New Window PageComponent
    public OpenNewWindowPage navigateToOpenNewWindowPage() {
        pageActions.elementActions
                .click(multipleWindowsLinkBy);
        log.info("Navigated to Open New Window page");
        return getBean(OpenNewWindowPage.class);
    }

    @Override
    public boolean isAt() {
        pageActions.waitActions.waitForPageToBeLoaded();
        return pageActions.elementActions
                .verifyElementIsDisplayed(this.pageHeading);
    }

}
