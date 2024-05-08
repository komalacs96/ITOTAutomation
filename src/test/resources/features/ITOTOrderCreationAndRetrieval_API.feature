@OrderCreationAndRetrieval
Feature: Testing for API related to Order for smart factory automation

  Scenario: Create a new order
    Given Get payload from the file "orders.json"
    When  Send a "POST" request to "/api/order"
    Then  Response status code should be 201
    And   Response body should contain "Order created successfully"

  Scenario: Retrieve order details
    When Send a "GET" request to "/api/order/123456"
    Then Response status code should be 200
    And  Response body should contain "123456"

  Scenario: Create a new order with invalid data
    Given Get payload from the file "invalid.json"
    When  Send a "POST" request to "/api/order"
    Then  Response status code should be 400
    And   Response body should contain "Invalid order data"

  Scenario: Retrieve non-existent order details
    When Send a "GET" request to "/api/order/999"
    Then Response status code should be 404
    And  Response body should contain "Order not found"

