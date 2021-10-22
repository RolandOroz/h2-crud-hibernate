package com.roland.oroz.h2crud.service;

import com.roland.oroz.h2crud.model.Post;

import java.util.List;

public interface PostService {
    Post createPost(Post post);
    List<Post> getAllPost();
    Post getPostById(int postId);
    Post updatePost(Post post);
    void deletePost(int id);
}
