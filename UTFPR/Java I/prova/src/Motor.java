/**
 * Alexandre Tiago Ximenes
 */

public class Motor {

    private int qtdPistoes;
    private int potencia;

    public Motor(int qtdPistoes, int potencia) {
        this.qtdPistoes = qtdPistoes;
        this.potencia = potencia;
    }

    public int getQtdPistoes() {
        return qtdPistoes;
    }

    public void setQtdPistoes(int qtdPistoes) {
        this.qtdPistoes = qtdPistoes;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "\nQuatidade de Pistoes do motor: " + qtdPistoes +
                "\npotencia do motor: " + potencia;
    }
}
