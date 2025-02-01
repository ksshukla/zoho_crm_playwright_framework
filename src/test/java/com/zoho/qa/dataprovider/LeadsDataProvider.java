package com.zoho.qa.dataprovider;

import com.zoho.qa.base.BaseTest;
import com.zoho.qa.models.Leads;
import org.testng.annotations.DataProvider;

public class LeadsDataProvider extends BaseTest {
    @DataProvider(name = "createLeadData")
    public static Object[][] getCreateLeadsData() {
        return new Object[][]{
                {Leads.builder()
                        .leadOwner("Jane Doe")
                        .lastName("Maclead")
                        .company("Apple")
                        .emailOptOut(false)
                        .build(), "basic"
                },
                {Leads.builder()
                        .leadOwner("John Doe")
                        .firstNamePrefix("Mr.")
                        .firstName("Michael")
                        .lastName("Puta")
                        .phone("1234567890")
                        .email("john.doe@example.com")
                        .company("Zoho Corp")
                        .revenue("50000")
                        .emailOptOut(false)
                        .leadStatus("Junk Lead")
                        .numberOfEmployees("100")
                        .rating("Active")
                        .street("123 Street")
                        .state("California")
                        .country("USA")
                        .city("Los Angeles")
                        .zipCode("90001")
                        .description("Test Lead John")
                        .build(), "basic"}

        };
    }

    @DataProvider(name = "editLeadData")
    public static Object[][] getEditLeadsData() {
        return new Object[][]{
                {Leads.builder()
                        .leadOwner("John Doe")
                        .firstNamePrefix("Mr.")
                        .firstName("John")
                        .lastName("Doe")
                        .phone("1234567890")
                        .email("john.doe@example.com")
                        .company("Zoho Corp")
                        .revenue("50000")
                        .emailOptOut(false)
                        .leadStatus("Junk Lead")
                        .numberOfEmployees("100")
                        .rating("Active")
                        .street("789 Street")
                        .state("Karnatka")
                        .country("India")
                        .city("Bengaluru")
                        .zipCode("560103")
                        .description("Test Lead John")
                        .build()},

        };
    }

    @DataProvider(name = "filterLeadData")
    public static Object[][] getFilterLeadsData() {
        return new Object[][]{
                {"Company", "Zoho Corp"},
                {"Company", "Microsoft"},
                {"Country", "USA"},
                {"Country", "India"}
        };
    }
}
