package com.example.spotifyplaylistapp.model.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SongServiceModel {
    private Long id;
    private String performer;
    private String title;
    private LocalDate releaseDate;
    private Integer duration;

    private StyleNameEnum style;
    //private StyleNameEnum style;
}
