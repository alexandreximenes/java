package com.mongodbwithspring.demo.services;
import java.util.List;

import com.mongodbwithspring.demo.domain.user.AuthorDTO;

public interface UserService {

    List<AuthorDTO> findAll();
    AuthorDTO findById(String id);
    AuthorDTO save(AuthorDTO user);
    void update(String id, AuthorDTO user);
    void delete(String id);
    AuthorDTO findByIdPosts(String id);
}
