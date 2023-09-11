package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.binding.SongBindingModel;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.service.SongServiceModel;
import com.example.spotifyplaylistapp.model.service.StyleServiceModel;
import com.example.spotifyplaylistapp.model.views.SongViewModel;
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
        this.songRepository.save(this.mapSong(songServiceModel));
    }

    public List<SongViewModel> findSongByGenre(Style style) {

        return this.songRepository.findSongByStyle(style)
                .stream()
                .map(this::mapSongView)
                .collect(Collectors.toList());
//        List<SongServiceModel> list = this.songRepository.findAll()
//                .stream()
//                .filter(e ->
//                        e.getStyle().getName().name().toUpperCase().trim()
//                                .equals(finalStyle))
//                .map(e -> this.modelMapper.map(
//                        e, SongServiceModel.class
//                ))
//                .toList();
//        return list;
    }

    private SongViewModel mapSongView(Song song) {
        SongViewModel songViewModel = new SongViewModel();
        songViewModel.setId(song.getId());
        songViewModel.setDuration(song.getDuration());
        songViewModel.setTitle(song.getTitle());
        songViewModel.setPerformer(song.getPerformer());
        return songViewModel;
    }

    private Song mapSong(SongServiceModel songServiceModel) {
        Song song = new Song();
        Style style = this.styleService.findByStyleName(songServiceModel.getStyle());

        song.setPerformer(songServiceModel.getPerformer());
        song.setTitle(songServiceModel.getTitle());
        song.setDuration(songServiceModel.getDuration());
        song.setStyle(style);
        song.setReleaseDate(songServiceModel.getReleaseDate());

        return song;
    }
}
