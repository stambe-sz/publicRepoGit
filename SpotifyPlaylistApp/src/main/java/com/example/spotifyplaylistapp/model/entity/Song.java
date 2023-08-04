package com.example.spotifyplaylistapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "songs")
public class Song  extends BaseEntity{

    @Column(nullable = false)
    private String performer;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private Integer duration;
    @Column(name = "release_date")
    private LocalDate releaseDate;
    @ManyToOne
    private Style style;
    @ManyToMany(mappedBy = "playlist")
    private List<User> user;
}
