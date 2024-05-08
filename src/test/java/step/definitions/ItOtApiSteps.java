package step.definitions;


import constants.ItOtPathConstants;
import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import utils.ItOtFileUtils;

import java.io.IOException;

import static io.restassured.RestAssured.given;


public class ItOtApiSteps {

    private RequestSpecification request;
    private Response response;


    @Given("Get a payload from the file {string}")
    public void prepareProductPayload(String category, String fileName) throws IOException {
        String payload = ItOtFileUtils.readPayloadFromFile(ItOtPathConstants.BASIC_TEST_FILE_PATH + fileName);
        request = given().contentType("application/json").body(payload);
   }

    @When("Send a {string} request to {string}")
    public void sendRequest(String method, String endpoint) {
        String uri = ItOtPathConstants.BASE_URL + endpoint;
        switch (method.toUpperCase()) {
            case "GET":
                response = request.when().get(uri);
                break;
            case "POST":
                response = request.when().post(uri);
                break;
        }
    }

    @Then("Response status code should be {int}")
    public void verifyStatusCode(int expectedStatusCode) {
        response.then().assertThat().statusCode(expectedStatusCode);
    }

    @Then("Response body should contain {string}")
    public void verifyResponseBody(String expectedText) {
        response.then().assertThat().body(Matchers.containsString(expectedText));
    }



}

