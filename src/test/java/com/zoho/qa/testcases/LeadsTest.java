package com.zoho.qa.testcases;

import com.zoho.qa.dataprovider.LeadsDataProvider;
import com.zoho.qa.models.Leads;
import com.zoho.qa.pages.LeadsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LeadsTest extends LeadsDataProvider {
    LeadsPage leadsPage;

    @Test(dataProvider = "createLeadData", dataProviderClass = LeadsDataProvider.class, priority = 1)
    public void testCreateLeads(Leads leads, String layout) {
        System.out.println("Testing Lead Creation for: " + leads.getFirstName() + " " + leads.getLastName());
        leadsPage = homePage.navigateToLeads();
        Assert.assertTrue(leadsPage.isLeadSectionOpened(), "Leads section is not displayed");
        leadsPage.createLeads(leads, layout);
        Assert.assertTrue(leadsPage.isLeadCreated(), "Lead Creation Failed");
        Assert.assertTrue(leadsPage.validateLeadDetails(leads), "Lead Field Validation failed");
    }

    @Test(dataProvider = "editLeadData", dataProviderClass = LeadsDataProvider.class, priority = 2)
    public void testEditLeads(Leads leads) {
        leadsPage = homePage.navigateToLeads();
        Assert.assertTrue(leadsPage.isLeadSectionOpened(), "Leads section is not displayed");
        System.out.println("Testing Lead Editing for: " + leads.getFirstName() + " " + leads.getLastName());
        leadsPage.editLead(leads);
        Assert.assertTrue(leadsPage.validateLeadDetails(leads), "Lead Field editing failed");
    }

    @Test(priority = 3)
    public void testDeleteLeads() {
        leadsPage = homePage.navigateToLeads();
        Assert.assertTrue(leadsPage.isLeadSectionOpened(), "Leads section is not displayed");
        System.out.println("Testing Lead Deletion");
        leadsPage.deleteLead();
        Assert.assertTrue(leadsPage.validateLeadDeleted(), "Lead Deletion failed");
    }

    @Test(dataProvider = "filterLeadData", dataProviderClass = LeadsDataProvider.class, priority = 4)
    public void testFilterLeads(String customField, String fieldValue) {
        leadsPage = homePage.navigateToLeads();
        Assert.assertTrue(leadsPage.isLeadSectionOpened(), "Leads section is not displayed");
        System.out.println("Testing Lead Filtering on custom field values");
        leadsPage.filterLeadsOnCustomFields(customField, fieldValue);
        Assert.assertTrue(leadsPage.validateFilterApplied());
        Assert.assertTrue(leadsPage.validateFilteredData(fieldValue));
        leadsPage.clearFilterOnCustomFields();
    }
}
