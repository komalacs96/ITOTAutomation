# Introduction
The Project contains the automation scripts of IT/OT Data Integration for Smart Factory

## Getting Started
### 1. Software Required
   JDK 8 or Higher: Runtime for executing the rest assured and cucumber test cases
   Maven : Dependency management tool for downloading the test script dependencies
   Selenium Webdriver: WebDriver for executing the UI related testcases
   Intellij IDEA : To develop and execute the code locally
### 2. Understanding the  code base

   1. The code base contains the below major functionalities:
   2. API for product creation of product and retrieval the order details(ItOtApiSteps.java)
   3. API for order creation of product and retrieval the order details(ItOtApiSteps.java)
   4. UI for checking the dashboard details(ItOtUIDashboardSteps.java)
   5. UI for configuration details(ItOtUIConfigurationSteps.java)
   6. API& UI Comparing the data from API response and UI details(ItOt.java)

### 3. Pre-requisites 
#### Step 1: Ensure maven is installed on your system
    mvn install

#### Step 2: Ensure WebDriver id installed(ChromeDriver)
    'https://chromedriver.chromium.org/downloads'

#### Step 3: Download the dependencies from maven repository
    'https://mvnrepository.com'

### 4. CURD request for  the API endpoint
    POST - Create a new product
    GET  - Retrieve the product details

### 5. Build and Test
1. From Intellij:
    Open the ItOtTestRunner.java file -> Right-click on the Run/Play Icon -> Select Run ItOtTestRunner
2. From maven via Terminal:
    mvn test