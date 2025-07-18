```markdown
# 🏍️ Identify New Bikes

This is a Selenium WebDriver-based test automation framework built with Java, TestNG, and Maven, designed to extract and validate automotive information from https://www.zigwheels.com
The project demonstrates advanced handling of windows, frames, dynamic content, and error capturing—applicable in real-world automation testing scenarios.

---

## 📌 Problem Statement

Automate the following scenarios from ZigWheels or a legitimate automotive website:

### 1. 🛵 Identify Upcoming Honda Bikes Under ₹4 Lakhs
- Extract:
  - Bike Name
  - Price
  - Expected Launch Date
- Conditions:
  - Manufacturer: Honda
  - Price: Less than ₹4,00,000

### 2. 🚗 Extract Popular Used Car Models in Chennai
- Navigate to the "Used Cars" section.
- Filter by location: Chennai
- Extract all popular model names and store/display them as a `List`.

### 3. 🔐 Google Login Attempt
- Click on Login via Google.
- Enter invalid account details.
- Capture and display the **error message** shown on failed login.

---

## 🧱 Framework Overview

### 🔧 Technologies Used

- Java 8+
- Selenium WebDriver
- TestNG
- Maven
- ExtentReports (for reporting)
- Apache POI (for future Excel support)
- Log4j2 (for logging)

---

## 📂 Project Structure

```bash
ZigwheelsTestFramework/
├── src/test/java/
│   ├── testbase/              # WebDriver setup and config loading
│   ├── pageobjects/           # POM classes for site pages
│   ├── utilities/             # Reusable helpers (Excel, Reports, Data)
│   └── tests/                 # TestNG test cases
├── resources/
│   ├── config.properties      # Application config (browser, URL, etc.)
│   └── log4j2.xml             # Logging configuration
├── reports/                   # Generated HTML reports
├── testng.xml                 # Test suite definition
├── pom.xml                    # Maven dependency manager


## 🧪 Key Features

- ✅ Page Object Model (POM) design pattern
- ✅ Dynamic content scraping and filtering
- ✅ Handling of windows and frames
- ✅ Form automation and validation message capture
- ✅ Test logging and HTML reporting
- ✅ Reusable utilities and test data support

---

## ⚙️ Setup & Installation (Eclipse)

### 1. Prerequisites

- Eclipse IDE (2021-12 or later)
- Java SDK (8+)
- Maven 3.6+
- ChromeDriver or compatible WebDriver

### 2. Import the Project

- Extract or clone the project repository
- In Eclipse: `File → Import → Existing Maven Project → Select the folder`

### 3. Configure `config.properties`

Located at `/resources/config.properties`:

```properties
browser=chrome
driverPath=./drivers/chromedriver.exe
baseUrl=https://www.zigwheels.com
````

### 4. Run TestNG Suite

From Eclipse:

* Right-click `testng.xml` → `Run As` → `TestNG Suite`

---

## 🔍 Sample Output

### ✅ Upcoming Honda Bikes Under ₹4 Lakhs

| Bike Name | Price     | Launch Date    |
| --------- | --------- | -------------- |
| Honda XYZ | ₹3,50,000 | September 2025 |
| Honda ABC | ₹2,75,000 | October 2025   |

---

### ✅ Popular Used Car Models in Chennai

```java
Popular Models: [Maruti Swift, Hyundai i20, Honda City, Toyota Innova]
```

---

### ✅ Google Login Error Message

```java
Captured Error: “Couldn’t find your Google Account”
```

---

## 🧩 Test Scenarios

| Test ID | Scenario Description                              | Status |
| ------: | ------------------------------------------------- | ------ |
|   TC001 | Fetch upcoming Honda bikes below ₹4L              | ✅ Pass |
|   TC002 | List popular used car models in Chennai           | ✅ Pass |
|   TC003 | Validate Google login with invalid credentials    | ✅ Pass |
|   TC004 | Navigate frames, windows, and return to home page | ✅ Pass |

---

## 🧰 Tools & Utilities

* **BaseClass.java** – Initializes and manages WebDriver lifecycle
* **LoginPage.java** – Handles login interactions
* **UpcomingBikesPage.java** – Extracts bike data using filters
* **UsedCarsPage.java** – Extracts popular models
* **ExtentReportManager.java** – Generates beautiful HTML reports
* **DataProviders.java** – Feeds dynamic test data
* **ExcelUtility.java** – \[Pluggable for data-driven testing]

---

## 📊 Reports

After test execution, reports are auto-generated under `/reports/`:

* `ExtentReport.html` – Graphical HTML report with logs
* `TestNGReport.html` – Tabular result summary from TestNG

---

## 🔮 Future Enhancements

* 🔄 Retry logic for failed tests
* 📸 Screenshots on test failure
* ☁️ CI/CD integration with GitHub Actions or Jenkins
* ⚙️ Parallel execution for faster results
* 📑 Excel-based test data for large-scale testing

---

## 👨‍💻 Maintainers

**Samridh Makkar**  
**Kanav Gupta**  
**Stuti Kothari**  
**Arsh Chaudhary**  
**Ujjwal Bodkhe**  
**Kunj Maheshwari**

---


## 📝 License

This project is provided for educational and demonstration purposes only. No commercial or official affiliation with ZigWheels or its partners.

---

> ⭐ Found this helpful? Consider starring the repository or contributing via pull requests.

````

---

### ✅ How to Use This

1. Save this content as `README.md` in the root directory of your project.
2. Push the project (with this README) to GitHub using:
   ```bash
   git init
   git add .
   git commit -m "Initial commit: ZigWheels Selenium Automation Framework"
   git remote add origin <your-repo-url>
   git push -u origin main
````
