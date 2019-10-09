package com.company;

import java.util.Comparator;

public class SortMonstersName implements Comparator<Monsters> {

    public int compare(Monsters m1, Monsters m2){
        return m1.name.compareTo(m2.name);
    }
}
