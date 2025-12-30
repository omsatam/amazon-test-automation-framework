package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features="src/test/Resources/Features/Languages.feature",
        tags = "not @ignore",
        glue={"stepDefinition",
                "hooks",
                "context"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:target/Reports",
        "rerun:target/failed_scenarios.txt"
        }
)

public class TestNgTestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
