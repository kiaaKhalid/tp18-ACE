package com.kiaa.utilities;

/**
 * Utility class for text processing and string manipulation operations.
 * <p>
 * This class provides various methods for safe string operations including
 * substring extraction with boundary validation and palindrome checking.
 * </p>
 *
 * @author KiAA Khalid
 * @version 1.0.0
 * @since 2025-12-21
 */
public class TextProcessor {

    /**
     * Extracts a substring from the input text with safe boundary handling.
     * <p>
     * This method ensures safe substring extraction by applying the following
     * rules:
     * <ul>
     * <li>If startIndex is negative, it is adjusted to 0</li>
     * <li>If endIndex exceeds the text length, it is adjusted to the text
     * length</li>
     * <li>If startIndex is greater than or equal to endIndex, an empty string is
     * returned</li>
     * <li>If inputText is null, an IllegalArgumentException is thrown</li>
     * </ul>
     * </p>
     *
     * @param inputText  the text from which to extract the substring
     * @param startIndex the starting index (inclusive) of the substring
     * @param endIndex   the ending index (exclusive) of the substring
     * @return the extracted substring, or an empty string if indices are invalid
     * @throws IllegalArgumentException if inputText is null
     * 
     * @example
     * 
     *          <pre>
     *          TextProcessor processor = new TextProcessor();
     *          processor.extractSubstring("Hello World", 0, 5); // returns "Hello"
     *          processor.extractSubstring("Hello World", -5, 5); // returns "Hello" (startIndex adjusted to 0)
     *          processor.extractSubstring("Hello World", 6, 100); // returns "World" (endIndex adjusted to 11)
     *          processor.extractSubstring("Hello World", 5, 5); // returns "" (startIndex >= endIndex)
     *          </pre>
     */
    public String extractSubstring(String inputText, int startIndex, int endIndex) {
        if (inputText == null) {
            throw new IllegalArgumentException("Input text cannot be null");
        }

        int textLength = inputText.length();

        // Adjust start index if it's negative
        int adjustedStartIndex = startIndex < 0 ? 0 : startIndex;

        // Adjust end index if it exceeds text length
        int adjustedEndIndex = endIndex > textLength ? textLength : endIndex;

        // Return empty string if start is greater than or equal to end
        if (adjustedStartIndex >= adjustedEndIndex) {
            return "";
        }

        return inputText.substring(adjustedStartIndex, adjustedEndIndex);
    }

    /**
     * Checks whether a given text is a palindrome, ignoring case and whitespace.
     * <p>
     * A palindrome is a word, phrase, or sequence that reads the same backward as
     * forward.
     * This method normalizes the input by removing all whitespace and converting to
     * lowercase
     * before performing the palindrome check.
     * </p>
     *
     * @param inputText the text to check for palindrome property
     * @return {@code true} if the text is a palindrome (ignoring case and spaces),
     *         {@code false} otherwise or if inputText is null
     * 
     * @example
     * 
     *          <pre>
     *          TextProcessor processor = new TextProcessor();
     *          processor.isPalindromeIgnoringCase("Kayak"); // returns true
     *          processor.isPalindromeIgnoringCase("A man a plan a canal Panama"); // returns true
     *          processor.isPalindromeIgnoringCase("nurses run"); // returns true
     *          processor.isPalindromeIgnoringCase("Hello"); // returns false
     *          processor.isPalindromeIgnoringCase(null); // returns false
     *          </pre>
     */
    public boolean isPalindromeIgnoringCase(String inputText) {
        if (inputText == null) {
            return false;
        }

        // Normalize the text: remove whitespace and convert to lowercase
        String normalizedText = inputText.replaceAll("\\s+", "").toLowerCase();

        int leftIndex = 0;
        int rightIndex = normalizedText.length() - 1;

        // Compare characters from both ends moving towards the center
        while (leftIndex < rightIndex) {
            if (normalizedText.charAt(leftIndex) != normalizedText.charAt(rightIndex)) {
                return false;
            }
            leftIndex++;
            rightIndex--;
        }

        return true;
    }
}
