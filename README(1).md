# SauceDemoMaven

This is a sample Maven + TestNG + Selenium project for automating https://www.saucedemo.com/

## How to use

1. Unzip the project and import into Eclipse as an existing Maven project:
   - File -> Import -> Existing Maven Projects -> select the unzipped folder

2. Run tests:
   - From command line: `mvn test`
   - Or in Eclipse: Run As -> Maven test or Run As -> TestNG Test (on the test class)

This project uses WebDriverManager to automatically manage Chromedriver binaries.

Default test user used in test:
- Username: standard_user
- Password: secret_sauce

