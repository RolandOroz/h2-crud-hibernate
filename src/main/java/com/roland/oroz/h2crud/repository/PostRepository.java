package com.roland.oroz.h2crud.repository;

import com.roland.oroz.h2crud.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findById(int id);
}
