package org.example.CadastroPessoas;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class PessoasTest {

    @Test
    public void verificaSeExistePessoasCadastradas() {
        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }


    @Test
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

    @Test(expected = PessoasSemNomeException.class)
    public void naoDeveCadastrarPessoaSemNome() {

        CadastroPessoa cadastroPessoa = new CadastroPessoa();

        Pessoa pessoa = new Pessoa();

        cadastroPessoa.adiciona(pessoa);
    }

    @Test
    public void deveRemoverUmaPessoa() {

        CadastroPessoa cadastroPessoa = new CadastroPessoa();

        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Alexandre");

        cadastroPessoa.adiciona(pessoa);

        cadastroPessoa.removeUmaPessoa(pessoa);

        Assertions.assertThat(cadastroPessoa.getPessoas()).isEmpty();
    }

    @Test(expected = PessoaInexistenteException.class)
    public void lanceErroAoRemoverPessoaInexistente(){

        CadastroPessoa cadastroPessoa = new CadastroPessoa();
        Pessoa pessoa = new Pessoa();

        cadastroPessoa.remove(pessoa);
    }
}
