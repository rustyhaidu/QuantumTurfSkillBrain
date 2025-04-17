package org.quantumturf.playground;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CollectionsMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("4312fas", "Valoarea 2");
        map.put("4312fas", "Valoarea 3");
        map.put("4312fas2", "Valoarea 4");
//        System.out.println(map.get("4312fas"));
//        System.out.println(map.get("4312fas2"));

        for (Map.Entry<String, String> valCrt : map.entrySet()) {
            System.out.print(valCrt.getKey() + ": ");
            System.out.println(valCrt.getValue());
        }
    }
}
