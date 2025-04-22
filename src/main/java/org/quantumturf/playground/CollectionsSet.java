package org.quantumturf.playground;

import java.util.*;

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

        Collection<String> collection1 = new ArrayList<>();
        Collection<String> collection2 = new HashSet<>();
        Collection<String> collection3 = new LinkedList<>();

        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new WeakHashMap<>();
        Map<String, String> map2 = new TreeMap<>();


    }
}
