package domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String nome;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_nascimento")
    private Calendar nascimento;
    @Column(name = "data_batismo")
    private LocalDate dataBatismo;
    @Enumerated(EnumType.STRING)
    @Column(name = "estado_civil")
    private EstadoCivil estadoCivil;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "usuario")
    private List<PalavrasInocentes> palavrasInocentes;

    @Transient
    private Integer idade;

    public Usuario() {
    }

    public Usuario(String nome, Calendar nascimento, LocalDate dataBatismo, EstadoCivil estadoCivil, Endereco endereco, List<PalavrasInocentes> palavrasInocentes, Integer idade) {
        this.nome = nome;
        this.nascimento = nascimento;
        this.dataBatismo = dataBatismo;
        this.estadoCivil = estadoCivil;
        this.endereco = endereco;
        this.palavrasInocentes = palavrasInocentes;
        this.idade = idade;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getNascimento() {
        return nascimento;
    }

    public void setNascimento(Calendar nascimento) {
        this.nascimento = nascimento;
    }

    public LocalDate getDataBatismo() {
        return dataBatismo;
    }

    public void setDataBatismo(LocalDate dataBatismo) {
        this.dataBatismo = dataBatismo;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<PalavrasInocentes> getPalavrasInocentes() {
        return palavrasInocentes;
    }

    public void setPalavrasInocentes(List<PalavrasInocentes> palavrasInocentes) {
        this.palavrasInocentes = palavrasInocentes;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }
}


