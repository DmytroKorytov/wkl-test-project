package com.epam.tests.bdd.definitions;


import com.epam.tests.bdd.handler.BddContextHandler;
import com.epam.wkl.test.utils.Constants;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * BaseCucumberStep .
 *
 * @author Dmytro Korytov Created Date: 9/26/2019
 */
public class BaseCucumberStep {
      protected static final Logger LOG = LoggerFactory.getLogger(BaseCucumberStep.class);
      private BddContextHandler BDD_CONTEXT_HANDLER = BddContextHandler.BDD_CONTEXT;

      private String apiRoute;


      protected void executeGetRequest(String apiPath) {
        executeGetRequest(apiPath, null);
      }

      protected void executeGetRequest(String apiPath,
                                       Map<String, String> path) {

            RequestSpecification request = BDD_CONTEXT_HANDLER.getRequest();
            String url = getBaseUrlToApi().concat(apiPath);

            LOG.info("Prepare to request.");

            setPathParams(path, request);

            LOG.info("Execute request");

            Response response = request
                .accept(ContentType.JSON)
                .log()
                .all()
                .get(url);

            LOG.info("Set response to handler");
            getHandler().setResponse(response);
      }


      private void setPathParams(Map<String, String> path, RequestSpecification request) {
        if (null != path) {
          request.pathParams(path);
        }
      }


      private String getBaseUrlToApi() {
        return Constants.BASE_API_URL;
      }

      public BddContextHandler getHandler() {
        return BDD_CONTEXT_HANDLER;
      }

      public String getApiRoute() {
        return apiRoute;
      }

      public void setApiRoute(String apiRoute) {
        this.apiRoute = apiRoute;
      }
}
