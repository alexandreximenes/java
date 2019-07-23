package com.treinamento.hibernate;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String uuid;
    private String name;

    @PrePersist
    public void setUuid(){
        uuid = UUID.randomUUID().toString();
    }
}
