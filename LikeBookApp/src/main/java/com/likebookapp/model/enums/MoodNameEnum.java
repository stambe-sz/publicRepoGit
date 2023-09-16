package com.likebookapp.model.enums;

public enum MoodNameEnum {
    HAPPY("Happy"),
    SAD("Sad"),
    INSPIRED("Inspired");


    private final String value;
    MoodNameEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
