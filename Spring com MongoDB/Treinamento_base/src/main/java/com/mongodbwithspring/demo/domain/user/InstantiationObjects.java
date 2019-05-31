package com.mongodbwithspring.demo.domain.user;

import com.mongodbwithspring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InstantiationObjects implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... args) throws Exception {

        userRepository.deleteAll();
        postRepository.deleteAll();

        UserObject alexandreXimenes = UserObject.builder()
                .id(null)
                .nome("Alexandre Ximenes")
                .email("xyymenes@gmail.com")
                .build();

        UserObject dayaneXimenes = UserObject.builder()
                .id(null)
                .nome("Dayane Ximenes")
                .email("x0menes@gmail.com")
                .build();

        UserObject amanda = UserObject.builder()
                .id(null)
                .nome("Amanda Ximenes")
                .email("amanda@gmail.com")
                .build();

        UserObject arthur = UserObject.builder()
                .id(null)
                .nome("Arthur Ximenes")
                .email("artur@gmail.com")
                .build();

        UserObject regina = UserObject.builder()
                .id(null)
                .nome("Regina Ximenes")
                .email("regina@gmail.com")
                .build();

        List<UserObject> list = List.of(alexandreXimenes, dayaneXimenes, amanda, arthur, regina);
        userRepository.saveAll(list);

    }
}
