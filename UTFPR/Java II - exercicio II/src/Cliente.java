
import java.io.Serializable;

public class Cliente implements Serializable {

	
	/***INSTANCE VARIABLE***/
	private static final long serialVersionUID = 1L;
	private String nome;
    private String fone;
    private int idade;


    /***CONSTRUCTORS***/
    Cliente() {
        nome = "não informado";
        fone = "não informado";
        idade = 0;
    }

    //
    public Cliente(String nm, String fon, int id) {
        nome = nm;
        fone = fon;
        idade = id;
    }


    /***GETTERS AND SETTERS***/
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
     * @return the fone
     */
    public String getFone() {
        return fone;
    }

    /**
     * @param fone the fone to set
     */
    public void setFone(String fone) {
        this.fone = fone;
    }

    /**
     * @return the idade
     */
    public int getIdade() {
        return idade;
    }

    /**
     * @param idade the idade to set
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /***HELPER METHODS***/
    public boolean Maior() {
    	if (getIdade() >= 18) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    @Override
    public String toString() {
    	return "Cliente [nome=" + nome + ", fone=" + fone + ", idade=" + idade + "]";
    }
}