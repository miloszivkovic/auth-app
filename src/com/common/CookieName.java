package com.common;

public enum CookieName {
    SESSION ("session");

    private final String name;

    CookieName(String name) {
        this.name = name;
    }

    public boolean equalsName(String otherName) {
        return name.equals(otherName);
    }

    public String toString() {
        return name;
    }
}
