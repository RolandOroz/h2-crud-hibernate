package com.roland.oroz.h2crud.repository;

import com.roland.oroz.h2crud.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
