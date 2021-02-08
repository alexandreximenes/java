package utfpr.posjava.componentesjsf;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class UsuarioBean implements Serializable {
    private int codigo;
    private String login;
    private String senha;
    
    private String nome;
    private int idade;
    private String descricao;
    
    private String sexo;
    private String corFav;
    private String faixaEtaria;
    
    private boolean lembrarSenha;
    private String[] estiloMusical;
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    public int getIdade(){
        return idade;
    }
    
    public void setIdade(int idade) {
        this.idade = idade;
    }
    
    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    
    public boolean getIsLogged() {
        return !(this.login == null || "".equals(this.login));
    }

    /**
     * @return the sexo
     */
    public String getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the corFav
     */
    public String getCorFav() {
        return corFav;
    }

    /**
     * @param corFav the corFav to set
     */
    public void setCorFav(String corFav) {
        this.corFav = corFav;
    }

    /**
     * @return the faixaEtaria
     */
    public String getFaixaEtaria() {
        return faixaEtaria;
    }

    /**
     * @param faixaEtaria the faixaEtaria to set
     */
    public void setFaixaEtaria(String faixaEtaria) {
        this.faixaEtaria = faixaEtaria;
    }
    
    //Exemplo utilizando MAP
    private static final Map<String,Object> LISTACORES;
    static{
            LISTACORES = new LinkedHashMap<>();
            LISTACORES.put("1 - Vermelho", "Vermelho");
            LISTACORES.put("2 - Verde", "Verde");
            LISTACORES.put("3 - Azul", "Azul");
            LISTACORES.put("4 - Amarelo", "Amarelo");
            LISTACORES.put("5 - Preto", "Preto");
            LISTACORES.put("6 - Branco", "Branco");
    }
    public Map<String,Object> getListaCores() {
        return LISTACORES;
    }
    
    
    public FaixaEtaria[] faixaEtariaList;
    public FaixaEtaria[] getListaFaixaEtaria() {
        faixaEtariaList = new FaixaEtaria[4];
        faixaEtariaList[0] = new FaixaEtaria("Criança", "0-12");
        faixaEtariaList[1] = new FaixaEtaria("Jovem", "13-21");
        faixaEtariaList[2] = new FaixaEtaria("Adulto", "21-70");
        faixaEtariaList[3] = new FaixaEtaria("Idoso", "70-110");

        return faixaEtariaList;
    }

    /**
     * @return the lembrarSenha
     */
    public boolean isLembrarSenha() {
        return lembrarSenha;
    }

    /**
     * @param lembrarSenha the lembrarSenha to set
     */
    public void setLembrarSenha(boolean lembrarSenha) {
        this.lembrarSenha = lembrarSenha;
    }

    /**
     * @return the estiloMusical
     */
    public String[] getEstiloMusical() {
        return estiloMusical;
    }

    /**
     * @param estiloMusical the estiloMusical to set
     */
    public void setEstiloMusical(String[] estiloMusical) {
        this.estiloMusical = estiloMusical;
    }
    
    
    public String[] getListaEstiloMusical() {
        String[] estilos = new String[5];
        estilos[0] = "Clássica";
        estilos[1] = "Blues";
        estilos[2] = "Jazz";
        estilos[3] = "Pop";
        estilos[4] = "Rock";

        return estilos;
    }
}
