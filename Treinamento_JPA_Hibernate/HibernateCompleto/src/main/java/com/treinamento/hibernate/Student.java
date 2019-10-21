package com.treinamento.hibernate;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@NamedQuery(name = "select_all_student", query = "SELECT c FROM Student c")
@Entity
@Data
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String uuid;
    @Column(nullable = false, length = 191)
    private String name;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "student")
    @JoinColumn(unique = true)
    private Passport passport;

    @PrePersist
    public void setUuid(){
        uuid = UUID.randomUUID().toString();
    }
}
