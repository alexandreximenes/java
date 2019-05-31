package com.mongodbwithspring.demo.domain.post;

import com.mongodbwithspring.demo.domain.user.UserObject;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.time.LocalDate;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Document
public class Post extends Serializable {

    @Id
    private String id;
    private LocalDate data;
    private String title;
    private String body;
    private UserObject author;


}
