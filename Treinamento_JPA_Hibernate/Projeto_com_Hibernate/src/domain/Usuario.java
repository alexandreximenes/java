package domain;

import domain.Veiculo.Veiculo;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "usuario")
    @OneToMany(mappedBy = "usuario", cascade = { CascadeType.ALL})
    private List<Veiculo> veiculos;

    @Embedded
    private Endereco enderecoEmbedded;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_endereco", joinColumns = @JoinColumn(name="id_user"))
    private List<Endereco> enderecos;

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
        this.enderecoEmbedded = endereco;
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

    public Endereco getEnderecoEmbedded() {
        return enderecoEmbedded;
    }

    public void setEnderecoEmbedded(Endereco endereco) {
        this.enderecoEmbedded = endereco;
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

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void setVeiculos(List<Veiculo> veiculos) {
        this.veiculos = veiculos;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "\nid=" + Optional.ofNullable(id).orElse(0) +
                ", \nnome='" + Optional.ofNullable(nome).orElse("") + '\'' +
                ", \nnascimento=" +Optional.ofNullable(nascimento).map(m -> DateFormat.getDateInstance().format(m.getTime()))+
                ", \ndataBatismo=" + Optional.ofNullable(dataBatismo) /*Java 8*/+
                ", \nestadoCivil=" + Optional.ofNullable(estadoCivil) +
                ", \nendereco=" + Optional.ofNullable(enderecoEmbedded) +
                ", \nenderecos=" + Optional.ofNullable(enderecos) +
                ", \nidade=" + Optional.ofNullable(idade) +
                ", \nveiculo=" + Optional.ofNullable(veiculos) +
                '}';
    }
}


