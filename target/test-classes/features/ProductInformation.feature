Feature: Product Information API Testing

  Scenario: Add New Product
    Given the API endpoint for adding a new product is accessible
    When I send a POST request to add a new product
    Then the response status code should be 201
    And the response body should contain the newly added product details
