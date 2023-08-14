package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.binding.SongBindingModel;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.service.SongService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    private final SongService songService;

    public HomeController(SongService songService) {
        this.songService = songService;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("id") == null) {
            return "index";
        }
        List<SongBindingModel> popSongs =
                this.songService.findSongByGenre(StyleNameEnum.POP);

        return "home";
    }
}
