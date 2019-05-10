package com.jpaadvanced.start.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Data
@Entity
public class Review {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String rating;
    private String description;
    @ManyToOne
    private Course course;

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }
}
