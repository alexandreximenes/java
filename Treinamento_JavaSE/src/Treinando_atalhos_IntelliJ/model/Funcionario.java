package Treinando_atalhos_IntelliJ.model;

import java.time.LocalDate;

public class Funcionario {

    private String name;
    private int age;
    private String key;
    private LocalDate born;
    private String jose;
    private LocalDate of;
    private int i;
    private String s;

    public Funcionario() {
    }

    public Funcionario(String jose, LocalDate of, int i, String s) {

        this.jose = jose;
        this.of = of;
        this.i = i;
        this.s = s;
    }


    public String getName() {
        return name;
    }

    public Funcionario setName(String name) {
        this.name = name;
         return this;
    }

    public int getAge() {
        return age;
    }

    public Funcionario setAge(int age) {
        this.age = age;
        return this;

    }

    public String getKey() {
        return key;
    }

    public Funcionario setKey(String key) {
        this.key = key;
        return this;

    }

    public LocalDate getBorn() {
        return born;
    }

    public Funcionario setBorn(LocalDate born) {
        this.born = born;
        return this;

    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", key='" + key + '\'' +
                ", born=" + born +
                '}';
    }
}



