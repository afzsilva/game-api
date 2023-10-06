package com.afzdev.gameapi.dto;

import com.afzdev.gameapi.entities.Category;
import com.afzdev.gameapi.entities.Developer;
import com.afzdev.gameapi.entities.Platform;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class GameDTO {

    private Long id;
    private String title;
    private String description;
    private String imageUrl;
    private LocalDate releaseDate;
    private Developer developerId;
    private Category category;
    private Platform platform;

}
