package com.treinamento.hibernate;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@NamedQuery(name = "select_all_passport", query = "SELECT c FROM Passport c")
@Entity
@Data
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String uuid;
    @Column(nullable = false, length = 191)
    private String number;

    @PrePersist
    public void setUuid(){
        uuid = UUID.randomUUID().toString();
    }
}
