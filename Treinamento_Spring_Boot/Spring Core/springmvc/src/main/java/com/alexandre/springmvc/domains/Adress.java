package com.alexandre.springmvc.domains;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Adress extends AbstractEntity{

    private String street;
    private String number;

    public Adress() {
    }


    public Adress(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
