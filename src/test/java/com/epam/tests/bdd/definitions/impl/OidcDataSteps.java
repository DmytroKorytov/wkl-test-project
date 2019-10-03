package com.epam.tests.bdd.definitions.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import com.epam.tests.bdd.definitions.BaseCucumberStep;
import com.epam.wkl.test.enumerations.OidcDataFields;
import com.epam.wkl.test.utils.MatchHelper;
import com.epam.wkl.test.utils.SimpleConverter;
import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.springframework.http.HttpStatus;

import java.text.MessageFormat;
import java.util.List;

/**
 * OidcDataSteps .
 *
 * @author Dmytro Korytov Created Date: 9/26/2019
 */
public class OidcDataSteps extends BaseCucumberStep {


    @Given("^user call login api")
    public void andDef(DataTable apiLogin) {
      List<String> apiPath = apiLogin.asList(String.class);

      setApiRoute(apiPath.get(0));
    }


    @When("user received response from api he see that is 200 status and response isn't null")
    public void whenDef() {

      executeGetRequest(getApiRoute());

      Response response = getHandler().getResponse();

      assertNotNull(MessageFormat.format("Response from API {0} is null!", getApiRoute()), response);
      assertEquals("Wrong status code!", HttpStatus.OK.value(), response.getStatusCode());

      getHandler()
          .setResponseData(
              SimpleConverter.convertResponse(response.jsonPath().get())
          );
    }


    @Then("user see that he have correct id by pattern.")
    public void thenId() {
      Boolean isMatched = new MatchHelper()
          .setPattern(OidcDataFields.UUID.getRegex())
          .matchExpression(getHandler().getResponseData().getData().getUnid())
          .getMatch();

      assertTrue(
          MessageFormat.format(
              "Id {0} doesn't match the pattern!",
              getHandler().getResponseData().getData().getUnid()
          ),
          isMatched
      );
    }

    @Then("user see that he have correct name by pattern.")
    public void thenName() {
      Boolean isMatched = new MatchHelper()
          .setPattern(OidcDataFields.FIRST_NAME.getRegex())
          .matchExpression(getHandler().getResponseData().getData().getFirstName())
          .getMatch();

      assertTrue(
          MessageFormat.format(
              "Name {0} doesn't match the pattern! It contain numbers",
              getHandler().getResponseData().getData().getFirstName()
          ),
          isMatched
      );
    }


    @Then("user see that he have correct email by pattern.")
    public void thenEmail() {
      Boolean isMatched = new MatchHelper()
          .setPattern(OidcDataFields.EMAIL_ADDRESS.getRegex())
          .matchExpression(getHandler().getResponseData().getData().getEmailAddress())
          .getMatch();

      assertTrue(
          MessageFormat.format(
              "Email {0} doesn't match the expected pattern example@wolterskluwer.com !",
              getHandler().getResponseData().getData().getEmailAddress()
          ),
          isMatched
      );
    }


    @Then("user see that he have correct phone number by pattern.")
    public void thenPhone() {
      Boolean isMatched = new MatchHelper()
          .setPattern(OidcDataFields.PHONE_NUMBER.getRegex())
          .matchExpression(getHandler().getResponseData().getData().getPhoneNumber())
          .getMatch();

      assertTrue(
          MessageFormat.format(
              "Phone {0} doesn't match the pattern!",
              getHandler().getResponseData().getData().getPhoneNumber()
          ),
          isMatched
      );
    }

}
