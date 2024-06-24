package com.spring.springboot.testautomation.steps.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.HomePage;
import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.LoginPage;
import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.SecureAreaPage;
import com.spring.springboot.testautomation.webframework.annotations.PageAutowired;
import com.spring.springboot.testautomation.webframework.annotations.TakeScreenshot;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

public class LogoutSteps {

    @PageAutowired
    private HomePage homePage;
    @PageAutowired
    private LoginPage loginPage;
    @PageAutowired
    private SecureAreaPage secureAreaPage;

    public LogoutSteps(HomePage homePage) {
        this.homePage = homePage;
    }

    @Given("I login to the website using username and password and verify successful login")
    public void iLoginToTheWebsiteUsingUsernameAndPasswordAndVerifySuccessfulLogin(DataTable dataTable) {
        List<Map<String, String>> loginData = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> data : loginData) {
            String userName = data.get("userName");
            String password = data.get("password");
            String expectedMessage = data.get("successfulLoginMessage");
            homePage
                    .goToHomePage()
                    .navigateToFormAuthenticationLoginPage()
                    .performLogin(userName, password)
                    .verifySuccessfulLogin(expectedMessage);
        }
    }

    @Given("I am on Secure Area page")
    public void iAmOnSecureAreaPage() {
        secureAreaPage.isAt();
    }

    @When("I try to logout of the website")
    public void iTryToLogoutOfTheWebsite() {
        secureAreaPage
                .performLogout();
    }

    @TakeScreenshot
    @Then("I verify successful logout message {string}")
    public void iVerifySuccessfulLogoutMessage(String expectedMessage) {
        loginPage
                .verifySuccessfulLogout(expectedMessage.trim());
    }

}
