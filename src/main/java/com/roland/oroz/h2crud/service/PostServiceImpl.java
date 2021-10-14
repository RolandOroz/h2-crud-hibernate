package com.roland.oroz.h2crud.service;

import com.roland.oroz.h2crud.dto.NewsPostDto;
import com.roland.oroz.h2crud.exception.ResourceNotFoundException;
import com.roland.oroz.h2crud.model.Post;
import com.roland.oroz.h2crud.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PostServiceImpl implements PostService {

    @Autowired
    private PostRepository postRepository;

    @Override
    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    @Override
    public Post updatePost(Post post) {
        Optional<Post> postDataBase = this.postRepository
                .findById(post.getId());

        if(postDataBase.isPresent()) {
            Post postUpdate = postDataBase.get();
            postUpdate.setId(post.getId());
            postUpdate.setNewstitle(post.getNewstitle());
            postUpdate.setFpost(post.getFpost());
            postUpdate.setCdate(post.getCdate());
            postRepository.save(postUpdate);
            return postUpdate;
        }else {
            throw new ResourceNotFoundException("Record with id: " +
                    post.getId() + " not found.");
        }
    }

    @Override
    public List<Post> getAllPost() {
        return this.postRepository.findAll();
    }

    //DTO
    @Override
    public List<NewsPostDto> getAllNewsPost() {
        return postRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());

    }

    //Entity to DTO
    private NewsPostDto convertEntityToDto(Post post) {
        NewsPostDto newsPostDto = new NewsPostDto();
        newsPostDto.setId(post.getId());
        newsPostDto.setNewstitle(post.getNewstitle());
        newsPostDto.setFpost(post.getFpost());
        newsPostDto.setCdate(post.getCdate());
        return newsPostDto;
    }

    //DTO to Entity
    private Post convertDtoToEntity(NewsPostDto newsPostDto) {
        Post post = new Post();
        post.setId(newsPostDto.getId());
        post.setNewstitle(newsPostDto.getNewstitle());
        post.setFpost(newsPostDto.getFpost());
        post.setCdate(newsPostDto.getCdate());
        return post;
    }

    @Override
    public Post getPostById(long postId) {
        Optional<Post> postDataBase = this.postRepository
                .findById(postId);

        if(postDataBase.isPresent()) {
            return postDataBase.get();
        } else {
            throw new ResourceNotFoundException("Record with id: " +
                    postId + " not found.");
        }
    }

    @Override
    public void deletePost(long postId) {
        Optional<Post> postDataBase = this.postRepository
                .findById(postId);

        if(postDataBase.isPresent()) {
            this.postRepository.delete(postDataBase.get());
        } else {
            throw new ResourceNotFoundException("Record with id: " +
                    postId + " not found.");
        }
    }
    //DTO
    @Override
    public void deleteNewsPost(long newsPostId) {
        Optional<Post> postDataBase = this.postRepository
                .findById(newsPostId);

        if(postDataBase.isPresent()) {
            this.postRepository.delete(postDataBase.get());
        } else {
            throw new ResourceNotFoundException("Record with id: " +
                    newsPostId + " not found.");
        }
    }
}
