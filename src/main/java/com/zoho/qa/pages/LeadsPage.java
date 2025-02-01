package com.zoho.qa.pages;

import com.microsoft.playwright.Locator;
import com.zoho.qa.base.PlaywrightFactory;
import com.zoho.qa.models.Leads;

import java.util.List;
import java.util.Objects;

public class LeadsPage extends PlaywrightFactory {

    private final Locator createLeadButton = getPage().locator(".customPlusBtn");
    private final Locator editLeadLayoutButton = getPage().locator("#layoutDetails");
    private final Locator dropDownValuesEditLeadLayout = getPage().locator("//lyte-drop-label[text()='Layouts']/following-sibling::lyte-drop-item");

    //Locators for Lead Creation flow
    private final Locator firstNamePrefix = getPage().locator("#Crm_Leads_FIRSTNAME_SALUTATION lyte-drop-button");
    private final Locator firstName = getPage().locator("#Crm_Leads_FIRSTNAME_LInput");
    private final Locator phone = getPage().locator("#Crm_Leads_PHONE_LInput");
    private final Locator revenue = getPage().locator("#Crm_Leads_ANNUALREVENUE_LInput");
    private final Locator emailOptOut = getPage().locator("#lyte-checkbox-label-64");
    private final Locator company = getPage().locator("#Crm_Leads_COMPANY_label+div input");
    private final Locator lastName = getPage().locator("#Crm_Leads_LASTNAME_LInput");
    private final Locator email = getPage().locator("#Crm_Leads_EMAIL_LInput");
    private final Locator leadStatusDropDown = getPage().locator("#Crm_Leads_STATUS_label+div lyte-drop-button");
    private final String genericDropDownValues = "lyte-drop-item[data-value='${dropDownValue}']";
    private final Locator numberOfEmployees = getPage().locator("#Crm_Leads_EMPCT_LInput");
    private final Locator rating = getPage().locator("#Crm_Leads_RATING_label+div lyte-drop-button");

    //Locators for Address Information
    private final Locator street = getPage().locator("#Crm_Leads_LANE_LInput");
    private final Locator state = getPage().locator("#Crm_Leads_STATE_LInput");
    private final Locator country = getPage().locator("#Crm_Leads_COUNTRY input");
    private final Locator city = getPage().locator("#Crm_Leads_CITY_LInput");
    private final Locator zipCode = getPage().locator("#Crm_Leads_CODE_LInput");
    private final Locator description = getPage().locator("#Crm_Leads_DESCRIPTION_label+div textarea");
    private final Locator saveButton = getPage().locator("#crm_create_savebutn");

    //Locators to validate lead was created.
    private final Locator sendEmailButton = getPage().locator("button[aria-label='Send Email']");
    private final Locator overviewTextLabel = getPage().locator("#newleft_Info");
    private final Locator timeLine = getPage().locator("#newleft_History");

    //Locators to validate lead details were populated as per input
    private final Locator phoneValue = getPage().locator("#value_PHONE");
    private final Locator annualRevenueValue = getPage().locator("#value_ANNUALREVENUE");
    private final Locator companyValue = getPage().locator("#value_COMPANY");
    private final Locator emailValue = getPage().locator("#value_EMAIL");
    private final Locator dropDownValue = getPage().locator("#value_STATUS");
    private final Locator numberOfEmployeesValue = getPage().locator("#value_EMPCT");
    private final Locator ratingValue = getPage().locator("span[data-zcqa=\"value_Rating\"]");
    private final Locator streetValue = getPage().locator("#value_LANE");
    private final Locator stateValue = getPage().locator("#value_STATE");
    private final Locator countryValue = getPage().locator("#value_COUNTRY");
    private final Locator cityValue = getPage().locator("#value_CITY");
    private final Locator zipCodeValue = getPage().locator("#value_CODE");
    private final Locator descriptionValue = getPage().locator("#value_DESCRIPTION");

