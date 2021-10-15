package com.roland.oroz.h2crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data

public class PostListWrapperDto {

    @JsonProperty ("success")
    private boolean success;
    @JsonProperty("info")
    private List<NewsPostDto> newsPostDtoList;//???
    @JsonProperty("message")
    private String message;

    private NewsPostDto newspost;

}
