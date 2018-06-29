package bean.estudante;

import model.Estudante;

import javax.inject.Named;
import java.io.Serializable;

@Named("EBean")
public class EstudanteRegistrarBean implements Serializable {

    Estudante estudante = new Estudante();

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }
}
