package com.spring.springboot.testautomation.steps.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.HomePage;
import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.LoginPage;
import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.SecureAreaPage;
import com.spring.springboot.testautomation.webframework.annotations.PageAutowired;
import com.spring.springboot.testautomation.webframework.annotations.TakeScreenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

    @PageAutowired
    private HomePage homePage;
    @PageAutowired
    private LoginPage loginPage;
    @PageAutowired
    private SecureAreaPage secureAreaPage;

    @Given("I am on Login page")
    public void iAmOnLoginPage() {
        homePage
                .goToHomePage()
                .navigateToFormAuthenticationLoginPage();
    }

    @When("I try to login with userName {string} and password {string}")
    public void iTryToLoginWithUserNameAndPassword(String userName, String password) {
        loginPage
                .performLogin(userName, password);
    }

    @TakeScreenshot
    @Then("I verify successful login message {string}")
    public void iVerifySuccessfulLoginMessage(String expectedMessage) {
        secureAreaPage
                .verifySuccessfulLogin(expectedMessage.trim());
    }

    @TakeScreenshot
    @Then("I verify invalid password message {string}")
    public void iVerifyInvalidPasswordMessage(String expectedMessage) {
        loginPage
                .verifyFailedLoginUsingInvalidPassword(expectedMessage.trim());
    }

    @TakeScreenshot
    @Then("I verify invalid userName message {string}")
    public void iVerifyInvalidUserNameMessage(String expectedMessage) {
        loginPage
                .verifyFailedLoginUsingInvalidUsername(expectedMessage.trim());
    }

}
