package com.pogodin;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class SetWithGetRandomTest {

    private SetWithGetRandom setWithGetRandom;

    @BeforeEach
    public void setUp() {
        setWithGetRandom = new SetWithGetRandom();
    }

    @Test
    public void testInsert_NewElement() {
        assertTrue(setWithGetRandom.insert(1), "Inserting a new element should return true");
        assertTrue(setWithGetRandom.insert(2), "Inserting a new element should return true");
    }

    @Test
    public void testInsert_DuplicateElement() {
        assertTrue(setWithGetRandom.insert(1), "First insert should succeed");
        assertFalse(setWithGetRandom.insert(1), "Inserting a duplicate element should return false");
    }

    @Test
    public void testDelete_ExistingElement() {
        setWithGetRandom.insert(1);
        assertTrue(setWithGetRandom.delete(1), "Deleting an existing element should return true");
    }

    @Test
    public void testDelete_NonExistingElement() {
        assertFalse(setWithGetRandom.delete(1), "Deleting a non-existing element should return false");
    }

    @Test
    public void testGetRandom() {
        setWithGetRandom.insert(1);
        setWithGetRandom.insert(2);
        setWithGetRandom.insert(3);

        Set<Integer> possibleValues = new HashSet<>();
        possibleValues.add(1);
        possibleValues.add(2);
        possibleValues.add(3);

        int randomValue = setWithGetRandom.getRandom();
        assertTrue(possibleValues.contains(randomValue), "Random value should be from the inserted elements");
    }

    @Test
    public void testGetRandom_EmptySet() {
        Exception exception = assertThrows(IllegalStateException.class, setWithGetRandom::getRandom);
        assertEquals("nope, empty collection", exception.getMessage(), "Should throw exception when calling getRandom on empty set");
    }

    @Test
    public void testDeleteAndGetRandom() {
        setWithGetRandom.insert(1);
        setWithGetRandom.insert(2);
        setWithGetRandom.delete(1);

        assertEquals(2, setWithGetRandom.getRandom(), "After deleting, the only element left should be the one returned");
    }

    @Test
    public void testInsertDeleteRandomSequence() {
        assertTrue(setWithGetRandom.insert(10), "Insert 10");
        assertTrue(setWithGetRandom.insert(20), "Insert 20");
        assertTrue(setWithGetRandom.delete(10), "Delete 10");
        assertFalse(setWithGetRandom.delete(10), "Delete 10 again should return false");
        assertTrue(setWithGetRandom.insert(30), "Insert 30");

        Set<Integer> possibleValues = new HashSet<>();
        possibleValues.add(20);
        possibleValues.add(30);

        int randomValue = setWithGetRandom.getRandom();
        assertTrue(possibleValues.contains(randomValue), "Random value should be either 20 or 30");
    }

    @Test
    public void testGetRandomMultipleElements() {
        for (int i = 1; i <= 100; i++) {
            setWithGetRandom.insert(i);
        }

        // Ensures that the random function gives a valid element
        int randomValue = setWithGetRandom.getRandom();
        assertTrue(randomValue >= 1 && randomValue <= 100, "Random value should be between 1 and 100");
    }

    @Test
    public void testEvenRandomizationDistribution() {
        for (int i = 0; i < 100; i++) {
            setWithGetRandom.insert(i);
        }

        int[] counters = new int[100];

        for (int i = 0; i < 10000; i++) {
            counters[setWithGetRandom.getRandom()]++;
        }

        for (int i = 0; i < 100; i++) {
            assertTrue(counters[i] > 50,
                    String.format("expected 100 times per each value, giving less than 50 times is unlikely event." +
                            " Considered uneven distribution. Failed at index %s with value %s", i, counters[i]));
        }

    }

}