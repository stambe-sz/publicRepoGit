package com.example.spotifyplaylistapp.model.enums;

public enum StyleNameEnum {
    POP ("Pop"),
    ROCK ("Rock"),
    JAZZ ("Jazz");


    private final String value;

    StyleNameEnum(String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }

}
