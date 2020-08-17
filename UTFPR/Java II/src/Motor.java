//Alexandre Tiago Ximenes
class Motor{
    int qtdePistao = 0;
    int potencia = 0;

    public Motor(int qtdePistao, int potencia) {
        this.qtdePistao = qtdePistao;
        this.potencia = potencia;
    }

    public int getQtdePistao() {
        return qtdePistao;
    }

    public void setQtdePistao(int qtdePistao) {
        this.qtdePistao = qtdePistao;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "qtdePistao=" + qtdePistao +
                ", potencia=" + potencia +
                '}';
    }
}
