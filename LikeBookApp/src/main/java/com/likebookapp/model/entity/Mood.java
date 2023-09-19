package com.likebookapp.model.entity;

import com.likebookapp.model.enums.MoodNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "moods")
public class Mood extends BaseEntity{

//    @Enumerated(EnumType.STRING)
//    @Column(unique = true,nullable = false)
//    private MoodNameEnum moodName;

    @Column
    private String name;
    @Column
    private String description;
}
