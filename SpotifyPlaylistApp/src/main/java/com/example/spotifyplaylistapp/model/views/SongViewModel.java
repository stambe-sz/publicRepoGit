package com.example.spotifyplaylistapp.model.views;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SongViewModel {
    private Long id;
    private String performer;
    private String title;
    private Integer duration;
}
