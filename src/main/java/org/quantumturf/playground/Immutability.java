package org.quantumturf.playground;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Immutability {
    public static void main(String[] args) {
        String a = "tree";
        a = a + "s";

        int[] arr = {2, 3, 4};
        int[] arr2 = new int[4];

        List<String> abc = List.of("abc", "bac");
        //abc.add("cba");
        abc.remove("abc");

        System.out.println(abc.get(1));


    }
}
