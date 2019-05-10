package com.jpaadvanced.start.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NamedQuery(name = "SELECT.STUDENTS", query = "FROM Student")
@NamedQuery(name = "SELECT.WHERE.STUDENTS", query = "FROM Student s WHERE s.name like '%a%'")
@Data
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToOne( fetch = FetchType.LAZY)
    @JoinColumn(unique = true)
    private Passport passport;
    @ManyToMany(mappedBy = "students")
    private List<Course> couseList;

    public Student(Long id, String name) {
        this.name = name;
        this.id = id;
    }
}
