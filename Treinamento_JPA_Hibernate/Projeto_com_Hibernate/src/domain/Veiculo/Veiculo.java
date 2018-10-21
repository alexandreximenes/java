package domain.Veiculo;

import domain.Usuario;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Veiculo implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String modelo;
    private LocalDate ano;

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

    public Veiculo() {
    }

    public Veiculo(String modelo, LocalDate ano, Usuario usuario) {
        this.modelo = modelo;
        this.ano = ano;
        this.usuario = usuario;
    }

    public Veiculo(String modelo, LocalDate ano) {
        this(modelo, ano, null);
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public LocalDate getAno() {
        return ano;
    }

    public void setAno(LocalDate ano) {
        this.ano = ano;
    }

    //@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    //@JoinColumn(unique = true)
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
