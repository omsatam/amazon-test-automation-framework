package hooks;

import base.DriverManager;
import base.PageBase;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import testContext.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import io.cucumber.java.Scenario;

public class Hooks {
        private static final Logger logger = LogManager.getLogger(Hooks.class);
        private final TestContext testContext;
        private final DriverManager driverManager;
        private Scenario scenario;
        public Hooks(TestContext testContext, DriverManager driverManager) {
            this.testContext = testContext;
            this.driverManager = driverManager;
        }

        @Before
        public void setUp(Scenario scenario) {
            logger.info("Starting Scenario: {}",scenario.getName());
            testContext.setDriver(driverManager.getDriver());
        }

        @After
        public void tearDown(Scenario scenario) throws IOException {
            if (scenario.isFailed()) {
                //            System.out.println("taking screenshot");
                File screenshot = ((TakesScreenshot) driverManager.getDriver()).getScreenshotAs(OutputType.FILE);
                byte[] filecontent = FileUtils.readFileToByteArray(screenshot);
                scenario.attach(filecontent, "image/png", "image");
            }
            logger.info("Ending Scenario {} | Status: {}",scenario.getName(),scenario.getStatus());
            driverManager.quitDriver();
        }


}
