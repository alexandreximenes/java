package domain;

import javax.persistence.*;

@Entity
public class PalavrasInocentes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String palavra;
    private String palavraPronunciada;

    @ManyToOne
    private Usuario usuario;

    public PalavrasInocentes() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public String getPalavraPronunciada() {
        return palavraPronunciada;
    }

    public void setPalavraPronunciada(String palavraPronunciada) {
        this.palavraPronunciada = palavraPronunciada;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
