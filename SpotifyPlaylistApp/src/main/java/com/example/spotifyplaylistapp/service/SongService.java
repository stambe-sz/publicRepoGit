package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.binding.SongBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.service.SongServiceModel;
import com.example.spotifyplaylistapp.repository.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {
    private final ModelMapper modelMapper;
    private final SongRepository songRepository;
    private final StyleService styleService;
    private final HttpSession httpSession;

    public SongService(ModelMapper modelMapper, SongRepository songRepository, StyleService styleService, HttpSession httpSession) {
        this.modelMapper = modelMapper;
        this.songRepository = songRepository;
        this.styleService = styleService;
        this.httpSession = httpSession;
    }

    public void addSong(SongServiceModel songServiceModel) {
        Song song = modelMapper.map(songServiceModel,Song.class);
        song.setStyle(styleService
                .findByStyleName(songServiceModel.getStyle()));
        songRepository.save(song);
    }

    public List<SongBindingModel> findSongByGenre(Style style) {

        return this.songRepository.findByStyle(style)
                .stream()
                .map(this::mapSong)
                .collect(Collectors.toList());
    }

    private SongBindingModel mapSong(Song song){
        SongBindingModel songBindingModel = new SongBindingModel(song.getId(),
                song.getPerformer(),
                song.getTitle(),
                song.getDuration(),
                song.getStyle().getName());

        return songBindingModel;
    }

    public List<SongBindingModel> findByStyle(Style style) {
        return this.songRepository.findByStyle(style);
    }
}
