package com.example.spotifyplaylistapp.model.binding;

import com.example.spotifyplaylistapp.model.entity.Style;
import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;


public class SongBindingModel {
    private Long id;
    private String performer;
    private String title;
    private Integer duration;
    private String style;

    public SongBindingModel(Long id, String performer, String title, Integer duration, StyleNameEnum style) {
        this.id = id;
        this.performer = performer;
        this.title = title;
        this.duration = duration;
        this.style = style.name();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }
}
