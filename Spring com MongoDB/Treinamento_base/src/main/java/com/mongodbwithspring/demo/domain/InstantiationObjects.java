package com.mongodbwithspring.demo.domain;

import com.mongodbwithspring.demo.domain.post.Post;
import com.mongodbwithspring.demo.domain.user.UserObject;
import com.mongodbwithspring.demo.repositories.PostRepository;
import com.mongodbwithspring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static java.util.Arrays.asList;

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

        List<UserObject> users = List.of(alexandreXimenes, dayaneXimenes, amanda, arthur, regina);
        userRepository.saveAll(users);

        Post post1 = Post.builder()
                .id(null)
                .data(LocalDateTime.now())
                .author(alexandreXimenes)
                .title("Na pele do sapo")
                .body("Chove tanto hoje que estamos se sentindo como sapo no banhado")
                .build();

        Post post2 = Post.builder()
                .id(null)
                .data(LocalDateTime.now())
                .author(dayaneXimenes)
                .title("comida")
                .body("comida chinesa mais cara do mundo")
                .build();

        List<Post> posts = List.of(post1, post2);

        postRepository.saveAll(posts);

        alexandreXimenes.setPosts(posts);
        dayaneXimenes.setPosts(List.of(post2));

        userRepository.save(alexandreXimenes);
        userRepository.save(dayaneXimenes);
    }
}
