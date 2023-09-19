## Maven Java Selenium Framework

This repository contains a Maven-based Java Selenium framework for automated web testing. 

#### Prerequisites

Before you begin, ensure you have met the following requirements:

- Java JDK installed (version 8 or higher)
- Maven installed
- Your favorite Integrated Development Environment (IDE), such as IntelliJ IDEA or Eclipse
- If you have installed Eclipse, then make sure to install the TestNG plugin

#### Getting Started

1. Clone this repository to your local machine:

   ```java
   git clone https://github.com/ketanna/TendableTechChallenge.git

1. Open the project in your preferred IDE.

2. Build the project using Maven:

   ```java
   mvn clean install
   ```

#### Running Tests

1. To run tests, you can use the following Maven command:

   ```java
   mvn clean test -D suiteXmlFile=TestNG
   ```

2. The tests will execute, and the test results will be displayed in the console.

#### Configuration

- The configuration for the Selenium WebDriver can be found in the `src/main/Resources/config.properties` file. You can customize settings like the browser type and website URL.

#### Reporting

- Test reports will be generated under project location "target" folder "surefile-reports"
- Open "emailable-report.html" using any of your favorite browsers



