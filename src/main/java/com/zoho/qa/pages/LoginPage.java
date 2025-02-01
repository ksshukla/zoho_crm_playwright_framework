package com.zoho.qa.pages;

import com.microsoft.playwright.Locator;
import com.zoho.qa.base.PlaywrightFactory;

public class LoginPage extends PlaywrightFactory {

    private final Locator signInButton = getPage().locator("#header .zgh-login");
    private final Locator emailField = getPage().locator("input[name=\"LOGIN_ID\"]");
    private final Locator nextButton = getPage().locator("#login #nextbtn");
    private final Locator passwordField = getPage().locator("#password");
    private final Locator skipVerificatonBtn = getPage().locator("form .succfail-btns .remind_me_later");

    public HomePage login(String appUserName, String appPassword) {
        System.out.println("App creds: " + appUserName + ":" + appPassword);
        signInButton.click();
        emailField.fill(appUserName);
        nextButton.click();
        passwordField.fill(appPassword);
        nextButton.click();
        skipVerificatonBtn.click();
        return new HomePage();
    }
}
