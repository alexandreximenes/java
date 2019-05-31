package com.mongodbwithspring.demo.services;

import com.mongodbwithspring.demo.domain.post.PostDTO;

import java.util.List;

public interface PostService {

    List<PostDTO> findAll();
    PostDTO findById(String id);
    PostDTO save(PostDTO post);
    void update(String id, PostDTO post);
    void delete(String id);
}
