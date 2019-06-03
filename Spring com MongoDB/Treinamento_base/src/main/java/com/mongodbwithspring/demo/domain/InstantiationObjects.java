package com.mongodbwithspring.demo.domain;

import com.mongodbwithspring.demo.domain.comment.CommentDTO;
import com.mongodbwithspring.demo.domain.post.Post;
import com.mongodbwithspring.demo.domain.user.Author;
import com.mongodbwithspring.demo.domain.user.AuthorDTO;
import com.mongodbwithspring.demo.repositories.PostRepository;
import com.mongodbwithspring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
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

        Author alexandreXimenes = Author.builder()
                .id(null)
                .nome("Alexandre Ximenes")
                .email("xyymenes@gmail.com")
                .build();

        Author dayaneXimenes = Author.builder()
                .id(null)
                .nome("Dayane Ximenes")
                .email("x0menes@gmail.com")
                .build();

        Author amanda = Author.builder()
                .id(null)
                .nome("Amanda Ximenes")
                .email("amanda@gmail.com")
                .build();

        Author arthur = Author.builder()
                .id(null)
                .nome("Arthur Ximenes")
                .email("artur@gmail.com")
                .build();

        Author regina = Author.builder()
                .id(null)
                .nome("Regina Ximenes")
                .email("regina@gmail.com")
                .build();

        List<Author> users = List.of(alexandreXimenes, dayaneXimenes, amanda, arthur, regina);
        userRepository.saveAll(users);

        Post post1 = Post();
        post1.setId(null);
        post1.setData(LocalDateTime.now());
        post1.setAuthor(alexandreXimenes);
        post1.setTitle("Na pele do sapo");
        post1.setBody("Chove tanto hoje que estamos se sentindo como sapo no banhado");

        Post post2 = Post();
        post2.setId(null);
        post2.setData(LocalDateTime.now());
        post2.setAuthor(dayaneXimenes);
        post2.setTitle("comida");
        post2.setBody("comida chinesa mais cara do mundo");

        List<Post> posts = List.of(post1, post2);

        CommentDTO comments1 = new CommentDTO("Verdade, essa chuva não para nunca, mas fazer o que sempre reclamamos de tudo, sol ou chuva haha", LocalDateTime.now(), new Author(null, "Jessica", "jessica@gmail.com", null));
        CommentDTO comments2 = new CommentDTO("Não sei, mas independente do valor, eu não gosto", LocalDateTime.now(), new Author(null, "Pedro", "pedro@hotmail.com", null));
        CommentDTO comments3 = new CommentDTO("Eu adoro comida chinesa, muiiiiito bom", LocalDateTime.now(), new AuthorDTO(null, "Dora", "dora@outlook.com", null));

        post1.setComments(comments1);
        post2.setComments(comments2, comments3);

        postRepository.saveAll(posts);

        alexandreXimenes.setPosts(posts);
        dayaneXimenes.setPosts(List.of(post2));

        userRepository.save(alexandreXimenes);
        userRepository.save(dayaneXimenes);
    }
}
