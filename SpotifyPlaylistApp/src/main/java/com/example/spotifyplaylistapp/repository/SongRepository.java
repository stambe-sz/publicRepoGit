package com.example.spotifyplaylistapp.repository;

import com.example.spotifyplaylistapp.model.binding.SongBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.service.SongServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    //@Query("SELECT new com.example.spotifyplaylistapp.model.binding.SongBindingModel(s.id,s.performer,s.title,s.duration,s.style.name) FROM Song s WHERE s.style.name = :styleName")
    List<Song> findSongByStyleName(Style style);


}
