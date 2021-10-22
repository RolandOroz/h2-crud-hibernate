package com.roland.oroz.h2crud.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Id;
import java.time.LocalDate;

@Getter
@Setter
public class NewsPostDto {

    @Id
    private String id;
    private String newstitle;
    private String fpost;
    private LocalDate cdate;
}
