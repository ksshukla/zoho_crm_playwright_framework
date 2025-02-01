package com.zoho.qa.base;

import com.microsoft.playwright.Page;
import com.zoho.qa.pages.HomePage;
import com.zoho.qa.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class BaseTest {

    PlaywrightFactory pf;
    Page page;
    protected Properties prop;
    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeTest
    public void setup() {
        pf = new PlaywrightFactory();
        prop = pf.init_prop();
        page = pf.initBrowser(prop);
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("userEmail").trim(),prop.getProperty("password").trim());
        Assert.assertTrue(homePage.isUserLoggedIn());
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
