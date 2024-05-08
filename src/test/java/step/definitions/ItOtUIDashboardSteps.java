package step.definitions;

import constants.ItOtPathConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.PublicKey;

public class ItOtUIDashboardSteps {
    private WebDriver driver;

    @Test
    @Given("Navigate to dashboard page")
    public void dashboardPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(ItOtPathConstants.DASHBOARD_URL);
        driver.manage().window().maximize();
    }

    @When("Navigate to the inventory section")
    public void inventorySection() {
        WebElement inventorySection = driver.findElement(By.xpath("//a[contains(text(),'Inventory')]"));
        inventorySection.click();
    }

    @Then("View the inventory data")
    public void inventoryData() {
        // Verify the visibility of inventory data
    }

    @When("Navigate to the recent orders section")
    public void recentOrdersSection() {
        WebElement recentOrdersSection = driver.findElement(By.xpath("//a[contains(text(),'Recent Orders')]"));
        recentOrdersSection.click();
    }

    @Then("View the recent orders")
    public void viewTheRecentOrders() {
        // Verify the visibility of recent orders
    }

    @When("Check the system status section")
    public void checkSystemStatus() {
        WebElement systemStatusSection = driver.findElement(By.xpath("//a[contains(text(),'System Status')]"));
        systemStatusSection.click();
    }

    @Then("View the current system status")
    public void CurrentSystemStatus() {
        // Verify the visibility of current system status
    }

}
