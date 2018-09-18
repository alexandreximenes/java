package Treinando_atalhos_IntelliJ;

import Treinando_atalhos_IntelliJ.model.Funcionario;

import java.time.LocalDate;

public class Primeiros_comandos {

    public static void main(String[] args) {
        System.out.println("hello world");

        Funcionario funcionario = getFuncionario();

        System.out.println(funcionario);

        new Funcionario("jose",
                LocalDate.of(2018, 9, 9),
                25,
                "123");

    }

    static Funcionario getFuncionario() {
        return new Funcionario()
                    .setAge(25)
                    .setBorn(LocalDate.now())
                    .setKey("123")
                    .setName("Funcionario");
    }
}
