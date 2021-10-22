//package com.roland.oroz.h2crud.mapper;
//
//import com.roland.oroz.h2crud.dto.NewsPostDto;
//import com.roland.oroz.h2crud.model.Post;
//
//public class PostMapperImplNoMappStruct implements PostMapper{
//    @Override
//    public NewsPostDto modelToDto(Post post) {
//        NewsPostDto newsPostDto = new NewsPostDto();
//        newsPostDto.setId(post.getId());
//        newsPostDto.setNewstitle(post.getNewstitle());
//        newsPostDto.setFpost(post.getFpost());
//        newsPostDto.setCdate(post.getCdate());
//
//        return newsPostDto;
//    }
//
//    @Override
//    public Post dtoToModel(NewsPostDto newsPostDto) {
//
//        Post post = new Post();
//        post.setId(newsPostDto.getId());
//        post.setNewstitle(newsPostDto.getNewstitle());
//        post.setFpost(newsPostDto.getFpost());
//        post.setCdate(post.getCdate());
//
//        return post;
//    }
//}
