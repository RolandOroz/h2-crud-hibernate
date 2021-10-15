package com.roland.oroz.h2crud.service;

import com.roland.oroz.h2crud.dto.NewsPostDto;
import com.roland.oroz.h2crud.dto.PostWrapperDto;
import com.roland.oroz.h2crud.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(PostWrapperDto post);
    List<NewsPostDto> getAllPost();
    List<NewsPostDto> getAllNewsPost();
    Post getPostById(long postId);
    Post updatePost(NewsPostDto post);
    void deletePost(long id);
    void deleteNewsPost(long id);
}
