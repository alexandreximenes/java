package C_ClassesEObjetos.test;

import C_ClassesEObjetos.main.CCalculadora;

public class CCalculadoraTest {

    public static void main(String[] args) {
        CCalculadora calculadora = new CCalculadora();
        calculadora.somaDoisNumeros();
        calculadora.somaDoisNumeros(5,5,5,5,5,5,5,5,5,5);
        calculadora.subtraiDoisNumeros();
        calculadora.multiplicaDoisNumeros(5,5);
    }
}
