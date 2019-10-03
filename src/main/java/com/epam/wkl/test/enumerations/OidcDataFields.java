package com.epam.wkl.test.enumerations;

import org.apache.logging.log4j.util.Strings;

/**
OidcDataFields .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
public enum OidcDataFields {

    UUID("unid", "^\\d{7}$"),
    FIRST_NAME("firstName", "^[a-zA-Z]*$"),
    LAST_NAME("lastName", "^[a-zA-Z]*$"),
    EMAIL_ADDRESS("emailAddress", "^[a-zA-Z0-9_.+-]+@(?:(?:[a-zA-Z0-9-]+\\.)?[a-zA-Z]+\\.)?(wolterskluwer)\\.com$"),
    PHONE_NUMBER("phoneNumber", "^(1?)(-| ?)(\\()?([0-9]{3})(\\)|-| |\\)-|\\) )?([0-9]{3})(-| )?([0-9]{4}|[0-9]{3,4})$"),
    COUNTRY_CODE("countryCode", Strings.EMPTY),
    CONSENT_FOR_DETAILS("consentForDetails", Strings.EMPTY),
    MARKETING_CONSENT("marketingConsent", Strings.EMPTY);

    private String fieldName;
    private String regex;

    OidcDataFields(String fieldName, String regex) {
        this.fieldName = fieldName;
        this.regex = regex;
    }

    public String getFieldName() {
        return fieldName;
    }

    public String getRegex() {
        return regex;
    }
}