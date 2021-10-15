package com.roland.oroz.h2crud.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewsPostWrapperDto {

    @JsonProperty("newspost")
    NewsPostDto newsPostDto;
}
