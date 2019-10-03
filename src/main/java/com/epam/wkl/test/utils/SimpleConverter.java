package com.epam.wkl.test.utils;

import com.epam.wkl.test.dto.response.BaseResponse;
import com.epam.wkl.test.dto.response.OidcDataDto;
import com.epam.wkl.test.enumerations.OidcDataFields;

import java.util.HashMap;
import java.util.Map;

/**
 * SimpleConverter .
 *
 * @author Dmytro Korytov Created Date: 9/26/2019
 */
public final class SimpleConverter {

  private SimpleConverter() {
    throw new IllegalStateException("Utility class");
  }

  public static BaseResponse<OidcDataDto> convertResponse(Map<String, Object> data) {
    BaseResponse<OidcDataDto> result = new BaseResponse<>();
    OidcDataDto innerData = new OidcDataDto();

    Map<String, String> inner = (HashMap<String, String>) data.get("data");

    innerData.setUnid(inner.get(OidcDataFields.UUID.getFieldName()));
    innerData.setFirstName(inner.get(OidcDataFields.FIRST_NAME.getFieldName()));
    innerData.setLastName(inner.get(OidcDataFields.LAST_NAME.getFieldName()));
    innerData.setEmailAddress(inner.get(OidcDataFields.EMAIL_ADDRESS.getFieldName()));
    innerData.setPhoneNumber(inner.get(OidcDataFields.PHONE_NUMBER.getFieldName()));
    innerData.setCountryCode(inner.get(OidcDataFields.COUNTRY_CODE.getFieldName()));

    String marketingConsent = inner.get(OidcDataFields.MARKETING_CONSENT.getFieldName());
    innerData.setMarketingConsent(Constants.TRUE.equalsIgnoreCase(marketingConsent));

    String consentForDetails = inner.get(OidcDataFields.CONSENT_FOR_DETAILS.getFieldName());
    innerData.setConsentForDetails(Constants.TRUE.equalsIgnoreCase(consentForDetails));

    result.setData(innerData);

    return result;
  }
}
