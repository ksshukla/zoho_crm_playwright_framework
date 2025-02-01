package com.zoho.qa.pages;

import com.microsoft.playwright.Locator;
import com.zoho.qa.base.PlaywrightFactory;


public class HomePage extends PlaywrightFactory {

    private final Locator zohoLogo = getPage().locator(".crm-logo-img");
    private final Locator profileLogo = getPage().locator("div[data-zcqa='profilePicture']");
    private final Locator leadSectionButton = getPage().locator("#moduleId_Leads");

    public boolean isUserLoggedIn() {
        zohoLogo.waitFor(new Locator.WaitForOptions().setTimeout(60000));
        profileLogo.waitFor();
        return (zohoLogo.isVisible() && profileLogo.isVisible());
    }

    public LeadsPage navigateToLeads(){
        leadSectionButton.click();
        return new LeadsPage();
    }
}
