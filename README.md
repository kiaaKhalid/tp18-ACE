# Code Quality Utilities

[![Java](https://img.shields.io/badge/Java-17-orange.svg)](https://www.oracle.com/java/)
[![Maven](https://img.shields.io/badge/Maven-3.6+-blue.svg)](https://maven.apache.org/)
[![JUnit](https://img.shields.io/badge/JUnit-5.11.2-green.svg)](https://junit.org/junit5/)
[![JaCoCo](https://img.shields.io/badge/JaCoCo-0.8.12-red.svg)](https://www.jacoco.org/)

A professional Java utility library providing robust date validation and text processing capabilities with comprehensive test coverage and integrated code quality analysis.

## 📋 Features

### Date Validation
- **Leap Year Validation**: Accurate leap year calculation following Gregorian calendar rules
- Handles edge cases including century years and years divisible by 400

### Text Processing
- **Safe Substring Extraction**: Boundary-safe substring extraction with automatic index adjustment
- **Palindrome Detection**: Case-insensitive palindrome checking with whitespace normalization
- Comprehensive null-safety and input validation

## 🚀 Prerequisites

- **Java Development Kit (JDK)**: Version 17 or higher
- **Apache Maven**: Version 3.6 or higher
- **Git**: For version control

## 📦 Installation

### Clone the Repository

```bash
git clone https://github.com/kiaaKhalid/tp18-ACE.git
cd tp18-ACE
```

### Build the Project

```bash
mvn clean install
```

This command will:
- Compile the source code
- Run all unit tests
- Generate JaCoCo code coverage reports
- Verify code quality thresholds

## 💻 Usage

### Date Validation Example

```java
import com.kiaa.utilities.DateValidator;

public class Example {
    public static void main(String[] args) {
        // Check if a year is a leap year
        boolean isLeap2024 = DateValidator.validateLeapYear(2024);
        System.out.println("Is 2024 a leap year? " + isLeap2024); // true
        
        boolean isLeap1900 = DateValidator.validateLeapYear(1900);
        System.out.println("Is 1900 a leap year? " + isLeap1900); // false
        
        boolean isLeap2000 = DateValidator.validateLeapYear(2000);
        System.out.println("Is 2000 a leap year? " + isLeap2000); // true
    }
}
```

### Text Processing Example

```java
import com.kiaa.utilities.TextProcessor;

public class Example {
    public static void main(String[] args) {
        TextProcessor processor = new TextProcessor();
        
        // Safe substring extraction
        String result1 = processor.extractSubstring("Hello World", 0, 5);
        System.out.println(result1); // "Hello"
        
        String result2 = processor.extractSubstring("Hello World", -5, 5);
        System.out.println(result2); // "Hello" (negative index adjusted to 0)
        
        // Palindrome detection
        boolean isPalindrome1 = processor.isPalindromeIgnoringCase("Kayak");
        System.out.println("Is 'Kayak' a palindrome? " + isPalindrome1); // true
        
        boolean isPalindrome2 = processor.isPalindromeIgnoringCase("nurses run");
        System.out.println("Is 'nurses run' a palindrome? " + isPalindrome2); // true
    }
}
```

## 🧪 Running Tests

### Execute All Tests

```bash
mvn test
```

### Run Tests with Coverage Report

```bash
mvn verify
```

The JaCoCo coverage report will be generated at:
```
target/site/jacoco/index.html
```

### Coverage Thresholds

The project enforces the following minimum coverage requirements:
- **Instruction Coverage**: 85%
- **Branch Coverage**: 80%

## 📊 Code Quality

### JaCoCo Code Coverage

This project uses JaCoCo for comprehensive code coverage analysis. After running `mvn verify`, you can view detailed coverage reports including:
- Line coverage
- Branch coverage
- Method coverage
- Class coverage

### SonarQube Integration

The project is configured for SonarQube analysis to ensure:
- Code quality standards
- Security vulnerability detection
- Code smell identification
- Technical debt tracking

To run SonarQube analysis locally:

```bash
mvn clean verify sonar:sonar \
  -Dsonar.projectKey=code-quality-utilities \
  -Dsonar.host.url=http://localhost:9000 \
  -Dsonar.login=your-token
```

## 📁 Project Structure

```
code-quality-utilities/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── kiaa/
│   │               └── utilities/
│   │                   ├── DateValidator.java
│   │                   └── TextProcessor.java
│   └── test/
│       └── java/
│           └── com/
│               └── kiaa/
│                   └── utilities/
│                       ├── DateValidatorTest.java
│                       └── TextProcessorTest.java
├── pom.xml
└── README.md
```

## 🛠️ Technologies Used

- **Java 17**: Modern Java features and performance improvements
- **JUnit 5**: Comprehensive unit testing framework
- **Mockito**: Mocking framework for unit tests
- **JaCoCo**: Code coverage analysis tool
- **Maven**: Build automation and dependency management
- **SonarQube**: Continuous code quality inspection

## 👨‍💻 Author

**KiAA Khalid**
- GitHub: [@kiaaKhalid](https://github.com/kiaaKhalid)
- Email: kiaa.khalid@example.com

## 📄 License

This project is licensed under the MIT License - see the LICENSE file for details.

## 🤝 Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

1. Fork the project
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## 📝 Changelog

### Version 1.0.0-SNAPSHOT
- Initial release
- Date validation utilities with leap year calculation
- Text processing utilities with safe substring extraction
- Palindrome detection with case and whitespace normalization
- Comprehensive unit tests with >85% code coverage
- JaCoCo integration for coverage reporting
- SonarQube integration for code quality analysis

---

**Note**: This project demonstrates best practices in Java development including comprehensive documentation, thorough testing, and continuous code quality monitoring.
