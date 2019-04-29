package com.jpaadvanced.start.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Passport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String number;
    @OneToOne( fetch = FetchType.LAZY, mappedBy = "passport")
    private Student student ;

    public Passport(Long id, String number) {
        this.number = number;
        this.id = id;
    }
}
