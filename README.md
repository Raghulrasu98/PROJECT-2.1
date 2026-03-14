# 🛒 Demoblaze E-Commerce – Selenium Automation Testing Framework


## 📌 Project Overview

This project is an end-to-end **Selenium WebDriver automation framework** built using **Java** and **TestNG** to test the [Demoblaze](https://www.demoblaze.com) e-commerce web application.

It covers functional testing, UI/UX validation, data-driven testing, and automated reporting — built using industry-standard design patterns and tools.

---

## 🌐 Application Under Test

- **URL:** https://www.demoblaze.com
- **Type:** E-Commerce Web Application
- **Features Tested:** Login, Signup, Cart, Order Placement, Navigation, UI/UX

---

## 🏗️ Framework Architecture

```
2.ProjectCopy/
├── src/
│   ├── main/java/
│   │   ├── base/
│   │   │   └── Projectspecificmethods.java   # Base class – BeforeSuite, BeforeMethod, DataProviders
│   │   ├── pages/                             # Page Object Model (POM) classes
│   │   │   ├── LoginPage.java
│   │   │   ├── SignupPage.java
│   │   │   ├── CartPage.java
│   │   │   ├── OrderPage.java
│   │   │   ├── ProductPage.java
│   │   │   ├── CategoryPage.java
│   │   │   ├── NavbarPage.java
│   │   │   └── FontPage.java
│   │   └── utils/
│   │       ├── Utilityclass.java              # WebDriver setup, Excel reader, Screenshot util
│   │       └── MyListeners.java               # TestNG Listener
│   ├── test/java/
│   │   └── test/                              # Test classes
│   │       ├── LoginTest.java
│   │       ├── SignupTest.java
│   │       ├── CartFunctionTest.java
│   │       ├── OrderFunctionTest.java
│   │       ├── BrowsingAndNavigationTest.java
│   │       └── UiAndUxTest.java
│   └── test/resources/
│       └── Data/
│           └── DemoblazeData.xlsx             # Excel test data
├── Screenshot/                                # Auto-captured test screenshots
├── logs/                                      # Log4j log files
└── pom.xml
```

---

## 🧪 Test Coverage

| Test Class | Scenarios Covered |
|---|---|
| `LoginTest` | Valid login, Invalid login, Empty fields, Password masking |
| `SignupTest` | Valid signup, Existing user, Empty fields |
| `CartFunctionTest` | Add product, View cart, Remove product, Add multiple products + total validation |
| `OrderFunctionTest` | Valid order placement, Empty order details, Confirmation popup |
| `BrowsingAndNavigationTest` | Browse by category, View product details, Home navigation, Navbar navigation, Logout |
| `UiAndUxTest` | Product alignment, Button visibility, Font consistency, Alert popup, Horizontal scrolling (mobile) |

> **Total: 20+ test scenarios across 6 test classes**

---

## 🛠️ Tech Stack

| Tool / Technology | Version | Purpose |
|---|---|---|
| Java | 17 | Core programming language |
| Selenium WebDriver | 4.41.0 | Browser automation |
| TestNG | 7.12.0 | Test framework & execution |
| Maven | 3.x | Build & dependency management |
| Apache POI | 5.5.1 | Excel data-driven testing |
| ExtentReports | 5.1.2 | HTML test reporting |
| Log4j2 | 2.25.3 | Test execution logging |
| Git | – | Version control |

---

## ✨ Key Features

- ✅ **Page Object Model (POM)** – Clean separation of page logic and test logic
- ✅ **Data-Driven Testing** – Test data managed via Excel sheets (Login, Signup, Cart, LoginDetails)
- ✅ **ExtentReports** – Auto-generated dark-themed HTML reports with test categories and author info
- ✅ **Log4j2 Logging** – Detailed step-by-step logs for every test
- ✅ **Screenshot on Execution** – Timestamped screenshots captured automatically
- ✅ **Multi-Browser Support** – Chrome, Edge, Firefox
- ✅ **Explicit Waits** – WebDriverWait used for reliable test execution
- ✅ **UI/UX Validation** – Font consistency, product alignment, mobile responsive checks

---

## ▶️ How to Run

### Prerequisites
- Java JDK 17+
- Maven 3.x
- Chrome / Edge / Firefox browser installed
- Eclipse IDE or IntelliJ IDEA

### Steps

**1. Clone the repository**
```bash
git clone https://github.com/Raghulrasu98/PROJECT-2.1.git
cd PROJECT-2.1
```

**2. Install dependencies**
```bash
mvn clean install -DskipTests
```

**3. Run all tests**
```bash
mvn test
```

**4. Run via TestNG XML** *(in Eclipse)*
- Right-click `testng.xml` → Run As → TestNG Suite

---

## 📊 Test Report

After execution, the HTML report is generated at:
```
src/test/resources/testoutput/demoblaze.html
```
Open in any browser to view detailed pass/fail results with logs and categories.

---

## 📸 Screenshots

Screenshots are automatically saved to the `/Screenshot` folder with timestamps during test execution.

| Test | Screenshot |
|---|---|
| Login Validation | `loginValidation2026-03-06_00-42-19.png` |
| Signup Validation | `signupValidation2026-03-06_00-42-56.png` |
| Add to Cart | `addProductToCart2026-03-06_00-44-42.png` |
| Order Confirmation | `ConformationPopup2026-03-06_00-46-15.png` |
| UI Alignment Check | `verifyProductAlignment2026-03-06_00-48-26.png` |

---

## 📁 Excel Test Data Structure

File: `src/test/resources/Data/DemoblazeData.xlsx`

| Sheet | Columns |
|---|---|
| Login | Username, Password, TestType, Expected |
| Signup | Username, Password, TestType, Expected |
| Cart | Username, Password, Product1, Product2 |
| LoginDetails | Username, Password |

---

## 👨‍💻 Author

**Raghul R**
- 📧 rrraghulrajendran@gmail.com
- 📞 9942264438
- 🎓 GUVI Certified – Java Automation Testing
- 📍 Chennai, Tamil Nadu

---

## 📜 License

This project is created for learning and portfolio purposes.