    //Locators to edit/delete lead details
    private final Locator optionsLocator = getPage().locator(".lvEditIconCol").nth(1);
    private final Locator editOption = getPage().locator("lyte-menu-item[data-value=\"Edit\"]");
    private final Locator deleteOption = getPage().locator("lyte-menu-item[data-value='mass_delete']");
    private final Locator deleteButton = getPage().locator("//lyte-yield[text()='Delete']");
    private final Locator deleteSuccessMessage = getPage().locator("//span[text()='Record(s) Deleted Successfully']");

    //Locators to filter leads
    private final Locator customFieldFilterValue = getPage().locator(".cxBorderBottom");
    private final Locator applyFilterButton = getPage().locator("button[type='submit']");
    private final Locator saveFilterButton = getPage().locator("#saveFilterBtn");
    private final Locator clearFilterButton = getPage().locator("//span[text()='Clear Filter']");
    private final String filterByFieldOptionsLabel = "//span[text()='${fieldLabel}']";
    private final String leadsTableFieldValues = "lyte-text[lt-prop-value='${fieldValue}']";
    private final String customFieldCheckBoxValue = "#field_${customField}";


    public boolean isLeadSectionOpened() {
        createLeadButton.waitFor();
        return createLeadButton.isVisible();
    }

    public void createLeads(Leads leads, String layout) {
        createLeadButton.click();
        fillCompanyDetails(leads);
        fillPersonalDetails(leads);
        fillContactDetails(leads);
        fillBusinessDetails(leads);
        fillAddressDetails(leads);
        saveButton.click();
    }

    // Section: Company Information
    private void fillCompanyDetails(Leads leads) {
        fillLeadsField(leads.getCompany(), company);
    }

    // Section: Personal Details
    private void fillPersonalDetails(Leads leads) {
        fillLeadsDropdown(leads.getFirstNamePrefix(), firstNamePrefix, genericDropDownValues);
        fillLeadsField(leads.getFirstName(), firstName);
        fillLeadsField(leads.getLastName(), lastName);
    }

    // Section: Contact Information
    private void fillContactDetails(Leads leads) {
        fillLeadsField(leads.getPhone(), phone);
        fillLeadsField(leads.getEmail(), email);

        if (leads.getEmailOptOut()) {
            emailOptOut.click();
        }
    }

    // Section: Business Information
    private void fillBusinessDetails(Leads leads) {
        fillLeadsField(leads.getRevenue(), revenue);
        fillLeadsDropdown(leads.getLeadStatus(), leadStatusDropDown, genericDropDownValues);
        fillLeadsField(leads.getNumberOfEmployees(), numberOfEmployees);
        fillLeadsDropdown(leads.getRating(), rating, genericDropDownValues);
    }

    // Section: Address Details
    private void fillAddressDetails(Leads leads) {
        fillLeadsField(leads.getStreet(), street);
        fillLeadsField(leads.getState(), state);
        fillLeadsField(leads.getCountry(), country);
        fillLeadsField(leads.getCity(), city);
        fillLeadsField(leads.getZipCode(), zipCode);
        scrollToElement(description);
        fillLeadsField(leads.getDescription(), description);
    }

    // Generic Field Filling Utility
    private void fillLeadsField(String value, Locator locator) {
        if (value != null && !value.isEmpty()) {
            locator.waitFor();
            locator.fill(value);
        }
    }

    // Generic Dropdown Handling
    private void fillLeadsDropdown(String value, Locator dropdown, String dropDownValues) {
        if (value != null && !value.isEmpty()) {
            dropdown.click();
            getPage().locator(dropDownValues.replace("${dropDownValue}", value)).click();
        }
    }

    public boolean isLeadCreated() {
        sendEmailButton.waitFor();
        overviewTextLabel.waitFor();
        timeLine.waitFor();
        return (sendEmailButton.isVisible() && overviewTextLabel.isVisible() && timeLine.isVisible());
    }

