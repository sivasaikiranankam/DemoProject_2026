# Java + Selenium + Cucumber + TestNG framework

Example UI automation project using Java 17, Maven, Selenium WebDriver, Cucumber feature files, TestNG runner, Page Object Model, explicit waits, hooks, and screenshots on failure.

## Requirements
- JDK 17+
- Maven 3.8+
- VS Code with Extension Pack for Java and Maven for Java
- Chrome browser
- Internet access for Maven dependencies and the sample SauceDemo site

## Open in VS Code
1. Extract this ZIP.
2. In VS Code choose **File → Open Folder** and select the extracted project folder.
3. Install recommended extensions when prompted.
4. Confirm `java -version` and `mvn -version` in the VS Code terminal.
5. Let Maven import/download dependencies.

## Run all tests
```bash
mvn clean test
```
Run only the smoke scenario:
```bash
mvn clean test -Dcucumber.filter.tags="@smoke"
```
Run only the negative login scenario:
```bash
mvn clean test -Dcucumber.filter.tags="@negative"
```

The first run downloads dependencies and WebDriverManager may download a compatible ChromeDriver. Keep Chrome installed and internet access enabled.

## Framework flow
`login.feature` → `TestRunner` → Cucumber step definitions → `LoginPage` Page Object → Selenium WebDriver → assertions. `Hooks` starts and closes the browser and saves a screenshot after a failed scenario.

## Customize
- Update `src/test/resources/config.properties` for URL, browser, headless mode, and wait timeout.
- Put new user-facing scenarios in `src/test/resources/features/`.
- Add step definitions in `src/test/java/com/example/steps/`.
- Put selectors and page actions in page classes under `pages/`.
- Do not commit real passwords or production credentials.

The sample uses the public SauceDemo training site and its documented demo credentials. Website availability and selectors can change independently of this framework.
