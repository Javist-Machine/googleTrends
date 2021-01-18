package com.tipico.pages;

import org.jsoup.Connection;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleTrendsPage extends BasePage {

    @FindBy(id = "input-254")
    public WebElement enterSearchTermOrATopic;

    @FindBy(xpath = "//*[@id='header']/div/div[3]/div/div[1]/div/h2/span")
    public WebElement exploreTitle;

    @FindBy(xpath = "//*[@id='explorepage-content-header']/explore-pills/div/button/span"     )
    public WebElement compareField;

    @FindBy(id = "///*[@id='explorepage-content-header']/explore-pills/div/div[2]/explore-search-term/div//input"     )
    public WebElement hiddenCompareField;

    @FindBy(xpath = "//span[.='Compare']")
    public WebElement compareTitle;

    @FindBy(xpath = "//span[.='United States']")
    public WebElement stateDropDown;

    @FindBy(xpath = "//*[@id='select_option_21']/div[1]")
    public WebElement past12Months;

    @FindBy(xpath = "//*[@class='_md-text'][contains(text(),'Past 90 days')]")
    public WebElement past90Days;

    @FindBy(xpath = "//*[@class='hierarchy-select ng-pristine ng-valid']")
    public WebElement comparePickersWrapper;

    @FindBy(xpath = "//md-select[@ng-model='$parent.$parent.selectedOption']")
    public WebElement timeDurationDropDown;

    @FindBy(css = ".progress-bar-multi-heat-volume")
    public WebElement progressBar;

    @FindBy(css = ".tooltip-percentage-container>div")
    public WebElement tooltipPercentageName1;

    @FindBy(css = ".tooltip-percentage-container>div:nth-child(2)")
    public WebElement tooltipPercentage1;

    @FindBy(css = ".tooltip-percentage-section>div:nth-child(2)>div")
    public WebElement tooltipPercentageName2;

    @FindBy(css = ".tooltip-percentage-section>div:nth-child(2)>div:nth-child(2)")
    public WebElement tooltipPercentage2;


}
