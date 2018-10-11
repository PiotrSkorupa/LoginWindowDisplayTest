# Acceptance Testing
Full login window displayed vaildation


## Features
- Java
- Maven
- Chromedriver
- Selenium WebDriver
- jUnit
- Allure


### Running the test
Make sure your Chromedriver is in correct path and use commands:
```
$ mvn clean test
```

 Generate Allure report:
```
$ allure generate /target/surefire-reports/
```

 Change user agent:
```
- select user agent from Config.properties and enter it as a "key" value in browser variable.
```
