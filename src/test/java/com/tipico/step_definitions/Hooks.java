package com.tipico.step_definitions;

import com.tipico.utils.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hooks {

    @Before
    public void setUpScenario() {
        System.out.println("-----> Before annotation: Setting up browser");
    }

    @After
    public void tearDownScenario(Scenario scenario) throws InterruptedException {
        //#1 we need to take a screen shot using Selenium
        // #2 we are going to attach it into our report using attach method
        //attach method accept 3 arguments:
        //1)screenshot; 2) image type; 3) current scenario's name
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Thread.sleep(2000);
        Driver.closeDriver();
    }
}