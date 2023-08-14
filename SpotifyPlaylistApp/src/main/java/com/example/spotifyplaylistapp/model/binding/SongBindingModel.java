package com.example.spotifyplaylistapp.model.binding;

import com.example.spotifyplaylistapp.model.entity.Style;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SongBindingModel {
    private Long id;
    private String performer;
    private String title;
    private Integer duration;
    private Style style;
}
