//Alexandre Tiago Ximenes
class Veiculo{
    String placa = "";
    String marca = "";
    String modelo = "";
    float velocMax = 0;
    Motor Motor;

    public Veiculo(String placa, String marca, String modelo, float velocMax, Motor motor) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.velocMax = velocMax;
        Motor = motor;
    }

    public Veiculo() {
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", velocMax=" + velocMax +
                ", Motor=" + Motor +
                '}';
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getVelocMax() {
        return velocMax;
    }

    public void setVelocMax(float velocMax) {
        this.velocMax = velocMax;
    }

    public Motor getMotor() {
        return Motor;
    }

    public void setMotor(Motor motor) {
        Motor = motor;
    }
}
