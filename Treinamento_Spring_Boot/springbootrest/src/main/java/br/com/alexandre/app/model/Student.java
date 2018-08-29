package br.com.alexandre.app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Student {

    private int id;

    private String name;

    public Student() {

    }


    public Student(int id, String name) {
        this.id  = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static List<Student> students;

    static {
        setStudents();

    }

    public static List<Student> getList() {
        return students;
    }

    public static void setStudents() {
        students = new ArrayList<>(asList(new Student(1, "alexandre"), new Student(2,"arthur"), new Student(3,"amanda"), new Student(4,"dayane")));
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

    @Override
    public String toString() {
        return "["+id + "] " + name;
    }
}
