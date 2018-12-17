package com.jpaadvanced.start.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne(mappedBy = "student")
    @JoinColumn(unique = true)
    private Passport passport;
    @ManyToMany(mappedBy = "studentList")
    private List<Course> couseList;

}
