package com.mongodbwithspring.demo.domain.user;

import com.mongodbwithspring.demo.domain.post.Post;
import lombok.*;

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
public class UserObjectDTO implements Serializable {

    private String id;
    @NotBlank
    private String nome;
    @Email
    private String email;

    private List<Post> posts = new ArrayList<>();

    public UserObjectDTO(UserObject u) {
        this.id = u.getId();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.posts = u.getPosts();
    }
}
