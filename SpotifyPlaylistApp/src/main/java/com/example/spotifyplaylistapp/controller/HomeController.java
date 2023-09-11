package com.example.spotifyplaylistapp.controller;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.views.SongViewModel;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final SongService songService;
    private final StyleService styleService;
    private final HttpSession httpSession;

    public HomeController(SongService songService, StyleService styleService, HttpSession httpSession) {
        this.songService = songService;
        this.styleService = styleService;
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("id") == null) {
            return "index";
        }
        List<SongViewModel> popSongs = findSongByGenre(this.styleService.findByStyleName(StyleNameEnum.POP));
        model.addAttribute("popSongs",popSongs);
        List<SongViewModel> rockSongs = findSongByGenre(this.styleService.findByStyleName(StyleNameEnum.ROCK));
        model.addAttribute("rockSongs",rockSongs);
        List<SongViewModel> jazzSongs = findSongByGenre(this.styleService.findByStyleName(StyleNameEnum.JAZZ));
        model.addAttribute("jazzSongs",jazzSongs);
        List<SongViewModel> myPlaylist = songService.getPlaylistByUserId(httpSession);

        return "home";
    }
    private List<SongViewModel> findSongByGenre(Style style){
        return this.songService.findSongByGenre(style);
    }

}
