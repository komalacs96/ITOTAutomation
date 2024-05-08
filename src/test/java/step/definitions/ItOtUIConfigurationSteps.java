package step.definitions;

import constants.ItOtPathConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


    public class ItOtUIConfigurationSteps {


        private WebDriver driver;
        @Given("Navigate to configuration page")
        public void configurationPage() {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.get(ItOtPathConstants.CONFIGURATION_URL);
            driver.manage().window().maximize();
        }

        @When("Adjust the synchronization intervals")
        public void adjustTheSynchronizationIntervals() {
            // Locate and adjust synchronization intervals
        }

        @When("I modify the authentication parameters")
        public void modifyTheAuthenticationParameters() {
            // Locate and modify authentication parameters
        }

        @When("Save the changes")
        public void saveTheChanges() {
            WebElement saveButton = driver.findElement(By.id("save_button_id"));
            saveButton.click();
        }

        @Then("The synchronization intervals should be successfully adjusted and saved")
        public void synchronizationIntervalsStatus() {
            // Verify successful adjustment and saving of synchronization intervals
            String status = driver.findElement(By.cssSelector("saved_text")).getAttribute("status");
            Assert.assertEquals(status,"synchronization intervals should be successfully adjusted and saved");
        }

        @Then("The authentication parameters should be successfully modified and saved")
        public void authenticationParametersStatus() {
            // Verify successful modification and saving of authentication parameters
            String status = driver.findElement(By.cssSelector("saved_text")).getAttribute("status");
            Assert.assertEquals(status,"authentication parameters should be successfully modified and saved");
        }
    }

