package com.alexandre.springmvc.domains;

import javax.persistence.*;

@Entity
public class Adress extends AbstractEntity{

    @Version
    private Integer version;

    private String street;
    private String number;

    public Adress() {
    }

    public Adress(String street, String number) {
        this.street = street;
        this.number = number;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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
