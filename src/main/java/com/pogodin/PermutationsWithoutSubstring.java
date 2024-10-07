package com.pogodin;

import java.util.HashSet;
import java.util.Set;

/**
 * find all possible permutations in the string that do not contain given string
 */
public class PermutationsWithoutSubstring {

    /**
     * time complexity: O(n!) for the permutations + O(n) per each permutation to test the exclusion
     * total time complexity: O(n! x n)
     *
     * space complexity O(n!) to store the data
     */
    Set<String> permutationsWithoutGivenString(String s, String exclude) {
        Set<String> perms = new HashSet<>();
        permutations(new StringBuilder(s), 0, perms, exclude);
        return perms;
    }

    void permutations(StringBuilder sb, int idx, Set<String> perms, String exclude) {
        if (idx == sb.length() - 1) {
            if (exclude.isEmpty() || !sb.toString().contains(exclude)) {
                perms.add(sb.toString());
            }
            return;
        }

        for (int i = idx; i < sb.length(); i++) {
            // swap
            swap(sb, idx, i);

            permutations(sb, idx + 1, perms, exclude);

            //swap back
            swap(sb, idx, i);
        }
    }

    private void swap(StringBuilder sb, int i, int j) {
        char temp = sb.charAt(i);
        sb.setCharAt(i, sb.charAt(j));
        sb.setCharAt(j, temp);
    }
}
