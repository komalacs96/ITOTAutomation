@DataConsistency
Feature: Data Consistency Check

  Scenario: Ensure consistent data between IT and OT systems
    Given User is on the dashboard page
    When  User adds a new product through the UI
    Then  Backend data reflects the change
    And   OT systems show the updated information
