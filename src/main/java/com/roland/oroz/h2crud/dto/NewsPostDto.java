package com.roland.oroz.h2crud.dto;


import lombok.Data;
import java.time.LocalDate;

@Data
public class NewsPostDto {

    private Long id;
    private String newstitle;
    private String fpost;
    private LocalDate cdate;
}
