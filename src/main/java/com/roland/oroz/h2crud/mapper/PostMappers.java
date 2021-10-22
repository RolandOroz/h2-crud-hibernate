package com.roland.oroz.h2crud.mapper;

import com.roland.oroz.h2crud.dto.NewsPostDto;
import com.roland.oroz.h2crud.model.Post;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface PostMappers {


    NewsPostDto modelToDto(Post post);
    @InheritInverseConfiguration
    Post dtoToModel(NewsPostDto newsPostDto);

}
