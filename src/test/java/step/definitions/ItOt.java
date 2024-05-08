package step.definitions;

import constants.ItOtPathConstants;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.ItOtFileUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class ItOt {
    private WebDriver driver;
    private RequestSpecification request;
    private Response response;


    @Given("Get payload from the file {string}")
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

    @Then("the product information is accurately retrieved")
    public void theProductInformationIsAccuratelyRetrieved() {
        List<String> productIdList=new ArrayList<>();
        ItOtPathConstants.productID.add(response.getBody().jsonPath().getString("features[0].productId"));
        ItOtPathConstants.productID=(Arrays.asList((ItOtPathConstants.productID.get(0)).split(", ")));
        for(int i=0;i<ItOtPathConstants.productID.size();i++){
            ItOtPathConstants.productName.add(response.getBody().jsonPath().getString("features[0].serviceName["+i+"]"));
        }
        ItOtPathConstants.productID=productIdList;
        System.out.println(ItOtPathConstants.productName);
    }
    @And("Navigate to dashboard page")
    public void dashboardPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ItOtPathConstants.DASHBOARD_URL);
        driver.manage().window().maximize();
    }

    @And("Navigate to the inventory section")
    public void inventorySection() {
        WebElement inventorySection = driver.findElement(By.xpath("//a[contains(text(),'Inventory')]"));
        inventorySection.click();
    }
    @Then("validate Inventory details")
    public void validateInventoryDetails() {
        List<String> uiProductName = new ArrayList<>();
        List<String> uiProductID = new ArrayList<>();
        List<WebElement> elements = driver.findElements(By.tagName("product_tag_name"));
        for (int i = 0; i < elements.size(); i++) {
            WebElement element = elements.get(i);
            uiProductName.add(element.getText());
            uiProductID.add(element.getAttribute("id"));
        }
        Assert.assertEquals(uiProductName.stream().sorted().collect(Collectors.toList()), ItOtPathConstants.productName.stream().sorted().collect(Collectors.toList()));
        Assert.assertEquals(uiProductID.stream().sorted().collect(Collectors.toList()), ItOtPathConstants.productID.stream().sorted().collect(Collectors.toList()));

    }
}