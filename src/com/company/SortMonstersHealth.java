package com.company;

import java.util.Comparator;

public class SortMonstersHealth implements Comparator<Monsters> {

    public int compare(Monsters m1, Monsters m2){
        return m1.health - m2.health;
    }
}
