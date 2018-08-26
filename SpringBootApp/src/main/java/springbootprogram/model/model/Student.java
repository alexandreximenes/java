package springbootprogram.model.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {


    private int id;
    private String nome;
    private String sobrenome;
    private static List<Student> students;

    static{
        students = new ArrayList<Student>();
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(Student student) {
        students.add(student);
    }

    public Student(){}
    public Student(int id, String nome, String sobrenome) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
