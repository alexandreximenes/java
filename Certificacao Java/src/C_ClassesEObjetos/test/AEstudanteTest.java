package C_ClassesEObjetos.test;


import C_ClassesEObjetos.main.AEstudante;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AEstudanteTest {

    AEstudante estudante1 = new AEstudante();

    {
        estudante1.nome = "Alexandre Ximenes";
        estudante1.idade = 28;
        estudante1.matricula = "123456";
    }

    @Test
    public void nomeComecaComA() {
        Assertions.assertEquals('A', estudante1.nome.charAt(0));
    }

    @Test
    public void nomeTerminaComS() {
        Assertions.assertEquals('s', estudante1.nome.charAt(estudante1.nome.length()-1));
    }


    @Test
    public void nomeComMaisDeUmaPalavra() {
        Assertions.assertEquals(2, estudante1.nome.split(" ").length);
    }

    @Test
    public void estudanteInstanciado() {
        assert estudante1 instanceof AEstudante;
    }
}
