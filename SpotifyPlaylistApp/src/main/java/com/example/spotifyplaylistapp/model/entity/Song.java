package com.example.spotifyplaylistapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

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
}
