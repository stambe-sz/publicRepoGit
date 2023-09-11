package com.example.spotifyplaylistapp.controller;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.service.SongServiceModel;
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

    public HomeController(SongService songService, StyleService styleService) {
        this.songService = songService;
        this.styleService = styleService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("id") == null) {
            return "index";
        }
        List<SongViewModel> popSongs = findSongByGenre(this.styleService.findByStyleName(StyleNameEnum.POP));
        model.addAttribute("popSongs",popSongs);
        return "home";
    }
    private List<SongViewModel> findSongByGenre(Style style){
        return this.songService.findSongByGenre(style);
    }

}
