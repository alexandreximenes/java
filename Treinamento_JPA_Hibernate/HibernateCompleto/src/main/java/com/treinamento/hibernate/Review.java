package com.treinamento.hibernate;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
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

    @PrePersist
    public void setUuid(){
        uuid = UUID.randomUUID().toString();
    }
}
