# BiharToursism
![Logo](https://bt-stage.axeno.co/content/dam/bihar-tourism/logos/color_logo.png)

### Bihar Tourism is the initiative of the Ministry of Tourism, Bihar Government to promote and incentivise the tourism opportunities in the state.

#### This project is created to automate the manual test suite which has been prepared by the Bihar Tourism QA Team

## Run Locally

Clone the project
```bash
  git clone https://github.com/PranjalYadav-QA/BiharToursism.git
```

Go to the project directory
```bash
  cd BiharToursism-project-location
```

Run the test without sending email
```bash
  mvn test
```

Run the test & send email after test execution
```bash
  mvn clean install
```

## Configuration

Following are the configurations available in the Configuration.properties file:

`AUT_url:` URL where the test is running

`environment:` local or remote (Currently, only local is supported)

`browser:` Available browser type = chrome, firefox, edge, safari

`windowMaximize:` if set to false, then browser will launch in default window size

`implicitWaitTime:` Implicit wait duration is seconds

`to_email_address:` Replace with your email address to receive email

`from_email_address:` Please don't change this

`from_email_address_password:`Please don't change this

## Tech Stack

**Automation Tool:** Selenium 4.x

**Framework:** Cucumber Framework (BDD) version 7.x

**Language:** Java, Gherkin

**Reporting:** Extent Report 5.x

**Unit Testing:** JUnit 5.x

**Logging:** Log4J Version 2.x

**Parallel Execution:** TestNg 7.x and ThreadLocal


## Support & Project Access

#### For support or query: Please ping Pranjal over Teams

#### For Project Access: Please raise the request with Vishal over Teams


## What all is implemented in the Project

- BDD Framework on latest Cucumber version
- Page Object Pattern using Selenium Page Factory
- Singleton Design Pattern
- Managers like Page Object Manager, File Reader Manager, WebDriver Manager
- Config File Reader
- Sharing Test Context using PicoContainer
- Hooks
- Sharing Scenario Context
- Cucumber Report Plugins
- Extent Reports with Screenshots
- Sending email after test execution using Exec-Maven-Plugin & Jakarta Mail API
- Generating PDF Reports
- Latest Log4J version 2 implementation
- TestNg
- ThreadLocal
- Browser Utilities

## Feedback
If you have any feedback, please reach out to Vishal or Pranjal