    public boolean validateLeadDetails(Leads leads) {
        boolean isValid = true;
        isValid &= validateField(companyValue, leads.getCompany(), "Company");
        isValid &= validateField(phoneValue, leads.getPhone(), "Phone");
        isValid &= validateField(dropDownValue, leads.getLeadStatus(), "Lead Status");
        isValid &= validateField(emailValue, leads.getEmail(), "Email");
        isValid &= validateField(annualRevenueValue, leads.getRevenue(), "Annual Revenue");
        isValid &= validateField(numberOfEmployeesValue, leads.getNumberOfEmployees(), "Number of Employees");
        isValid &= validateField(ratingValue, leads.getRating(), "Rating");
        isValid &= validateField(streetValue, leads.getStreet(), "Street");
        isValid &= validateField(stateValue, leads.getState(), "State");
        isValid &= validateField(countryValue, leads.getCountry(), "Country");
        isValid &= validateField(cityValue, leads.getCity(), "City");
        isValid &= validateField(zipCodeValue, leads.getZipCode(), "Zip Code");
        isValid &= validateField(descriptionValue, leads.getDescription(), "Description");
        return isValid;
    }

    // Helper method to validate and compare field text with logging
    private boolean validateField(Locator field, String expectedValue, String fieldName) {
        String actualValue = field.textContent().trim();
        if (Objects.equals(fieldName, "Annual Revenue") || Objects.equals(fieldName, "Phone")) {
            actualValue = actualValue.replaceAll("[^0-9.]", "").split("\\.")[0];
        }

        if (expectedValue != null && !expectedValue.isEmpty()) {
            if (!actualValue.equals(expectedValue)) {
                System.out.println("Validation failed for " + fieldName +
                        ": Expected = '" + expectedValue + "', Actual = '" + actualValue + "'");
                return false;
            }
        } else {
            if (!actualValue.isEmpty()) {
                System.out.println("Validation failed for " + fieldName +
                        ": Expected a blank field ('-'), but found = '" + actualValue + "'");
                return false;
            }
        }

        System.out.println("Validation passed for " + fieldName + ": '" + actualValue + "'");
        return true;
    }

    public void selectLeadsOptions(Locator options) {
        optionsLocator.hover();
        optionsLocator.click();
        options.click();
    }

    public void editLead(Leads leads) {
        selectLeadsOptions(editOption);
        fillAddressDetails(leads);
        saveButton.click();
    }

    public void deleteLead() {
        selectLeadsOptions(deleteOption);
        deleteButton.click();
    }

    public boolean validateLeadDeleted() {
        deleteSuccessMessage.waitFor();
        return deleteSuccessMessage.isVisible();
    }

    public void scrollToElement(Locator element) {
        element.scrollIntoViewIfNeeded();
    }

    public boolean validateFilterApplied() {
        saveFilterButton.waitFor();
        clearFilterButton.waitFor();
        return (saveFilterButton.isVisible() && clearFilterButton.isVisible());
    }

    public void filterLeadsOnCustomFields(String customField, String fieldValue) {
        Locator filterByCustomFieldText = getPage().locator(filterByFieldOptionsLabel.replace("${fieldLabel}", customField));
        Locator customFieldCheckBox = getPage().locator(customFieldCheckBoxValue.replace("${customField}", customField));
        scrollToElement(filterByCustomFieldText);
        customFieldCheckBox.click();
        customFieldFilterValue.fill(fieldValue);
        applyFilterButton.click();
    }

    public void clearFilterOnCustomFields() {
        clearFilterButton.click();
    }

    public boolean validateFilteredData(String fieldValue) {
        Locator filteredLeadsCustomFieldValues = getPage().locator(leadsTableFieldValues.replace("${fieldValue}", fieldValue));
        List<Locator> filteredLeadsCustomFieldRecords = filteredLeadsCustomFieldValues.all();
        if (filteredLeadsCustomFieldRecords.isEmpty()) {
            System.out.println("No leads found for filter value " + fieldValue);
            return true;
        } else {
            for (Locator filteredLeadLocator : filteredLeadsCustomFieldRecords) {
                if (filteredLeadLocator.textContent().equals(fieldValue)) {
                    return true;
                } else {
                    break;
                }
            }
            return false;
        }
    }
}