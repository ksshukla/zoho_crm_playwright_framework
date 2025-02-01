package com.zoho.qa.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Leads {
    public String leadOwner;
    public String firstNamePrefix;
    public String firstName;
    public String phone;
    public String revenue;
    public Boolean emailOptOut;
    public String company;
    public String lastName;
    public String email;
    public String leadStatus;
    public String numberOfEmployees;
    public String rating;


    //Address Information
    public String street;
    public String state;
    public String country;
    public String city;
    public String zipCode;
    public String description;
}
