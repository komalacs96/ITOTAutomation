@ProductCreationAndRetrieval
Feature: Testing for API related to Product for smart factory automation

  Scenario: Create a new product
    Given Get a payload from the file "products.json"
    When  Send a "POST" request to "/api/product"
    Then  Response status code should be 201
    And   Response body should contain "Product created successfully"

  Scenario: Update Existing Product Information
    Given Get a payload from the file "products.json"
    When  Send a "PUT" request to "/api/product"
    Then  Response status code should be 200
    And   Response body should contain "Product Updated Successfully"

  Scenario: Retrieve product details
    When Send a "GET" request to "/api/product/789"
    Then Response status code should be 200
    And  Response body should contain "Smartphone"

  Scenario: Create a new product with invalid data
    Given Get a payload from the file "invalid.json"
    When  Send a "POST" request to "/api/product"
    Then  Response status code should be 400
    And   Response body should contain "Invalid product data"

  Scenario: Retrieve non-existent product details
    When Send a "GET" request to "/api/product/999"
    Then Response status code should be 404
    And  Response body should contain "Product not found"

