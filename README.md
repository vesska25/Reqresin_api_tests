# API Test automation project for [Reqres.in](https://reqres.in/)

![reqres-logo.png](images/reqres-logo.png)


# <a name="Technology">Tools and a technologies</a>
<p  align="center">
  <code><img width="5%" title="IntelliJ IDEA" src="./images/icons/IDEA-logo.svg"></code>
  <code><img width="5%" title="Java" src="./images/icons/java-logo.svg"></code>
  <code><img width="5%" title="REST-Assured" src="./images/icons/rest-assured-logo.svg"></code>
  <code><img width="5%" title="Selenoid" src="./images/icons/selenoid-logo.svg"></code>
  <code><img width="5%" title="Gradle" src="./images/icons/gradle-logo.svg"></code>
  <code><img width="5%" title="JUnit5" src="./images/icons/junit5-logo.svg"></code>
  <code><img width="5%" title="Allure Report" src="./images/icons/allure-Report-logo.svg"></code>
  <code><img width="5%" title="Allure TestOps" src="./images/icons/allure-ee-logo.svg"></code>
  <code><img width="5%" title="Github" src="./images/icons/git-logo.svg"></code>
  <code><img width="5%" title="Jenkins" src="./images/icons/jenkins-logo.svg"></code>
  <code><img width="5%" title="Telegram" src="./images/icons/Telegram.svg"></code>
</p>

The autotests in this project are written in `Java`.\
`Gradle` - is used as a build automation tool.  \
`JUnit5` - to execute tests.\
`REST Assured` - for easy API testing of REST services.\
`Jenkins` - CI/CD for running tests remotely.\
`Selenoid` - to remote launching browsers in `Docker` containers.\
`Allure Report` - for test results visualisation.\
`Telegram Bot` - for test results notifications.

# <a name="HowToRun">Autotest scenarios (API)</a>

- [x] Login test with valid data
- [x] Login test without password
- [x] Registration test with valid data
- [x] Registration test without password
- [x] Registration test without email
- [x] New user creation test
- [x] Update User job test

# <a name="HowToRun">How to run</a>

## <a name="GradleCommand">Gradle command</a>
To run locally and in Jenkins the following command is used:
```bash
gradle clean test
```


## <a name="RunInJenkins">Run in [Jenkins](https://jenkins.autotests.cloud/job/s.savich_reqresin_api/)</a>
Main page of the build:
<p  align="center">
<img src="images/jenkins-reqresin-project.png" alt="jenkins-reqresin" width="950">
</p>


# <a name="AllureReport">Test results report in [Allure Report](https://jenkins.autotests.cloud/job/s.savich_reqresin_api/allure/)</a>

## Main page
Main page of Allure report contains the following blocks:

>- <code><strong>*ALLURE REPORT*</strong></code> - displays date and time of the test, overall number of launched tests, as well as a diagram indicating the percentage and number of successful, failed and broken tests during execution
>- <code><strong>*TREND*</strong></code> - displays trend of running tests for all runs
>- <code><strong>*SUITES*</strong></code> - displays distribution of tests by suites
>- <code><strong>*CATEGORIES*</strong></code> - displays distribution of unsuccessful tests by defect types
<p align="center">
  <img src="images/Allure-mainPage.png" alt="AllureReportMain" width="950">
</p>

## List of tests with steps and test artefacts
On the page the list of the tests grouped by suites with status shown for each test.\
Full info about each test can be shown: tags, severity, duration, detailed steps.

<p align="center">
  <img src="images/Allure-suits.png" alt="Allure-suits" width="1150">
</p>

# <a name="TelegramNotifications">Telegram Notifications</a>
Telegram bot sends a brief report to a specified telegram chat by results of each build.
<p  align="center">
<img src="images/telegram-bot.png" alt="TelegramNotification" width="550">
</p>
