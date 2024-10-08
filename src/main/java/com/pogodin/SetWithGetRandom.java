package com.pogodin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Design a data structure that supports insertion, deletion, and getting a random element in constant time.
 *
 * interface below for reference
 *
 * P.S. never place the non-public interface or class before the public class: this code is not prod-clean code
 * Also: modern development does not consider a single class contains additional non-nested or non-inner classes
 * except the public class that naming according to a .java filename
 */
interface SetWithRandom {
    boolean insert(int element);

    boolean delete(int element);

    int getRandom();
}
public class SetWithGetRandom implements SetWithRandom {
    Map<Integer, Integer> mainStorage = new HashMap<>();
    List<Integer> randomSelector = new ArrayList<>();

    Random rand = new Random();

    @Override
    public boolean insert(int element) {
        if(mainStorage.containsKey(element)) {
            return false;
        }
        mainStorage.put(element, randomSelector.size());
        randomSelector.add(element);
        return true;
    }

    @Override
    public boolean delete(int element) {
        if (!mainStorage.containsKey(element)) {
            return false;
        }
        int index = mainStorage.get(element);
        mainStorage.remove(element);
        if (randomSelector.size() > 1) {
            int lastElemValue = randomSelector.get(randomSelector.size() - 1);
            randomSelector.set(index, lastElemValue);
            mainStorage.put(lastElemValue, index);
        }
        randomSelector.remove(randomSelector.size() - 1);

        return true;
    }

    @Override
    public int getRandom() {
        if (randomSelector.isEmpty()) {
            throw new IllegalStateException("nope, empty collection");
        }
        return randomSelector.get(rand.nextInt(randomSelector.size()));
    }
}



