package com.mongodbwithspring.demo.domain.post;

import com.mongodbwithspring.demo.domain.user.UserObject;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class PostDTO implements Serializable {

    @Id
    private String id;
    private LocalDateTime data;
    private String title;
    private String body;
    private UserObject author;

    public PostDTO(Post p) {

    }
}
