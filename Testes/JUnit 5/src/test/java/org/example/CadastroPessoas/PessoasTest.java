package org.example.CadastroPessoas;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PessoasTest {

    @Test
    @DisplayName("Verifica se tem pessoas cadastradas")
    public void verificaSeExistePessoasCadastradas() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }


    @Test
    @DisplayName("Cadastra pessoa")
    public void deveCadastrarPessoas() {

        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Tiago");

        cadastroPessoa.adiciona(pessoa);

        Assertions
                .assertThat(cadastroPessoa.getPessoas())
                .isNotEmpty()
                .hasSize(1)
                .contains(pessoa);
    }

    @Test
    @DisplayName("Não deve cadastrar pessoa sem nome")
    public void naoDeveCadastrarPessoaSemNome() {

        CadastroPessoa cadastroPessoa = new CadastroPessoa();

        Pessoa pessoa = new Pessoa();

        org.junit.jupiter.api.Assertions.assertThrows(PessoasSemNomeException.class, () -> cadastroPessoa.adiciona(pessoa));
    }

    @Test
    @DisplayName("Deve remover uma pessoa")
    public void deveRemoverUmaPessoa() {

        CadastroPessoa cadastroPessoa = new CadastroPessoa();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alexandre");

        cadastroPessoa.adiciona(pessoa);

        cadastroPessoa.removeUmaPessoa(pessoa);

        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }

    @Test//(expected = PessoaInexistenteException.class)
    @DisplayName("Lança exceção ao remover pessoa que não existe")
    public void lanceErroAoRemoverPessoaInexistente(){

        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();

        org.junit.jupiter.api.Assertions
                .assertThrows(PessoaInexistenteException.class, () -> cadastroPessoa.remove(pessoa));
    }
}
