package com.example.spotifyplaylistapp.service;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import com.example.spotifyplaylistapp.repository.StyleRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Optional;

@Service
public class StyleService {
    private final StyleRepository styleRepository;

    public StyleService(StyleRepository styleRepository) {
        this.styleRepository = styleRepository;
    }

    public void initStyles() {
        if (styleRepository.count() != 0){
            return;
        }

        Arrays.stream(StyleNameEnum.values())
                .forEach(styleNameEnum -> {
                    Style style = new Style();
                    style.setName(styleNameEnum);
                    styleRepository.save(style);
                });

    }

    public Style findByStyleName(StyleNameEnum style) {
        return styleRepository.findByName(style)
                .orElse(null);
    }
}
