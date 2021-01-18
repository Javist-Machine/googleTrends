Feature:  As a QA Engineer, I am required to automate the following scenario:

  @tag
  Scenario: Verification of the comparison of "Selenium WebDriver and JavaScript WebDriverIO" in percentage ratio
    Given User is on the trends.google.com page
    When User searches for Selenium WebDriver in the input box
    Then User should be directed to the Explore page
    When User searches for JavaScript WebDriverIO in Compare field
    Then User should be directed to Compare page
    When User inputs "New York" in the "United States" compare-pickers-wrapper field
    And User Select 90 days from the filters
    And User Gets the percentage ratio from the Compared breakdown by metro
    Then User validates that Selenium WebDriver is more popular than WebDriverIO









#  As a QA Engineer, you are required to automate the following scenario:
#
#  •	Go to trends.google.
#
#  •	Enter “Selenium WebDriver” to the “enter search term or a topic” input box and press Enter
#  •	You should be redirected to the “Explore” page
#  •	Enter “Javascript WebDriverIO” to the “+Compare” field and press Enter
#  •	You should be on the “Compare” page
#
#  •	Select “US => New York” from the filters
#  •	Select “Past 90 days” from the filters
#  •	Get the percentual ratio from the “Compared breakdown by metro” section and display it on the console. Make sure, that “Selenium Webdriver” is more popular than WebDriverIO when it comes to the actual numbers.
