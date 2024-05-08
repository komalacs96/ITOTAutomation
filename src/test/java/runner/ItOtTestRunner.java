package runner;

import com.aventstack.extentreports.reporter.ReporterConfigurable;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features/"},
        glue = {"step.definitions"},
        tags = "@End2End",
        monochrome = true,
        dryRun = false,
        plugin = { "pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class ItOtTestRunner {

}
