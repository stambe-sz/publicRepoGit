package com.likebookapp.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "posts")
public class Post extends BaseEntity {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String content;
    @Column
    private int likes;
    @ManyToOne
    @NotNull
    private User user;
    @ManyToMany(mappedBy = "likePosts")
    private List<User> userLikes;
    @ManyToOne
    private Mood mood;
}
