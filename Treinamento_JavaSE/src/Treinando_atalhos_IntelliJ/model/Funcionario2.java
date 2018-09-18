package Treinando_atalhos_IntelliJ.model;

import java.time.LocalDate;

public class Funcionario2 {

    private String name;
    private int age;
    private String key;
    private LocalDate born;

    public Funcionario2(String jose, LocalDate of, int i, String s) {

    }

    public String getName() {
        return name;
    }

    public Funcionario2 setName(String name) {
        this.name = name;
        return this;
    }

    public int getAge() {
        return age;
    }

    public Funcionario2 setAge(int age) {
        this.age = age;
        return this;
    }

    public String getKey() {
        return key;
    }

    public Funcionario2 setKey(String key) {
        this.key = key;
        return this;

    }

    public LocalDate getBorn() {
        return born;
    }

    public Funcionario2 setBorn(LocalDate born) {
        this.born = born;
        return this;

    }

    private void salvar(Funcionario f){
        Funcionario A = f ;
        Funcionario b = f ;
        Funcionario e = f ;
        Funcionario c = f ;
        Funcionario d = f ;
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



