package com.oauth2.demo.service;


import com.oauth2.demo.domain.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@Configuration
@EnableAutoConfiguration
@ComponentScan("com.oauth2.demo")
@ActiveProfiles({"dev"})
@RunWith(SpringRunner.class)
public class UserServiceJpaImplTest {

    @Autowired
    private UserService userService;

    @Test
    public void TestListMethod() throws Exception {

        List<UserDTO> all = userService.findAll();
        assert all.size() == 2;

    }
}
