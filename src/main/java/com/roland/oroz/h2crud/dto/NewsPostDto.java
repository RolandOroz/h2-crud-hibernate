package com.roland.oroz.h2crud.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class NewsPostDto {

    @JsonProperty ("success")
    private boolean success;
    @JsonProperty("info")
    private List<NewsPostDto> workerList;
    @JsonProperty("message")
    private String message;

    private Long id;
    private String newstitle;
    private String fpost;
    private LocalDate cdate;
}
