package com.pogodin;

import java.util.Arrays;
import java.util.Random;

/**
 *  Implement rand10 using rand7
 */
public class ImplementRand {

    private final Rand7 rand7 = new Rand7();
    public static void main(String[] args) {
        // this is the fast check
        // see tests
        ImplementRand pp = new ImplementRand();
        Rand7 rand = new Rand7();

        int[] counter = new int[12]; // + buffer for visuals
        for (int i = 0; i < 10000; i++) {
            counter[pp.rand10(rand)] ++;
        }

        System.out.println(Arrays.toString(counter));
    }

    /**
     * Time complexity for execution. Let's count the expected number of rand7 calls.
     * For the 1st rand probability of getting desired number from the first attempts: 5/7. For the 2nd: 6/7.
     * As we follow geometric distribution,
     * the expected number of trials would be: E = 1/Probability of "successful" initial call.
     * For the while method where we having the success for the first call: 5/7 and 6/7 for the second.
     * The average number of calls would be approximately 1/P + 1/P = 7/6 + 7/5 ~ 2.57
     * 2.57 rand7 calls per 1 rand10 call on average.
     *
     * The worst case scenario per call won't exceed 10 times per each while loop. However the large number of
     * calls will smoothen the overall number of calls, and we returning to the 2.57 calls for 1 rand10 call on average.
     *
     * @param rand returning 1-7 evenly distributed random number
     * @return 1-10 evenly distributed number randomly choosen
     */
    public int rand10(Rand7 rand) {
        int rand1 = rand.get();  // collecting numbers from 1-5
        int rand2 = rand.get();  // collecting numbers 1-6

        // generating rand1 until we getting number from 1 to 5
        // ignoring the cases with 6 and 7. Probability of this while loop to execute more than
        // 3 times would be (2/7)^3 which is quite low
        while(rand1 > 5) {
            rand1 = rand.get();
        }

        // generating rand2 until we getting number from 1 to 6
        // ignoring the cases with 7. Probability of this while loop to execute more than
        // 3 times would be (1/7)^3 which is quite low
        while(rand2 > 6) {
            rand2 = rand.get();
        }

        // if rand2 having 1-3 the output value would be: 1 - 5 generated by first rand: rand1
        // if rand2 having 4-6 the output value would be: 6 - 10 generated by first rand: rand1 plus 5
        // addon defined if we getting the first case: 0 or second case: 5
        int addon = rand2 < 4 ? 0 : 5;
        return rand1 + addon;
    }

    public int rand10() {
        return rand10(rand7);
    }


    static class Rand7 {
        private final Random rand = new Random();
        public int get() {
            return rand.nextInt(7) + 1;
        }
    }
}