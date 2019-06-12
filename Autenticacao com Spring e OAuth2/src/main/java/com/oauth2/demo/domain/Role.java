package com.oauth2.demo.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    private String name;

    public Role(String name) {
        this.name = name;
    }
}
