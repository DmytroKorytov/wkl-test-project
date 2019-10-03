package com.epam.wkl.test.dto.response;

/**
OidcDataDto .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
public class OidcDataDto {

    private String unid;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private String phoneNumber;
    private String countryCode;
    private Boolean consentForDetails;
    private Boolean marketingConsent;

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Boolean getConsentForDetails() {
        return consentForDetails;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public String getLastName() {
        return lastName;
    }

    public Boolean getMarketingConsent() {
        return marketingConsent;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setUnid(String unid) {
        this.unid = unid;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setMarketingConsent(Boolean marketingConsent) {
        this.marketingConsent = marketingConsent;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getUnid() {
        return unid;
    }

    public void setConsentForDetails(Boolean consentForDetails) {
        this.consentForDetails = consentForDetails;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }
}
