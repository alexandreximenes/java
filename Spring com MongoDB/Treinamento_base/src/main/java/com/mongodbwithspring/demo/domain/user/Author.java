package com.mongodbwithspring.demo.domain.user;

import com.mongodbwithspring.demo.domain.post.Post;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document(collection = "author")
public class Author implements Serializable {

    @Id
    private String id;
    @NotBlank
    private String nome;
    @Email
    private String email;

    @DBRef//(lazy = true)
    private List<Post> posts = new ArrayList<>();

    public Author(AuthorDTO u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.email = u.getEmail();
    }
}
