@UIDashboard
Feature: Dashboard

  Scenario: Navigating through inventory data
    Given Navigate to dashboard page
    When  Navigate to the inventory section
    Then  View the inventory data

  Scenario: Viewing recent orders
    Given Navigate to dashboard page
    When  Navigate to the recent orders section
    Then  View the recent orders

  Scenario: Checking system status
    Given Navigate to dashboard page
    When  Check the system status section
    Then  View the current system status


