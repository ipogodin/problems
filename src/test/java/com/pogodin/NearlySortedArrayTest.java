package com.pogodin;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class NearlySortedArrayTest {
    @Test
    public void testNearlySortedArray_basicCase() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        int[] expected = {2, 3, 5, 6, 8, 9, 10};
        int distance = 3;

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }

    @Test
    public void testNearlySortedArray_alreadySorted() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {1, 2, 3, 4, 5};
        int[] expected = {1, 2, 3, 4, 5};
        int distance = 1;

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }

    @Test
    public void testNearlySortedArray_reverseSorted() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {10, 9, 8, 7, 6};
        int[] expected = {6, 7, 8, 9, 10};
        int distance = 4;

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }

    @Test
    public void testNearlySortedArray_singleElement() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {1};
        int[] expected = {1};
        int distance = 0;

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }

    @Test
    public void testNearlySortedArray_emptyArray() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {};
        int[] expected = {};
        int distance = 0;

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }

    @Test
    public void testNearlySortedArray_allSameElements() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {5, 5, 5, 5, 5};
        int[] expected = {5, 5, 5, 5, 5};
        int distance = 1;

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }

    @Test
    public void testNearlySortedArray_largeDistance() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {10, 9, 8, 7, 6};
        int[] expected = {6, 7, 8, 9, 10};
        int distance = 10; // distance larger than the size of the array

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }

    @Test
    public void testNearlySortedArray_zeroDistance() {
        NearlySortedArray sorter = new NearlySortedArray();
        int[] arr = {10, 9, 8, 7, 6};
        int[] expected = {10, 9, 8, 7, 6};
        int distance = 0; // no sorting should happen

        assertArrayEquals(expected, sorter.nearlySortedArray(arr, distance));
    }
}