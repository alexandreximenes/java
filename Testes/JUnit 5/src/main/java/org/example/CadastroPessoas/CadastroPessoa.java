package org.example.CadastroPessoas;

import java.util.ArrayList;
import java.util.List;

public class CadastroPessoa {

    List<Pessoa> pessoas = new ArrayList<>();

    public List<Pessoa> getPessoas() {
        return this.pessoas;
    }

    public void adiciona(Pessoa pessoa) {
        if(pessoa.getNome() == null){
           throw new PessoasSemNomeException();
        }
        this.pessoas.add(pessoa);
    }

    public void removeUmaPessoa(Pessoa pessoa) {
        this.pessoas.remove(pessoa);
    }

    public void remove(Pessoa pessoa) {
        if(!this.pessoas.contains(pessoa))
            throw new PessoaInexistenteException();
        this.pessoas.remove(pessoa);
    }
}
