package com.jgm.app.domain.vo;

import java.util.Arrays;

public enum Operation {

    ADDITION("addition"),
    SUBTRACTION("subtraction")
    ;

    private final String displayName;

    Operation(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Operation fromDisplayName(String name) {

        return Arrays.stream(Operation.values())
                .filter(enumValue -> enumValue.displayName.equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

}
