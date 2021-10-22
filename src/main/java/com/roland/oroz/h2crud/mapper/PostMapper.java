package com.roland.oroz.h2crud.mapper;

import com.roland.oroz.h2crud.dto.NewsPostDto;
import com.roland.oroz.h2crud.model.Post;

public interface PostMapper {

    NewsPostDto modelToDto(Post post);
    Post dtoToModel(NewsPostDto newsPostDto);

}
