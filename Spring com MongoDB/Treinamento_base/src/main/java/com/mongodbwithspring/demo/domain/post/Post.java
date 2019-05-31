package com.mongodbwithspring.demo.domain.post;

import com.mongodbwithspring.demo.domain.user.UserObject;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document
public class Post implements Serializable {

    @Id
    private String id;
    private LocalDateTime data;
    private String title;
    private String body;
    private UserObject author;


}
