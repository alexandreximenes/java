package com.mongodbwithspring.demo.domain.post;

import com.mongodbwithspring.demo.domain.comment.CommentDTO;
import com.mongodbwithspring.demo.domain.user.Author;
import lombok.*;
import org.springframework.data.annotation.Id;
import java.util.ArrayList;
import java.util.List;

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
    private Author author;
    private List<CommentDTO> comments = new ArrayList<>();

    public PostDTO(Post p) {

    }
}