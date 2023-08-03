package com.example.spotifyplaylistapp.model.entity;

import com.example.spotifyplaylistapp.model.enums.StyleNameEnum;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "styles")
public class Style  extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private StyleNameEnum styleName;

    @Column
    private String description;

}
