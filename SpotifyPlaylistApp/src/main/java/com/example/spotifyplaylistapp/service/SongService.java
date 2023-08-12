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
    private final HttpSession httpSession;

    public SongService(ModelMapper modelMapper, SongRepository songRepository, HttpSession httpSession) {
        this.modelMapper = modelMapper;
        this.songRepository = songRepository;
        this.httpSession = httpSession;
    }

    public void addSong(SongServiceModel songServiceModel) {
        Song song = modelMapper.map(songServiceModel,Song.class);
    }
}
