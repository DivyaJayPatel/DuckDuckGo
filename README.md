# DuckDuckGO Search Engine

This project automates search tests on the DuckDuckGo search engine using a Page Object Model (POM) framework. The framework prioritizes privacy by utilizing DuckDuckGo, which avoids search history tracking and personalized results.





## PageObjectModel Structure

**BaseTest.java:** This class provides common functionalities like opening the browser and navigating to the DuckDuckGo URL (likely defined in a configuration file).

**config.properties:** his file stores configuration data such as the browser name and DuckDuckGo URL.

**DuckDuckGoSearchPage.java** This class interacts with the search box element on the DuckDuckGo homepage, allowing you to enter search terms.

**DuckDuckGoSearchResultPage.java:** TThis class handles elements displayed after a search, potentially including functionalities to access search results (titles, images, etc.).

**ExtentReporterNg:** This library helps generate reports for your automated tests.

**DuckDuckGoSearchResult.java:** This class (likely the main test class) executes the search automation using the functionalities defined in the other components.


## Getting Started

1.	Ensure you have Java, Maven, TestNG, and Selenium WebDriver installed.
2.	If using Eclipse as your IDE, import the project into your workspace.
3.	Configure the config.properties file with your desired browser and DuckDuckGo URL.
4.	Review the implemented functionalities within each class (BaseTest, DuckDuckGoSearchPage, DuckDuckGoSearchResultPage, DuckDuckGoSearchResult).
5.	You can execute the tests using a test runner tool like Maven Surefire plugin.




## Technologies Used

**Programming Language:** Java

**Build Tool:** Maven

**Test Framework:** TestNG

**IDE (Recommended):** Eclipse

**Web Automation Library:** Selenium WebDriver

**Reporting:** ExtentReporterNg
