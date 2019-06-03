package com.mongodbwithspring.demo.domain.comment;

import com.mongodbwithspring.demo.domain.user.Author;
import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class CommentDTO implements Serializable {

    private String text;
    private LocalDateTime date;
    private Author author;
}
