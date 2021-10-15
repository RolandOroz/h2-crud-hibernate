package com.roland.oroz.h2crud.service;

import com.roland.oroz.h2crud.dto.NewsPostDto;
import com.roland.oroz.h2crud.dto.NewsPostWrapperDto;
import com.roland.oroz.h2crud.model.Post;

import java.util.List;

public interface PostService {
    NewsPostWrapperDto createPost(NewsPostWrapperDto postWrapperDto);
    List<NewsPostDto> getAllPost();
    List<NewsPostDto> getAllNewsPost();
    Post getPostById(long postId);
    NewsPostDto updatePost(NewsPostWrapperDto postWrapperDto);
    void deletePost(long id);
    void deleteNewsPost(long id);
}
