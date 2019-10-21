package com.treinamento.hibernate;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NamedQuery(name = "select_all_courses", query = "SELECT c FROM Course c")
@Entity
@Data
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String uuid;
    @Column(nullable = false, length = 191, unique = true)
    private String name;

    @ManyToMany(mappedBy = "courses")
    private List<Review> reviews;

    @PrePersist
    public void setUuid(){
        uuid = UUID.randomUUID().toString();
    }

    public Course(String name) {
        this.name = name;
    }

    public void addReview(List<Review> reviews) {
        this.reviews.addAll(reviews);
    }
}
