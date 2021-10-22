package com.roland.oroz.h2crud.service;

import com.roland.oroz.h2crud.exception.ResourceNotFoundException;
import com.roland.oroz.h2crud.model.Post;
import com.roland.oroz.h2crud.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Post getPostById(int postId) {
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
    public void deletePost(int postId) {
        Optional<Post> postDataBase = this.postRepository
                .findById(postId);

        if(postDataBase.isPresent()) {
            this.postRepository.delete(postDataBase.get());
        } else {
            throw new ResourceNotFoundException("Record with id: " +
                    postId + " not found.");
        }
    }
}
