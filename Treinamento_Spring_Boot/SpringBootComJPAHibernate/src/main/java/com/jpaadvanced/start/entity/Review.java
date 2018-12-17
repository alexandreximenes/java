package com.jpaadvanced.start.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rating;
    private String description;
    @ManyToOne
    private Course course;

}
