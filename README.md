# Zoho CRM Test Automation

## Project Overview
This project automates the **Zoho CRM** functionality for the **Leads module** using **TestNG** and **Playwright**. The tests focus on verifying core lead management functionalities such as creating, editing, deleting, and filtering leads.

## Project Structure



---

## **Test Cases Overview**

### **Test Scenarios**
The test cases are designed to validate the following scenarios in the **Leads module** of Zoho CRM:

1. **Create Lead**: Validate the creation of new leads.
2. **Edit Lead**: Validate the functionality to edit an existing lead.
3. **Delete Lead**: Test the deletion of an existing lead.
4. **Filter Leads**: Verify that filtering on custom fields works correctly.

### **Test Specification**
For detailed test scenarios, steps, expected results, and preconditions, please refer to the [test specification document](./test_specification.md).

---

## **Setup and Execution**

### **Prerequisites**
Before running the tests, ensure the following:

1. **Maven** is installed (if not, download from [Maven](https://maven.apache.org/download.cgi)).
2. **Zoho CRM credentials** are set up in the `config.properties` file:
    - `userEmail`: Zoho CRM username.
    - `password`: Zoho CRM password.

### **Run the Test**
To run the entire test suite, use the following command:

**Run the testng.xml file at test>resources>testrunners**

### **Find Reports**
Reports can be accessed under reports folder.