package com.pogodin;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PermutationsWithoutSubstringTest {

    // Test for basic functionality
    @Test
    public void testPermutationsWithoutForbiddenSubstring() {
        String input = "abc";
        String forbiddenSubstring = "ab";
        Set<String> filteredPermutations = new PermutationsWithoutSubstring().permutationsWithoutGivenString(input, forbiddenSubstring);

        // Expected permutations that don't contain "ab"
        Set<String> expected = Set.of("acb", "bac", "bca", "cba");

        assertEquals(expected, filteredPermutations);
    }

    // Test with no forbidden substring (should return all permutations)
    @Test
    public void testPermutationsWithNoForbiddenSubstring() {
        String input = "abc";
        String forbiddenSubstring = "";  // No forbidden substring
        Set<String> filteredPermutations = new PermutationsWithoutSubstring().permutationsWithoutGivenString(input, forbiddenSubstring);

        // Expected permutations (all permutations should be returned)
        Set<String> expected = Set.of("abc", "acb", "bac", "bca", "cab", "cba");

        assertEquals(expected, filteredPermutations);
    }

    // Test with single character input (should return only one permutation)
    @Test
    public void testSingleCharacterInput() {
        String input = "a";
        String forbiddenSubstring = "b";  // Forbidden substring is irrelevant
        Set<String> filteredPermutations = new PermutationsWithoutSubstring().permutationsWithoutGivenString(input, forbiddenSubstring);

        // Expected permutations (only "a" should be returned)
        Set<String> expected = Set.of("a");

        assertEquals(expected, filteredPermutations);
    }

    // Test with input containing repeated characters
    @Test
    public void testRepeatedCharacters() {
        String input = "aab";
        String forbiddenSubstring = "aa";  // Forbidden substring "aa"
        Set<String> filteredPermutations = new PermutationsWithoutSubstring().permutationsWithoutGivenString(input, forbiddenSubstring);

        // Expected permutations (should exclude those containing "aa")
        Set<String> expected = Set.of("aba");

        assertEquals(expected, filteredPermutations);
    }

    // Test with empty input string (should return an empty set)
    @Test
    public void testEmptyInput() {
        String input = "";
        String forbiddenSubstring = "a";
        Set<String> filteredPermutations = new PermutationsWithoutSubstring().permutationsWithoutGivenString(input, forbiddenSubstring);

        // Expected result (empty set)
        Set<String> expected = Set.of();

        assertEquals(expected, filteredPermutations);
    }

    // Test when forbidden substring matches entire input (should return empty set)
    @Test
    public void testForbiddenSubstringMatchesEntireInput() {
        String input = "abc";
        String forbiddenSubstring = "abc";
        Set<String> filteredPermutations = new PermutationsWithoutSubstring().permutationsWithoutGivenString(input, forbiddenSubstring);

        // Expected result (no permutations should be allowed)
        Set<String> expected = Set.of("acb", "bac", "bca", "cab", "cba");

        assertEquals(expected, filteredPermutations);
    }

    // Test with longer forbidden substring than the input (should return all permutations)
    @Test
    public void testForbiddenSubstringLongerThanInput() {
        String input = "ab";
        String forbiddenSubstring = "abc";  // Forbidden substring is longer than the input
        Set<String> filteredPermutations = new PermutationsWithoutSubstring().permutationsWithoutGivenString(input, forbiddenSubstring);

        // Expected result (no permutations contain "abc", so all should be allowed)
        Set<String> expected = Set.of("ab", "ba");

        assertEquals(expected, filteredPermutations);
    }
}