package com.pogodin;

import java.util.PriorityQueue;

public class NearlySortedArray {

    /**
     * Given a nearly sorted array where each element is at most k positions away from its correct sorted position, sort the array efficiently.
     *
     * [3,2,1] is the array with distance of 2 elements
     * [3,4,1,2,5] is the array with distance of 2 as well: [1,2,3,4,5]
     */
    public int[] nearlySortedArray(int[] arr, int distance) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // as original task suggests that [2,1,0] is the array with moved element to a distance of 2
        // zero is 2 elements left from it's location, needs to be collected at the start
        // in other cases, the distance could be larger than array
        distance = arr.length > distance
                ? distance + 1
                : arr.length;

        for (int i = 0; i < distance; i++) {
            pq.add(arr[i]);
        }

        int nextCandidate = distance;
        int index = 0;
        while (!pq.isEmpty()) {
            arr[index++] = pq.poll();
            if (nextCandidate < arr.length) {
                pq.add(arr[nextCandidate++]);
            }
        }
        return arr;
    }
}
