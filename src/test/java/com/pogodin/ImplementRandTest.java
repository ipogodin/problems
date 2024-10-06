package com.pogodin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class ImplementRandTest {

    ImplementRand rand10 = new ImplementRand();
    @Test
    public void testRandValueExists() {
        Assertions.assertTrue(rand10.rand10() > 0, "less then 1 is not according to the initial task");
        Assertions.assertTrue(rand10.rand10() < 11, "larger than 10 is not according to the initial task");
    }

    @Test
    public void testRandDistribution() {
        int[] accumulator = new int[10];
        int cases = 10000;
        for (int i = 0; i < cases; i++) {
            accumulator[rand10.rand10() - 1]++;
        }

        Assertions.assertAll(() -> {
            for (int i = 0; i < 10; i++) {
                // the value appears twice less than it should
                if (accumulator[i] < cases / 20) {
                    throw new IllegalStateException(
                            "uneven distribution for "
                                    + i + ", value of arr is: "
                                    + Arrays.toString(accumulator));
                }
            }
        });
    }
}