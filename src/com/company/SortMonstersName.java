package com.company;

import java.util.Comparator;

/**
 * Sorts monsters by name
 */
public class SortMonstersName implements Comparator<Monsters> {

    /**
     * Checks all the monsters names
     *
     * @param m1 Checks the first name
     * @param m2 Checks the second name
     * @return Sorts in alphabetic order
     */
    public int compare(Monsters m1, Monsters m2) {
        return m1.name.compareTo(m2.name);
    }
}
