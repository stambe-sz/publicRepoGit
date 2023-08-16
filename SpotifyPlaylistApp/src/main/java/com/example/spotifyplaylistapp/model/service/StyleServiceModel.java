package com.example.spotifyplaylistapp.model.service;

import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@Getter
@Setter
@NoArgsConstructor
public class StyleServiceModel {

    private StyleNameEnum name;

    private String description;
}
