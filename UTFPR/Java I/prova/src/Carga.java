/**
 * Alexandre Tiago Ximenes
 */

public final class Carga extends Veiculo implements Calc{

    private int tara;
    private int cargaMax;

    public Carga() {
    }

    public Carga(String placa, String marca, String modelo, String cor, int qtdeDeRodas, int velocMax, Motor motor, int tara, int cargaMax) {
        super(placa, marca, modelo, cor, qtdeDeRodas, velocMax, motor);
        this.tara = tara;
        this.cargaMax = cargaMax;
    }

    public int getTara() {
        return tara;
    }

    public void setTara(int tara) {
        this.tara = tara;
    }

    public int getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(int cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public long calcVel() {
        return calcular(super.getVelocMax());
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nTara: " + tara +
                "\nCarga Maxima: "+cargaMax +
                "\nVelocidade Maxima: " + this.calcVel() + " Cm/h";
    }
    public void addVelocMax(long velocMax) {
        try {
            super.setVelocMax(velocMax);
        } catch (VelocException e) {
            System.out.println(e.getMessage());
            this.addVelocMax(120);
            System.out.println("Velocidade padrão: "+this.getVelocMax());
        }

    }
    @Override
    public long calcular(long veloMax) {
        return veloMax * 10000000;
    }
}
