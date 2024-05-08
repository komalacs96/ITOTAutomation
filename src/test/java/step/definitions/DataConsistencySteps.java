package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataConsistencySteps {

    WebDriver driver;

    @Given("User is on the dashboard page")
    public void dashboardPage() {
        // Code to navigate to the dashboard page
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.get("url_of_dashboard_page");
    }

    @When("User adds a new product through the UI")
    public void user_adds_a_new_product_through_the_UI() {
        // Code to add a new product through the UI
        driver.findElement(By.id("addProductButton")).click();
        // Fill in the product details
        driver.findElement(By.id("productId")).sendKeys("P123");
        driver.findElement(By.id("productName")).sendKeys("New Product");
        driver.findElement(By.id("productPrice")).sendKeys("99.99");
        driver.findElement(By.id("saveProductButton")).click();
    }

    @Then("Backend data reflects the change")
    public void backend_data_reflects_the_change() {
        // Code to verify backend data
        // Assume backend verification code here
        // Example: Check database for the newly added product
        boolean isProductAdded = verifyProductInDatabase("P123");
        Assert.assertTrue("Product was not added to the database", isProductAdded);
    }

    @Then("OT systems show the updated information")
    public void ot_systems_show_the_updated_information() {
        // Code to verify OT systems
        // Assume OT verification code here
        // Example: Check OT dashboard for the newly added product
        boolean isProductDisplayed = verifyProductInOTDashboard("P123");
        Assert.assertTrue("Product was not displayed in OT dashboard", isProductDisplayed);
    }

    private boolean verifyProductInDatabase(String productId) {
        // Dummy method to simulate verifying product in database
        // Replace this with actual database verification logic
        return true;
    }

    private boolean verifyProductInOTDashboard(String productId) {
        // Dummy method to simulate verifying product in OT dashboard
        // Replace this with actual OT verification logic
        return true;
    }
}
