package com.roland.oroz.h2crud.service;

import com.roland.oroz.h2crud.dto.NewsPostDto;
import com.roland.oroz.h2crud.dto.NewsPostWrapperDto;
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
    public NewsPostWrapperDto createPost(NewsPostWrapperDto postWrapperDto) {

        Post postCreate = new Post();
        // postUpdate.setId(post.getId());
        postCreate.setNewstitle(postWrapperDto.getNewsPostDto().getNewstitle());
        postCreate.setFpost(postWrapperDto.getNewsPostDto().getFpost());
        postCreate.setCdate(postWrapperDto.getNewsPostDto().getCdate());
        postRepository.save(postCreate);
        return postCreate;
    }

  /*  @Override
    public NewsPostDto updatePost(NewsPostWrapperDto postWrapperDto) {
        Optional<Post> postDataBase = this.postRepository
                .findById(postWrapperDto.getNewsPostDtoList().getId());

        if(postDataBase.isPresent()) {
            Post postUpdate = postDataBase.get();
           // postUpdate.setId(post.getId());
            postUpdate.setNewstitle(postWrapperDto.getNewspost().getNewstitle());
            postUpdate.setFpost(postWrapperDto.getNewspost().getFpost());
            postUpdate.setCdate(postWrapperDto.getNewspost().getCdate());
            postRepository.save(postUpdate);
            return postUpdate;
        }else {
            throw new ResourceNotFoundException("Record with id: " +
                    postWrapperDto.getNewspost().getId() + " not found.");
        }
    }*/

    @Override
    public List<NewsPostDto> getAllPost() {
        List<Post> list = this.postRepository.findAll();
        return postRepository.findAll()
                .stream()
                .map(this::createNew)
                .collect(Collectors.toList());
    }

    //DTO
    @Override
    public List<NewsPostDto> getAllNewsPost() {
        return postRepository.findAll()
                .stream()
                .map(this::createNew)
                .collect(Collectors.toList());

    }

    //Entity to DTO
    private NewsPostDto createNew(Post post) {
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
    public NewsPostDto updatePost(NewsPostWrapperDto postWrapperDto) {
        return null;
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
