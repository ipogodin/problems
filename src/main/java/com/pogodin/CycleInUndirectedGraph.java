package com.pogodin;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

/**
 *  Given an undirected graph, determine if it contains a cycle of even length.
 */
public class CycleInUndirectedGraph {
    /**
     *
     * @param graph edges list. Index is the index of a node, list of integers is the edges between current vertices
     * @param nodes number of vertices
     * @return if the graph contains the cycle with the even number of vetices in a cycle
     */
    public boolean isEvenCycle(List<List<Integer>> graph, int nodes) {
        int [] color = new int[nodes];
        Arrays.fill(color, -1);

        for (int i = 0; i < nodes; i++) {
            if (color[i] == -1) {
                if (bfsCheckEvenCycle(graph, i, color)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * coloring uncolored nodes, checking the odd cycle
     * return false if adjacent nodes having different predefined colors
     * @return true if does not contain even nodes cycles
     */
    private boolean bfsCheckEvenCycle(List<List<Integer>> graph, int node, int[] color) {
        Queue<Pair> nodeQ = new ArrayDeque<>();
        nodeQ.offer(new Pair(node, -1));
        color[node] = 0;

        while(!nodeQ.isEmpty()) {
            Pair currNodeBlock = nodeQ.poll();
            int currNode = currNodeBlock.node;

            for (int child: graph.get(currNode)) {
                if (color[child] == -1) {
                    color[child] = 1 - color[currNode];
                    nodeQ.offer(new Pair(child, currNode));
                // avoiding calling 'backing' link to parent while checking the loop
                } else if (child != currNodeBlock.parent && color[child] != color[currNode]) {
                    return true;
                }
            }
        }
        return false;
    }

    static class Pair {
        int parent;
        int node;

        public Pair(int node, int parent) {
            this.parent = parent;
            this.node = node;
        }
    }




}
