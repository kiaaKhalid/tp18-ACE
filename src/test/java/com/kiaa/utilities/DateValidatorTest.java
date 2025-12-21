package com.kiaa.utilities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link DateValidator}.
 * <p>
 * This class contains unit tests to verify the correctness of date validation
 * operations, particularly leap year validation according to Gregorian calendar
 * rules.
 * </p>
 *
 * @author KiAA Khalid
 * @version 1.0.0
 * @since 2025-12-21
 */
class DateValidatorTest {

    /**
     * Tests the {@link DateValidator#validateLeapYear(int)} method with various
     * scenarios.
     * <p>
     * This test verifies:
     * <ul>
     * <li>Years divisible by 400 are leap years (e.g., 2000)</li>
     * <li>Years divisible by 100 but not by 400 are not leap years (e.g.,
     * 1900)</li>
     * <li>Years divisible by 4 but not by 100 are leap years (e.g., 2024)</li>
     * <li>Years not divisible by 4 are not leap years (e.g., 2023)</li>
     * </ul>
     * </p>
     */
    @Test
    void testValidateLeapYear_VariousScenarios() {
        // Test year divisible by 400 - should be a leap year
        assertTrue(DateValidator.validateLeapYear(2000),
                "Year 2000 should be a leap year (divisible by 400)");

        // Test year divisible by 100 but not by 400 - should not be a leap year
        assertFalse(DateValidator.validateLeapYear(1900),
                "Year 1900 should not be a leap year (divisible by 100 but not by 400)");

        // Test year divisible by 4 but not by 100 - should be a leap year
        assertTrue(DateValidator.validateLeapYear(2024),
                "Year 2024 should be a leap year (divisible by 4 but not by 100)");

        // Test year not divisible by 4 - should not be a leap year
        assertFalse(DateValidator.validateLeapYear(2023),
                "Year 2023 should not be a leap year (not divisible by 4)");
    }
}
