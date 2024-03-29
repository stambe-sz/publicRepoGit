package com.example.spotifyplaylistapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User extends BaseEntity{
    @Column(nullable = false,unique = true)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false,unique = true)
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    List<Song> playlist;

    public void deleteAllSongs(){
        this.playlist.clear();
    }
}
