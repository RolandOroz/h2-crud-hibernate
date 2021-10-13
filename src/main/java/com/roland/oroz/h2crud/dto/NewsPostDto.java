package com.roland.oroz.h2crud.dto;


import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;


public class NewsPostDto {

    private Long id;
    private String newstitle;
    private String fpost;
    private LocalDate cdate;
}
