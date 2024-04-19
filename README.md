# Java-based Testing Framework

## Overview
This repository contains a testing framework designed specifically for testing the [OrangeHRM website](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login).
Built using Java, the framework leverages the power of Selenide and TestNG to automate testing processes.

## Key Features
- **Java-based Framework**
- **Selenide:** - Selenium WebDriver wrapper.
- **TestNG:** - a flexible testing framework.
- **Allure Reports:** Generates detailed and visually appealing test reports using Allure.

## Usage
To use the OrangeHRM Testing Framework:
1. Clone this repository to your local machine.
2. Set up your Java development environment and ensure all necessary dependencies are installed.
3. Configure the framework settings, such as browser configurations and test data, as needed.
4. Execute the tests and review the generated Allure reports for detailed insights into test results and any failures.

## How to execute tests
To execute the test, run {testname}.xml file with the configuration for the corresponding test.

## The test suite includes the following tests:
1. LoginFlow:
    - Login positive test;
    - Login negative test;
    - Login with cookies.
2. End-to-end tests:
    - Update the user's Personal Details;
    - Add a new user.
3. Add a new post to feed:
    - Add a new post without an image;
    - Add a new post with an image. 
 

## License
The OrangeHRM Testing Framework is licensed under the [MIT License](License).


