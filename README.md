# Test-Automation-XYZbank
Java project for test automation covering functional test cases of XYZ bank application.

# Concepts included
•	Data-driven framework
•	Page Object Model

# Tools
•	Maven 
•	Selenium
•	TestNG

# Requirements
In order to utilize this project you need to have the following installed locally:
Chrome driver or edge driver installed and placed in Resources/executables

# Usage
To run the project in a different browser change the 'browser' value in Resources/properties/config.properties

To run all the test cases
mvn clean install

# Reporting
Reports for each module are written into their respective /target directories after a successful run

Additionally, logs are generated which are written into Resources/logs/app.log
The screen is captured in case of failure and placed in failedSnapshots/ which are later integrated into extent reports.
Extent reports are generated which are added to Reports/


