package com.kiaa.utilities;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for {@link TextProcessor}.
 * <p>
 * This class contains comprehensive unit tests for text processing operations
 * including substring extraction with boundary validation and palindrome
 * checking.
 * </p>
 *
 * @author KiAA Khalid
 * @version 1.0.0
 * @since 2025-12-21
 */
@DisplayName("TextProcessor - Boundary and Logic Tests")
class TextProcessorTest {

    private final TextProcessor textProcessor = new TextProcessor();

    /**
     * Tests that {@link TextProcessor#extractSubstring(String, int, int)} throws
     * an IllegalArgumentException when the input text is null.
     */
    @Test
    void testExtractSubstring_NullInput_ThrowsException() {
        assertThrows(IllegalArgumentException.class,
                () -> textProcessor.extractSubstring(null, 0, 1),
                "Should throw IllegalArgumentException when input text is null");
    }

    /**
     * Tests the boundary handling of
     * {@link TextProcessor#extractSubstring(String, int, int)}.
     * <p>
     * This test verifies:
     * <ul>
     * <li>Equal start and end indices return an empty string</li>
     * <li>End index exceeding text length is adjusted to text length</li>
     * <li>Negative start index is adjusted to 0</li>
     * <li>Start index greater than end index returns an empty string</li>
     * </ul>
     * </p>
     */
    @Test
    void testExtractSubstring_BoundaryConditions() {
        // Test equal start and end indices
        assertEquals("", textProcessor.extractSubstring("abc", 2, 2),
                "Equal start and end indices should return empty string");

        // Test end index exceeding text length
        assertEquals("bc", textProcessor.extractSubstring("abc", 1, 5),
                "End index exceeding length should be adjusted to text length");

        // Test negative start index
        assertEquals("ab", textProcessor.extractSubstring("abc", -10, 2),
                "Negative start index should be adjusted to 0");

        // Test start index greater than end index
        assertEquals("", textProcessor.extractSubstring("abc", 3, 0),
                "Start index >= end index should return empty string");
    }

    /**
     * Tests basic palindrome detection with
     * {@link TextProcessor#isPalindromeIgnoringCase(String)}.
     * <p>
     * This test verifies:
     * <ul>
     * <li>Single-word palindromes are correctly identified</li>
     * <li>Multi-word palindromes with spaces are correctly identified</li>
     * <li>Non-palindromes are correctly rejected</li>
     * <li>Null input returns false</li>
     * </ul>
     * </p>
     */
    @Test
    void testIsPalindromeIgnoringCase_BasicCases() {
        // Test single-word palindrome with mixed case
        assertTrue(textProcessor.isPalindromeIgnoringCase("Kayak"),
                "Should recognize 'Kayak' as a palindrome");

        // Test multi-word palindrome with spaces
        assertTrue(textProcessor.isPalindromeIgnoringCase("n u r s e s r u n"),
                "Should recognize 'nurses run' as a palindrome ignoring spaces");

        // Test non-palindrome
        assertFalse(textProcessor.isPalindromeIgnoringCase("abc"),
                "Should recognize 'abc' as not a palindrome");

        // Test null input
        assertFalse(textProcessor.isPalindromeIgnoringCase(null),
                "Should return false for null input");
    }
}
