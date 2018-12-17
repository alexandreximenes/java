package com.jpaadvanced.start.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamedQuery(name = "SELECT.COURSES", query = "FROM Course")
@NamedQuery(name = "SELECT.WHERE.COURSES", query = "FROM Course c WHERE c.name like '%a%'")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fullname", nullable = false)
    private String name;
    @UpdateTimestamp
    private LocalDateTime lastUpdatedDate;
    @CreationTimestamp
    private LocalDateTime createdDate;
    @ManyToMany
    private List<Student> studentList;
    @OneToMany
    private List<Review> review;


}
