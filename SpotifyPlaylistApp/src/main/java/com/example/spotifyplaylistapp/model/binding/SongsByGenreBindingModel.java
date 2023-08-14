package com.example.spotifyplaylistapp.model.binding;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
public class SongsByGenreBindingModel {

    private List<SongBindingModel> popSongs;
    private List<SongBindingModel> rockSongs;
    private List<SongBindingModel> jazzSongs;
}
