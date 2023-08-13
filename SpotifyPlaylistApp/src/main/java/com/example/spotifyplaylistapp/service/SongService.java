package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.service.SongServiceModel;
import com.example.spotifyplaylistapp.repository.SongRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

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
}
