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
        Song song = modelMapper.map(songServiceModel,Song.class);
        song.setStyle(styleService
                .findByStyleName(songServiceModel.getStyle().getName()));
        songRepository.save(song);
    }

    public List<SongServiceModel> findSongByGenre(String style1) {
        //POP
        style1 = style1.toUpperCase().trim();
        String finalStyle = style1;
        List<SongServiceModel> list = this.songRepository.findAll()
                .stream()
                .filter(e ->
                        e.getStyle().getName().name().toUpperCase().trim()
                                .equals(finalStyle))
                .map(e -> this.modelMapper.map(
                        e, SongServiceModel.class
                ))
                .toList();
return list;
//        return this.songRepository.findSongByStyleName(style);
    }

    private SongViewModel mapSong(Song song){
        SongViewModel songViewModel = new SongViewModel();
                songViewModel.setId(song.getId());
                songViewModel.setPerformer(song.getPerformer());
                songViewModel.setTitle(song.getTitle());
                songViewModel.setDuration(song.getDuration());

        return songViewModel;
    }
}
