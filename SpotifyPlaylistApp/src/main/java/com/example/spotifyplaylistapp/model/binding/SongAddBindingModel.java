package com.example.spotifyplaylistapp.model.binding;

import com.example.spotifyplaylistapp.model.entity.Style;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class SongAddBindingModel {
    private Long id;
    @NotNull
    @Size(min = 3,max = 20, message = "Performer name length must be between 3 and 20 characters")
    private String performer;
    @NotNull
    @Size(min = 2,max = 20, message = "Title length must be between 2 and 20 characters")
    private String title;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    @Positive
    @NotNull
    private Integer duration;
    @NotNull
    private String style;
}
