Feature: Check Login API on correct behavior

    Scenario: OIDC API VALIDATION

    Given user call login api
    |/login|

    When user received response from api he see that is 200 status and response isn't null
    Then user see that he have correct id by pattern.
    Then user see that he have correct name by pattern.
    Then user see that he have correct email by pattern.
    Then user see that he have correct phone number by pattern.
