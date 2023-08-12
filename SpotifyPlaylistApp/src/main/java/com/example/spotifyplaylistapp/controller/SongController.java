package com.example.spotifyplaylistapp.controller;

import com.example.spotifyplaylistapp.model.binding.SongAddBindingModel;
import com.example.spotifyplaylistapp.model.service.SongServiceModel;
import com.example.spotifyplaylistapp.service.SongService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/songs")
public class SongController {

    private final SongService songService;
    private final ModelMapper modelMapper;

    public SongController(SongService songService, ModelMapper modelMapper) {
        this.songService = songService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/add")
    public String add() {
        return "song-add";
    }

    @PostMapping("/add")
    public String confAdd(@Valid SongAddBindingModel songAddBindingModel,
                          BindingResult bindingResult,
                          RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("songAddBindingModel", songAddBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.songAddBindingModel", bindingResult);

            return "redirect:add";
        }

        songService.addSong(modelMapper
                .map(songAddBindingModel, SongServiceModel.class));

        return "redirect:/";
    }
    @ModelAttribute
    public SongAddBindingModel songAddBindingModel(){
        return new SongAddBindingModel();
    }

}
