package com.spring.springboot.testautomation.steps.applications.theinternetherokuapp;

import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.HomePage;
import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.NewWindowPage;
import com.spring.springboot.testautomation.pages.applications.theinternetherokuapp.OpenNewWindowPage;
import com.spring.springboot.testautomation.webframework.annotations.LazyAutowired;
import com.spring.springboot.testautomation.webframework.annotations.PageAutowired;
import com.spring.springboot.testautomation.webframework.annotations.TakeScreenshot;
import com.spring.springboot.testautomation.webframework.utils.WindowUtil;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NewWindowSteps {

    @PageAutowired
    private HomePage homePage;
    @PageAutowired
    private OpenNewWindowPage openNewWindowPage;
    @PageAutowired
    private NewWindowPage newWindowPage;
    @LazyAutowired
    private WindowUtil windowUtil;

    @Given("I am on Open New Window page")
    public void iAmOnOpenNewWindowPage() {
        homePage
                .goToHomePage()
                .navigateToOpenNewWindowPage();
    }

    @When("I open a new window and switch to it")
    public void iOpenANewWindowAndSwitchToIt() {
        openNewWindowPage
                .openNewWindow();
        windowUtil.switchByIndex(1);
    }

    @TakeScreenshot
    @Then("I verify the page title {string}")
    public void iVerifyThePageTitle(String expectedPageTitle) {
        newWindowPage
                .verifyNewWindowPageTitle(expectedPageTitle);
    }

    @When("I switch back to parent window")
    public void iSwitchBackToParentWindow() {
        windowUtil.switchByIndex(0);
    }

}
