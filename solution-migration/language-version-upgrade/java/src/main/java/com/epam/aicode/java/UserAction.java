package com.epam.aicode.java;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserAction {

    public String getNormalizedNames(List<String> names) {
        List<String> normalizedNames = new ArrayList<>();

        for (String name : names) {
            if (name != null && !name.trim().isEmpty()) {
                name = name.trim();
                name = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
                normalizedNames.add(name);
            }
        }
        Collections.sort(normalizedNames);

        StringBuilder normalizedNameString = new StringBuilder();
        for (int i = 0; i < normalizedNames.size(); i++) {
            normalizedNameString.append(normalizedNames.get(i));
            if (i != normalizedNames.size() - 1) {
                normalizedNameString.append("-");
            }
        }
        return normalizedNameString.toString();
    }
}
