/*
package com.spring.springboot.testautomation.steps.applications.demoqa;

import com.spring.springboot.testautomation.pages.applications.demoqa.HomePage;
import com.spring.springboot.testautomation.pages.applications.demoqa.LoginPage;
import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.TakeScreenshot;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

    @LazyAutowired
    private HomePage homePage;
    @LazyAutowired
    private LoginPage loginPage;

    @Given("I am on the Login page")
    public LoginPageSteps givenIAmAtLoginPage() {
        homePage
                .goToHomePage()
                .navigateToLoginPage();
        return this;
    }

    @When("I try to login with userName {string} and password {string}")
    public LoginPageSteps whenITryToLoginWithUsernameAndPassword(String userName, String password) {
        loginPage
                .login(userName, password);
        return this;
    }

    @TakeScreenshot
    @Then("I verify login is successful {string}")
    public LoginPageSteps thenIVerifySuccessfulLogin(String expectedLoggedInUserName) {
        loginPage
                .verifySuccessfulLogin(expectedLoggedInUserName);
        return this;
    }

    @TakeScreenshot
    @Then("I verify invalid user credentials message {string}")
    public LoginPageSteps thenIVerifyTheInvalidUserCredentialsMessage(String expectedMessage) {
        loginPage
                .verifyInvalidUserCredentialsErrorMessage(expectedMessage);
        return this;
    }

}
*/
