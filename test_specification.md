# 📋 Test Specification for `LeadsTest` Class

## **1️⃣ Introduction**
This document outlines the test cases for the `LeadsTest` class in the **Zoho CRM Test Automation Suite**.  
It includes **test scenarios, steps, expected results**, and **preconditions**.

---

## **2️⃣ Test Cases**

### **✅ TC001 - Create Lead**
| **Test Case ID** | TC002 |
|------------------|------|
| **Scenario** | Verify that a user can create a lead with valid details. |
| **Preconditions** | User must be logged in. |
| **Test Steps** | 1. Navigate to `LeadsPage` using `homePage.navigateToLeads()`. <br> 2. Call `leadsPage.createLeads(leads, layout)`. <br> 3. Verify if the lead is created using `leadsPage.isLeadCreated()`. <br> 4. Validate the lead details using `leadsPage.validateLeadDetails(leads)`. |
| **Expected Result** | The lead should be created successfully and match the provided details. |

---

### **✅ TC002 - Edit Lead**
| **Test Case ID** | TC003 |
|------------------|------|
| **Scenario** | Verify that a user can edit an existing lead. |
| **Preconditions** | A lead must already exist in the system. |
| **Test Steps** | 1. Navigate to `LeadsPage` using `homePage.navigateToLeads()`. <br> 2. Call `leadsPage.editLead(leads)`. <br> 3. Verify if the lead details are updated using `leadsPage.validateLeadDetails(leads)`. |
| **Expected Result** | The lead should be updated successfully with the new details. |

---

### **✅ TC003 - Delete Lead**
| **Test Case ID** | TC004 |
|------------------|------|
| **Scenario** | Verify that a user can delete an existing lead. |
| **Preconditions** | A lead must exist in the system. |
| **Test Steps** | 1. Navigate to `LeadsPage` using `homePage.navigateToLeads()`. <br> 2. Call `leadsPage.deleteLead()`. <br> 3. Verify if the lead is deleted using `leadsPage.validateLeadDeleted()`. |
| **Expected Result** | The lead should be removed from the system successfully. |

---

### **✅ TC004 - Filter Leads**
| **Test Case ID** | TC005 |
|------------------|------|
| **Scenario** | Verify that leads can be filtered based on custom fields. |
| **Preconditions** | Leads must be available in the system with specific custom field values. |
| **Test Steps** | 1. Navigate to `LeadsPage` using `homePage.navigateToLeads()`. <br> 2. Call `leadsPage.filterLeadsOnCustomFields(customField, fieldValue)`. <br> 3. Verify if the filter is applied using `leadsPage.validateFilterApplied()`. <br> 4. Check if filtered leads match `fieldValue` using `leadsPage.validateFilteredData(fieldValue)`. <br> 5. Clear the filter using `leadsPage.clearFilterOnCustomFields()`. |
| **Expected Result** | The leads should be filtered correctly based on the selected field. |

---

## **3️⃣ Summary**
This test specification ensures the **Zoho CRM Leads module** is tested for:
- **Lead creation, editing, and deletion** ✅
- **Lead filtering based on custom fields** ✅

---