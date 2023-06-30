package com.sda.QuickBite.enums;

public enum Role {

    ROLE_BUYER("BUYER"),
    ROLE_SELLER("SELLER");

    public final String label;

    Role(String label) {
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
}
