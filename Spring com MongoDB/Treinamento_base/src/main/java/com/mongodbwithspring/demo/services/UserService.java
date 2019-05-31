package com.mongodbwithspring.demo.services;
import java.util.List;

import com.mongodbwithspring.demo.domain.user.UserObjectDTO;

public interface UserService {

    List<UserObjectDTO> findAll();
    UserObjectDTO findById(String id);
    UserObjectDTO save(UserObjectDTO user);
    void update(String id, UserObjectDTO user);
    void delete(String id);
}
