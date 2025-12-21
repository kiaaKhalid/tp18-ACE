# Code Quality Utilities - Contributing Guide

Thank you for considering contributing to Code Quality Utilities!

## Development Setup

1. **Prerequisites**
   - JDK 17 or higher
   - Maven 3.6 or higher
   - Git

2. **Clone and Build**
   ```bash
   git clone https://github.com/kiaaKhalid/tp18-ACE.git
   cd tp18-ACE
   mvn clean install
   ```

## Code Standards

### Java Code Style
- Follow standard Java naming conventions
- Use descriptive variable and method names
- Add comprehensive JavaDoc for all public classes and methods
- Keep methods focused and single-purpose

### Testing Requirements
- Write unit tests for all new functionality
- Maintain minimum code coverage: 85% instruction, 80% branch
- Use descriptive test method names
- Include assertion messages for clarity

### Commit Messages
- Use clear, descriptive commit messages
- Start with a verb in imperative mood (Add, Fix, Update, etc.)
- Include details in the commit body when necessary

## Pull Request Process

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Make your changes
4. Run tests: `mvn test`
5. Verify coverage: `mvn verify`
6. Commit your changes with clear messages
7. Push to your fork
8. Open a Pull Request

## Code Review

All submissions require review before merging. We will:
- Check code quality and style
- Verify test coverage
- Ensure documentation is complete
- Test functionality

## Questions?

Feel free to open an issue for any questions or concerns.

---
Maintained by KiAA Khalid
