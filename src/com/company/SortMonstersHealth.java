package com.company;

import java.util.Comparator;

/**
 * Sorts monsters by health
 */
public class SortMonstersHealth implements Comparator<Monsters> {

    /**
     * Checks all the monsters health
     *
     * @param m1 Checks the first health
     * @param m2 Checks the second health
     * @return Sorts health from lowest to highest
     */
    public int compare(Monsters m1, Monsters m2) {
        return m1.health - m2.health;
    }
}
