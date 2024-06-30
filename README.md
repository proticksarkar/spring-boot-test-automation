# Spring Boot Test Automation


## Overview

The Spring Boot Test Automation project is designed to showcase a comprehensive approach to automated testing, providing a real-world context for demonstrating how to build and integrate an automated testing framework. By leveraging the power of Cucumber and TestNG, the project embraces Behavior-Driven Development (BDD) principles, ensuring that the tests are not only automated but also human-readable and maintainable. It also integrates various tools and frameworks to enhance test automation, logging and reporting capabilities.


## Table of Contents

- [Introduction](#introduction)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Automated Testing Framework](#automated-testing-framework)
- [Pre-requisites](#pre-requisites)
- [Setup and Configuration](#setup-and-configuration)
- [Test Profiles and Properties](#test-profiles-and-properties)
- [Running Tests](#running-tests)
- [Logging](#logging)
- [Reporting](#reporting)
- [Continuous Integration (CI)](#continuous-integration-ci)
- [Additional Information](#additional-information)
- [Acknowledgements](#acknowledgements)


## Introduction

The Spring Boot-based test automation project aims to streamline the automation of testing by offering a robust and scalable framework. Built upon Java-based libraries, it harnesses the capabilities of TestNG for structuring and executing tests with flexibility and efficiency. The project integrates Cucumber for Behavior-Driven Development (BDD), empowering teams to write human-readable scenarios that align with business requirements. It also incorporates Maven for dependency management and GitHub Actions for continuous integration, ensuring seamless build and deployment processes. By combining these tools, the project facilitates comprehensive testing, logging, and reporting, enhancing overall software quality and development efficiency.


## Technology Stack

The project includes the following components:
- **Java**: The project is developed using Java programming language.
- **Spring Boot**: A framework for creating production-grade Spring-based applications.
- **Maven**: A build automation and dependency management tool. 
- **Selenium**: A web browser automation tool used for browser automation.
- **WebDriverManager**: A library to automate the management of WebDriver binaries.
- **TestNG**: A testing framework for Java used for structuring and executing tests.  
- **Cucumber**: A BDD framework used for defining and running acceptance tests. 
- **Lombok**: A Java library used for reducing boilerplate code and also used for logging. 
- **Jackson Databind**: A high-performance library for JSON data binding. 
- **Hamcrest**: A framework that simplifies writing matcher objects, commonly used to define conditions and perform clear test assertions. 
- **Poiji**: A library for deserializing Excel data to Java objects. 
- **Apache Commons IO**: A library of utilities to work with I/O operations. 
- **Java Faker**: A library for generating fake data.
- **Maven Cucumber Reporting**: A plugin to generate Cucumber test reports in Maven builds. 
- **Cluecumber Report Plugin**: A plugin to generate interactive Cucumber reports for Maven. 
- **Allure Maven Plugin**: A plugin for integrating Allure with Maven builds. 
- **Allure TestNG**: An adapter for integrating Allure with TestNG. 
- **Allure Cucumber JVM**: An adapter for integrating Allure with Cucumber JVM. 
- **Extent Reports**: A customizable test execution report library. 
- **Extent Reports Cucumber 7 Adapter**: An adapter for integrating Extent Reports with Cucumber 7. 
- **Sonar Maven Plugin**: A plugin for integrating Maven with SonarQube for continuous inspection of code quality.

## Project Structure

    ├── src
    │   ├── main
    │   │   ├── java                                        # Main Java source code
    │   │   │   └── com.spring.springboot.testautomation
    │   │   │       └── webframework
    │   │   │           ├── actions
    │   │   │           ├── annotations
    │   │   │           ├── aop
    │   │   │           ├── constants
    │   │   │           ├── enums
    │   │   │           ├── exceptions
    │   │   │           ├── hooks
    │   │   │           ├── interfaces
    │   │   │           ├── listeners
    │   │   │           ├── logging
    │   │   │           ├── models
    │   │   │           ├── reporting
    │   │   │           ├── utils
    │   │   │           └── webdriver 
    │   │   │           
    │   │   │
    │   │   └── resources                                   # Configuration files and resources    
    │   │          
    │   ├── test
    │   │   ├── java                                        # Test Java source code         
    │   │   │   └── com.spring.springboot.testautomation
    │   │   │           ├── annotations
    │   │   │           ├── models
    │   │   │           ├── pages
    │   │   │           ├── runners
    │   │   │           ├── steps
    │   │   │           └── tests
    │   │   │       
    │   │   │
    │   │   └── resources                                   # Test-specific feature files, test data and resources
    │   │       ├── features
    │   │       └── testdata
    │   │   
    │   └── target                                          # Test execution output
    │       └── test-artifacts
    │           ├── reports
    │           ├── screenshots
    │           └── logs
    │
    ├── docker-compose.yml                                  # Docker container based configuration file
    ├── pom.xml                                             # Maven project configuration file
    └── README.md                                           # Project documentation (this file)

## Automated Testing Framework

The essence of this project lies in its automated testing framework, constructed predominantly using Spring Boot. This framework is crafted to be extensible and user-friendly, enabling developers to articulate test scenarios in a language accessible to non-technical stakeholders. Key features of the framework encompass:
- **Modular Design**: The framework is structured in a modular way, allowing for easy integration and extension. It separates test logic from test data and configurations, promoting reusability and maintainability.
- **Spring Context Integration**: The framework leverages Spring's dependency injection to manage framework and test dependencies, making it easier to utilize the framework capabilities and write and maintain tests.
- **WebDriver Manager Integration**: Easily initiate and manage web browsers using WebDriver manager, ensuring consistent and reliable browser sessions for testing purposes.
- **Parallel Test Execution**: Effectively manage and execute tests in parallel, optimizing test suite execution time and resource utilization.
- **BDD with Cucumber**: Cucumber is used to define test scenarios in Gherkin language, making them human-readable. This aligns with BDD principles, ensuring that tests can be understood by all stakeholders.
- **Cross-Browser Testing**: Conduct comprehensive cross-browser testing across browsers like Chrome and Firefox, ensuring compatibility across different browser environments.
- **Excel to POJO Mapping**: Seamlessly map Excel data to Plain Old Java Objects (POJOs) for easier data manipulation and test case creation.
- **Boilerplate Code Reduction**: Lombok annotations are employed to reduce boilerplate code, simplifying test development and maintenance efforts.
- **Custom Annotations and Utilities**: Custom annotations and utility classes are provided to simplify common test tasks, such as setting up test data, managing test contexts, logging and reporting.
- **Built-in Environment Switcher**: Easily switch between different environments such as _web (default)_, _web-qa_, _web-remote_, and _web-remote-qa_ for flexible and efficient testing.
- **SonarQube Integration**: Integrate with SonarQube for comprehensive vulnerability analysis and code quality assessment, ensuring the security and reliability of the codebase.
- **Integration with CI (GitHub Actions)**: Seamlessly integrate test execution into Continuous Integration (CI) pipelines using GitHub Actions, enabling automated testing with every code change.


## Pre-requisites

- Java Development Kit (JDK) (version 17 or above)
- Apache Maven
- IDE (Integrated Development Environment) like IntelliJ IDEA


## Setup and Configuration

1. Clone the project repository to your local machine by running the following command:

   `git clone <repository-url>`

2. Open the project in your preferred IDE.

3. Install the required dependencies and compile the source code by running the following command:

   `mvn clean compile`

4. Configure the framework related settings, such as Spring, WebDriver, Logging configurations, etc., in the configuration files (application-&lt;name&gt;.properties) located in *src/main/resources* directory (_Optional_).

5. Customize the logging and reporting settings in the respective configuration files located in the *src/main/resources* directory if you want to change the default settings (_Optional_).

6. Update the test data, if needed, in the test data files located in the *src/test/resources/testdata* directory (Optional).

7. Build the project by running the same command, mentioned in Step 3.


## Test Profiles and Properties

- **Spring Profiles**:
    - _web (default)_: Profile is configured for running web-based tests in a local environment. The default profile is set to _web_.
    - _web-qa_: Profile is configured for running web-based tests in a QA environment.
    - _web-remote_: Profile is configured for running web-based tests in a remote environment.
    - _web-remote-qa_: Profile is configured for running web-based tests in a remote QA environment.
- **Test Configuration**:
    - _threadcount_: Tests can run concurrently with a specified thread count.
    - _webBrowserType_: Tests are configured to run on a specific web browser type. Supported types are as follows:
        - _chrome_
        - _firefox_
    - _webExecutionType_: Tests are executed locally or on a remote platform. Supported types are as follows:
        - _local_
        - _remote_
    - _webRemotePlatformType_: Tests are configured to run on Selenium Grid or a similar remote platform. Supported types are as follows:
        - _seleniumGrid_
        - _browserstack_


## Running Tests

**IDE**
- Run tests using TestRunner.java present in _src/test/java/com/spring/springboot/testautomation/runners_ directory using IDE like IntelliJ IDEA.
- By default, it'll pick up the _spring.profiles.active_ profile that has default true activation (in this case, it is _web_)

**CLI**  
Execute the following commands in the project's root directory to run tests using Maven Surefire Plugin:

`mvn test`  -> Run tests with default profile _web_  
`mvn test -Pweb-remote`  -> Run tests with _web-remote_ profile  
`mvn test -Dthreadcount=5` -> Run _5_ tests concurrently  
`mvn test -DwebBrowserType=firefox` -> Run tests on _firefox_ browser  
`mvn test "-Dcucumber.filter.tags=@nobrowser"` -> Run tests matching _@nobrowser_ cucumber tag  
`mvn test -DwebExecutionType=remote -DwebRemotePlatformType=seleniumGrid` -> Run tests on _seleniumGrid_ _remote_ platform   
`mvn test "-Pweb-remote-qa" "-Dthreadcount=3" "-DwebBrowserType=chrome" "-DwebExecutionType=local" "-Dcucumber.filter.tags=@smoke"` -> Run tests with _web-remote-qa_ profile and _3_ parallel threads matching _@smoke_ cucumber tag on _chrome_ browser

**Remote execution on Selenium hub**: 
- Run command `docker-compose up -d` from the root directory of the project to start selenium hub and different browser nodes. 
- Go to http://localhost:4444/grid/console to check 'Grid Console'. 
- Run command `mvn test -DwebExecutionType=remote -DwebRemotePlatformType=seleniumGrid ` to execute tests on remote Selenium Grid.

**Note**:
- To run tests on any other remote platform, please configure accordingly.


## Logging

**Lombok**

Logging with Lombok enhances code readability and reduces boilerplate by automatically generating standard logging methods, such as `private static final Logger log = LoggerFactory.getLogger(ClassName.class);`, when annotating the class with _@Slf4j_. This annotation eliminates the need for explicit logger instantiation in each class. Configuration options, including log levels and appenders, are typically managed through widely-used logging frameworks like Logback (utilized in this case) or Log4j. Customizing logging behavior is achieved through configuration files such as logback.xml (employed here) or log4j2.xml, typically found in the src/main/resources directory.

Execution logs are stored in the _/target/test-artifacts/logs_ directory based on your configuration in logback.xml. These logs are accessible for review and analysis using your preferred text editor.

## Reporting

*This project includes the following reporting frameworks:*

**Cucumber Reporting**

Cucumber Reporting generates comprehensive and user-friendly HTML reports detailing test execution outcomes. After running tests, Cucumber generates detailed reports that include test scenarios, steps, assertions, and any configured test details. The report artifactscan be found in _/target/test-artifacts/reports/cucumber-reports_ directory, as specified in the configuration. You can view the Cucumber report by opening the HTML files, generated after test execution, in your preferred browser.

**Allure Reporting**

Allure Reporting library generates interactive and visually appealing reports. After running the tests, Allure generates detailed HTML reports with test results, including test steps, assertions, and other configured test details. The report artifacts can be found in _/target/test-artifacts/reports/allure-reports/allure-results_ directory, as defined in the configuration, after the test execution. You can view the Allure report by executing the following command:

`allure serve <generated_report_path>`

**Extent Reporting**

Extent Reporting library provides rich and interactive HTML reports with detailed information about test executions. The execution reports can be found in */target/test-artifacts/reports/extent-reports* directory as defined in the configuration. You can open the generated Extent report in your preferred browser.


## Continuous Integration (CI)

- On each commit push or pull request to main or develop or feature/* branch, tests will be executed with GitHub Actions. 
- You can check the results of the execution in the 'Actions' tab of the repository.
- You can access the latest generated cucumber report at https://proticksarkar.github.io/spring-boot-test-automation/cucumber-reports/cucumber-result.html.

**Note**  
This project can be integrated with a CI/CD pipeline of your choice, such as Jenkins. Configure the pipeline to build the project, restore dependencies, execute tests, and generate the required logs and reports.


## Additional Information

For more details on the usage of the various tools and frameworks incorporated in this project, refer to their respective documentations:  
[Spring Boot](https://spring.io/projects/spring-boot)  
[Maven](https://maven.apache.org)  
[Selenium](https://www.selenium.dev)  
[WebDriverManager](https://github.com/bonigarcia/webdrivermanager)  
[Cucumber](https://cucumber.io)  
[TestNG](https://testng.org/#_testng_documentation)  
[Lombok](https://projectlombok.org)  
[Jackson Databind](https://github.com/FasterXML/jackson-databind)  
[Hamcrest](https://hamcrest.org/JavaHamcrest)  
[Poiji](https://github.com/ozlerhakan/poiji)  
[Apache Commons IO](https://commons.apache.org/proper/commons-io)  
[JavaFaker](https://github.com/DiUS/java-faker)  
[Cucumber Reporting](https://cucumber.io/docs/cucumber/reporting?lang=java)  
[Allure Reporting](https://docs.qameta.io/allure)  
[Extent Reporting](https://www.extentreports.com/docs/versions/5/java)  
[Maven Surefire Plugin](https://maven.apache.org/surefire/maven-surefire-plugin)  
[SonarScanner for Maven](https://docs.sonarsource.com/sonarqube/latest/analyzing-source-code/scanners/sonarscanner-for-maven)  
[Docker](https://docs.docker.com/manuals)


## Acknowledgements

Thanks to the creators and maintainers of the tools and frameworks used in this project.