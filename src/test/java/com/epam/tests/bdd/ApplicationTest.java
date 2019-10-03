package com.epam.tests.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
ApplicationTest .
@author Dmytro Korytov
Created Date: 9/26/2019
*/
@RunWith(Cucumber.class)
@CucumberOptions(
    features = "./src/test/resources/stories/ValidateResponse.feature",
    plugin = {"pretty", "json:target/cucumber-report.json","html:target/site/cucumber-pretty"},
    glue = {"com.epam.tests.bdd.definitions.impl"}
)
public class ApplicationTest {
}
