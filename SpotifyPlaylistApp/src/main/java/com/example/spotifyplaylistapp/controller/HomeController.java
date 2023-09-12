package com.example.spotifyplaylistapp.controller;
import com.example.spotifyplaylistapp.model.entity.Song;
import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.model.views.SongViewModel;
import com.example.spotifyplaylistapp.service.SongService;
import com.example.spotifyplaylistapp.service.StyleService;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
@RequestMapping("/")
public class HomeController {
    private final SongService songService;
    private final StyleService styleService;
    private final UserService userService;
    private final HttpSession httpSession;

    public HomeController(SongService songService, StyleService styleService, UserService userService, HttpSession httpSession) {
        this.songService = songService;
        this.styleService = styleService;
        this.userService = userService;
        this.httpSession = httpSession;
    }

    @GetMapping("/")
    public String index(HttpSession httpSession) {
        if (httpSession.getAttribute("id") != null){
            return "redirect:/home";
        }
        return "index";
    }
    @GetMapping("/home")
    public String home(HttpSession httpSession, Model model){

        if (httpSession.getAttribute("id") == null) {
            return "redirect:/";
        }
        List<SongViewModel> popSongs = findSongByGenre(this.styleService.findByStyleName(StyleNameEnum.POP));
        model.addAttribute("popSongs",popSongs);
        List<SongViewModel> rockSongs = findSongByGenre(this.styleService.findByStyleName(StyleNameEnum.ROCK));
        model.addAttribute("rockSongs",rockSongs);
        List<SongViewModel> jazzSongs = findSongByGenre(this.styleService.findByStyleName(StyleNameEnum.JAZZ));
        model.addAttribute("jazzSongs",jazzSongs);
        List<SongViewModel> myPlaylist = songService.getPlaylistByUserId(httpSession);
        model.addAttribute("myPlayList",myPlaylist);


        AtomicInteger total = new AtomicInteger();
         myPlaylist.forEach(s -> {
             total.addAndGet(s.getDuration());
         });
         model.addAttribute("totalSum",total);

        return "home";
    }
    @GetMapping("/home/add-song-to-playlist/{id}")
    public String addSongToPlayList(@PathVariable("id") Long id){

        if (httpSession.getAttribute("id") == null){
            return "redirect:/users/login";
        }
        Long userId = (Long) httpSession.getAttribute("id");
        Song song = this.songService.findSongById(id);


        this.userService.addSongToUser(userId,song);
        return "redirect:/home";
    }
    @GetMapping("/home/delete-all-songs/{id}")
    public String deleteAllSongs(@PathVariable("id") Long id, HttpSession httpSession){

        if (httpSession.getAttribute("id") == null){
            return "redirect:/users/login";
        }

        Long userId = (Long) httpSession.getAttribute("id");
        this.userService.deleteAll(userId);
        return "redirect:/home";
    }
    private List<SongViewModel> findSongByGenre(Style style){
        return this.songService.findSongByGenre(style);
    }

}
