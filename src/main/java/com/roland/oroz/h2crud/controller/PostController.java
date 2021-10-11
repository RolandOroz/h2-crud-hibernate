package com.roland.oroz.h2crud.controller;

//import com.roland.oroz.h2crud.dto.PostDto;
import com.roland.oroz.h2crud.model.Post;
import com.roland.oroz.h2crud.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(
        origins = "http://localhost:1841",
        allowedHeaders = "*")
@RestController
@RequestMapping("newspost")
public class PostController {

    @Autowired
    private PostService postService;

    @GetMapping("/posts")
    public ResponseEntity<List<Post>> getAllPost() {
        return ResponseEntity
                .ok()
                .body(postService.getAllPost());
    }

 /*   @GetMapping(value = "/posts", produces = "application/json;charset=UTF-8")
    public ResponseEntity<PostDto> getAllPost(Post post) throws Exception {
        PostDto response;
        try {
            List<Post> posts = postService.getAllPost();
            return new ResponseEntity<>(new PostDto(true, posts, "OK"), HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<>(new PostDto(false, null, e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        } */



    @GetMapping("/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable long id) {
        return ResponseEntity
                .ok()
                .body(postService.getPostById(id));
    }

    @PostMapping("/posts")
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        return ResponseEntity
                .ok()
                .body(this.postService.createPost(post));
    }


    @PutMapping("/posts/{id}")
    public ResponseEntity<Post> updatePost(
            @PathVariable long id,
            @RequestBody Post post) {
        post.setId(id);
        return ResponseEntity
                .ok()
                .body(this.postService.updatePost(post));
    }

    @DeleteMapping("/posts/{id}")
    public HttpStatus deletePost(@PathVariable long id) {
        this.postService.deletePost(id);
        return HttpStatus.OK;

    }

}
