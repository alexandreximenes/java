package com.treinamento.hibernate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@NamedQuery(name = "select_all_review", query = "SELECT c FROM Passport c")
@Entity
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String uuid;
    @Column(nullable = false, length = 191)
    private String rating;
    @Column(nullable = false, length = 191)
    private String description;

    @ManyToMany
    @JoinTable(name = "course_review",
            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "review_id", referencedColumnName = "id"))
    private List<Course> courses;

    @PrePersist
    public void setUuid() {
        uuid = UUID.randomUUID().toString();
    }

    public Review(String rating, String description) {
        this.rating = rating;
        this.description = description;
    }

    public void addCourse(List<Course> courses) {
        this.courses.addAll(courses);
    }
}
