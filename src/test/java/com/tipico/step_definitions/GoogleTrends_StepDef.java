package com.tipico.step_definitions;

import com.tipico.pages.GoogleTrendsPage;
import com.tipico.utils.ConfigurationReader;
import com.tipico.utils.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;


public class GoogleTrends_StepDef {

    GoogleTrendsPage googleTrendsPage = new GoogleTrendsPage();
    Actions actions = new Actions(Driver.getDriver());

    @Given("User is on the trends.google.com page")
    public void user_is_on_the_trends_google_com_page() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("User searches for Selenium WebDriver in the input box")
    public void user_searches_for_selenium_web_driver_in_the_input_box() {
        String searchWord1 = "Selenium WebDriver";
        googleTrendsPage.enterSearchTermOrATopic.sendKeys(searchWord1 + Keys.ENTER);
    }

    @When("User should be directed to the Explore page")
    public void user_should_be_directed_to_the_explore_page() {
        Assert.assertEquals("Page Title does not match", "Explore",
                googleTrendsPage.exploreTitle.getText());
    }

    @Then("User searches for JavaScript WebDriverIO in Compare field")
    public void user_searches_for_java_script_web_driver_io_in_compare_field() {
        String searchWord2 = "JavaScript WebDriverIO";
        actions.doubleClick(googleTrendsPage.compareField).sendKeys(searchWord2 + Keys.ENTER + Keys.DOWN + Keys.ENTER).
                perform();
    }

    @Then("User should be directed to Compare page")
    public void user_should_be_directed_to_compare_page() {
        Assert.assertEquals("Page Title does not match", "Compare", googleTrendsPage.compareTitle.
                getText());
    }

    @Then("User Select 90 days from the filters")
    public void user_select_90_past_days_from_the_filters() {
        actions.moveToElement(googleTrendsPage.timeDurationDropDown).click().perform();
        JavascriptExecutor executor = (JavascriptExecutor) (Driver.getDriver());
        executor.executeScript("arguments[0].click();", googleTrendsPage.past90Days);
    }

    @Then("User Gets the percentage ratio from the Compared breakdown by metro")
    public void user_gets_the_percentage_ratio_from_the_compared_breakdown_by_metro() throws InterruptedException {
        Thread.sleep(2000);
        JavascriptExecutor js = (JavascriptExecutor) (Driver.getDriver());
        js.executeScript("window.scrollBy(0, 500)");
        actions.moveToElement(googleTrendsPage.progressBar).perform();
        System.out.println(String.format("The usage of %s is %s", googleTrendsPage.tooltipPercentageName1.getText(),
                googleTrendsPage.tooltipPercentage1.getText()));
        System.out.println(String.format("The usage of %s is %s", googleTrendsPage.tooltipPercentageName2.getText(),
                googleTrendsPage.tooltipPercentage2.getText()));
    }

    @When("User inputs {string} in the {string} compare-pickers-wrapper field")
    public void user_inputs_in_the_compare_pickers_wrapper_field(String text, String fieldName) {
        actions.moveToElement(googleTrendsPage.compareField.findElement(By.xpath("//*[.='" + fieldName +
                "']"))).click().pause(1000).sendKeys(text + Keys.DOWN + Keys.ENTER).perform();
    }

    @Then("User validates that Selenium WebDriver is more popular than WebDriverIO")
    public void user_validates_that_selenium_web_driver_is_more_popular_than_web_driver_io() {
        String firstItemPercentageString = googleTrendsPage.tooltipPercentage1.getText();
        float firstItemPercentage = Float.parseFloat(firstItemPercentageString.substring(0,
                firstItemPercentageString.length() - 1));
        String secondItemPercentageString = googleTrendsPage.tooltipPercentage2.getText();
        float secondItemPercentage = Float.parseFloat(secondItemPercentageString.substring(0,
                secondItemPercentageString.length() - 1));
        Assert.assertTrue("Selenium WebDriver is not more popular than WebDriverIO",
                firstItemPercentage > secondItemPercentage);
    }

}
