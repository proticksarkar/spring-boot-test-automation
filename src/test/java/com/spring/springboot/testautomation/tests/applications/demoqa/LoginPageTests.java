/*
package com.spring.springboot.testautomation.tests.applications.demoqa;

import com.spring.springboot.testautomation.steps.applications.demoqa.LoginPageSteps;
import org.springframework.models.factory.annotation.Autowired;
import org.springframework.models.factory.annotation.Value;
import org.testng.annotations.Test;

public class LoginPageTests extends BaseTest {

    @Value("valid.userName")
    private String validUserName;
    @Value("valid.password")
    private String validPassword;
    @Value("invalid.userName")
    private String invalidUserName;
    @Value("invalid.password")
    private String invalidPassword;
    @Value("loginPage.invalidUserCredentialsErrorMessage")
    private String invalidUserCredentialsErrorMessage;

    @Autowired
    private LoginPageSteps loginPageSteps;

    @Test
    public void testLoginIsSuccessfulUsingValidUserCredentials() {
        loginPageSteps
                .givenIAmAtLoginPage()
                .whenITryToLoginWithUsernameAndPassword(validUserName, validPassword)
                .thenIVerifySuccessfulLogin(validUserName);
    }

    @Test
    public void testLoginIsNotSuccessfulUsingInvalidUserCredentials() {
        loginPageSteps
                .givenIAmAtLoginPage()
                .whenITryToLoginWithUsernameAndPassword(invalidUserName, invalidPassword)
                .thenIVerifyTheInvalidUserCredentialsMessage(invalidUserCredentialsErrorMessage);
    }

}
*/
