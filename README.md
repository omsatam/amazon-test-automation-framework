🧪 Amazon Test Automation Framework
🚀 Tech Stack

Java 17

Selenium WebDriver

Cucumber (BDD)

TestNG

Maven

Extent Reports

Log4j2

📂 Framework Highlights

✔ Page Object Model with reusable PageBase
✔ Centralized Driver Management
✔ Parallel Execution (Thread-safe)
✔ Automatic Rerun of Failed Scenarios
✔ Screenshot & Logs on Failure
✔ Extent HTML Reports
✔ Config-driven execution

▶️ How to Run Tests

Run all tests

mvn clean test


Run failed scenarios only

mvn test -Dtest=FailedTestRunner

📊 Reports

Extent Report: target/Reports

Logs: logs/amazon.log

🧠 Design Principles

No WebDriver calls in step definitions

All waits centralized

Thread-safe parallel execution

Deterministic reruns to reduce flakiness
