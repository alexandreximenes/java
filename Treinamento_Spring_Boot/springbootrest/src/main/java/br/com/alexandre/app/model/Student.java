package br.com.alexandre.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity{

    @Column(nullable = true)
    private String name;

    public Student() {

    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "["+ getId()+ "] " + name;
    }
}
