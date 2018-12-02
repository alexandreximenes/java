package com.alexandre.springmvc.services.user;

import com.alexandre.springmvc.domains.User;
import com.alexandre.springmvc.services.CRUDService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public interface UserService extends CRUDService<User> {
}
