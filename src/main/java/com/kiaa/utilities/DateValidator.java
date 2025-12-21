package com.kiaa.utilities;

/**
 * Utility class for date-related validation operations.
 * <p>
 * This class provides methods to validate various date-related properties
 * such as leap years according to the Gregorian calendar rules.
 * </p>
 *
 * @author KiAA Khalid
 * @version 1.0.0
 * @since 2025-12-21
 */
public class DateValidator {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private DateValidator() {
        throw new UnsupportedOperationException("Utility class cannot be instantiated");
    }

    /**
     * Validates whether a given year is a leap year according to the Gregorian
     * calendar.
     * <p>
     * A year is a leap year if:
     * <ul>
     * <li>It is divisible by 4 AND not divisible by 100, OR</li>
     * <li>It is divisible by 400</li>
     * </ul>
     * </p>
     *
     * @param yearValue the year to validate (can be negative for BCE years)
     * @return {@code true} if the year is a leap year, {@code false} otherwise
     * 
     * @example
     * 
     *          <pre>
     *          DateValidator.validateLeapYear(2000); // returns true (divisible by 400)
     *          DateValidator.validateLeapYear(1900); // returns false (divisible by 100 but not 400)
     *          DateValidator.validateLeapYear(2024); // returns true (divisible by 4 but not 100)
     *          DateValidator.validateLeapYear(2023); // returns false (not divisible by 4)
     *          </pre>
     */
    public static boolean validateLeapYear(int yearValue) {
        // Check if year is not divisible by 4 - cannot be a leap year
        if (yearValue % 4 != 0) {
            return false;
        }

        // Year is divisible by 4, check if it's a century year
        if (yearValue % 100 != 0) {
            return true;
        }

        // Century year - must be divisible by 400 to be a leap year
        return yearValue % 400 == 0;
    }
}
