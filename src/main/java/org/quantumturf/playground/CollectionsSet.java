package org.quantumturf.playground;

import java.util.HashSet;
import java.util.Set;

public class CollectionsSet {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("banana");
        set.add("portocale");
        set.add("mere");
        set.add("banana");

        for (String set1 : set) {
            System.out.println(set1);
        }
    }
}
