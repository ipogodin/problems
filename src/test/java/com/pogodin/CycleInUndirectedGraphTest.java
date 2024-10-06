package com.pogodin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class CycleInUndirectedGraphTest {

    @Test
    public void checkOddCycle() {
        Assertions.assertFalse(new CycleInUndirectedGraph().isEvenCycle(getOddCycle(), 3));
    }

    private List<List<Integer>> getOddCycle() {
        List<List<Integer>> oddCycleGraph = new ArrayList<>();

        // Initialize the list for each node
        for (int i = 0; i < 3; i++) {
            oddCycleGraph.add(new ArrayList<>());
        }

        // Add edges to form a 3-cycle (odd-length cycle)
        oddCycleGraph.get(0).add(1);  // 0 - 1
        oddCycleGraph.get(1).add(0);  // 1 - 0
        oddCycleGraph.get(1).add(2);  // 1 - 2
        oddCycleGraph.get(2).add(1);  // 2 - 1
        oddCycleGraph.get(2).add(0);  // 2 - 0
        oddCycleGraph.get(0).add(2);  // 0 - 2

        return oddCycleGraph;
    }

    @Test
    public void checkEvenCycle() {
        Assertions.assertTrue(new CycleInUndirectedGraph().isEvenCycle(getEvenGraph(), 4));
    }

    private List<List<Integer>> getEvenGraph() {
        List<List<Integer>> evenCycleGraph = new ArrayList<>();

        // Initialize the list for each node
        for (int i = 0; i < 4; i++) {
            evenCycleGraph.add(new ArrayList<>());
        }

        // Add edges to form a 4-cycle (even-length cycle)
        evenCycleGraph.get(0).add(1);  // 0 - 1
        evenCycleGraph.get(1).add(0);  // 1 - 0
        evenCycleGraph.get(1).add(2);  // 1 - 2
        evenCycleGraph.get(2).add(1);  // 2 - 1
        evenCycleGraph.get(2).add(3);  // 2 - 3
        evenCycleGraph.get(3).add(2);  // 3 - 2
        evenCycleGraph.get(3).add(0);  // 3 - 0
        evenCycleGraph.get(0).add(3);  // 0 - 3

        return evenCycleGraph;
    }

}