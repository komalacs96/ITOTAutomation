@UIConfiguration
Feature: Configuration Page

  Scenario: Adjusting synchronization intervals
    Given Navigate to configuration page
    When  Adjust the synchronization intervals
    And   Save the changes
    Then  The synchronization intervals should be successfully adjusted and saved

  Scenario: Modifying authentication parameters
    Given Navigate to configuration page
    When  I modify the authentication parameters
    And   Save the changes
    Then  The authentication parameters should be successfully modified and saved
