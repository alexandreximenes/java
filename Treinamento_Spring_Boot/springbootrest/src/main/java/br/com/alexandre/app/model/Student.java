package br.com.alexandre.app.model;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Student extends AbstractEntity {

    @NotEmpty
    private String name;

    @Email
    @NotEmpty
    private String email;

//    @OneToMany(mappedBy = "student")
//    private List<Cursos> cursos;
//
//    public List<Cursos> getCursos() {
//        return cursos;
//    }
//
//    public void setCursos(List<Cursos> cursos) {
//        this.cursos = cursos;
//    }

    public Student() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
