package Generics;

import com.sun.org.apache.xpath.internal.operations.Number;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class ObjetosGenericos<T> {

    private T elemento;

    public ObjetosGenericos() {

    }
    public ObjetosGenericos(T elemento){

        this.elemento = elemento;
    }


    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    /**
     * Tornando metodo soma generico
     * @param lista
     * @return
     */
    public double soma(List<? extends Number> lista){
        return lista.stream().mapToDouble(value -> value.getColumnNumber()).sum();
    }

    public void exibeDadosOrdenados(List<? extends String> lista){
        lista.sort(Comparator.comparing(l -> l.length()));
    }

    @Override
    public String toString() {
        return "ObjetosGenericos{" +
                "elemento=" + elemento +
                '}';
    }
}


