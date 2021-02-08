import java.io.Serializable;
import java.util.Objects;

public class Voto implements Serializable {

    private static final long serialID = 1L;

    private String nome;
    private Integer votos;

    public Voto(String nome, int votos) {
        this.nome = nome;
        this.votos = votos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voto voto = (Voto) o;
        return Objects.equals(nome, voto.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVotos() {
        return votos;
    }

    public void setVotos(Integer votos) {
        this.votos = votos;
    }

    @Override
    public String toString() {
        return "Voto: nome: "+ nome + " com (" + votos + ") voto(s)";
    }
}
