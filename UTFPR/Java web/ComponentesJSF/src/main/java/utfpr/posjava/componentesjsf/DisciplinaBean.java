/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.posjava.componentesjsf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class DisciplinaBean implements Serializable {
    private String codigo;
    private String nome;
    private int semestre;
    private int cargaHoraria;

    public DisciplinaBean(){
    }
    
    public DisciplinaBean(String codigo, String nome, int semestre, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.semestre = semestre;
        this.cargaHoraria = cargaHoraria;
    }
    
    /**
     * @return the codigo
     */
    public String getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

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
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the cargaHoraria
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }

    /**
     * @param cargaHoraria the cargaHoraria to set
     */
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
    
    private static final ArrayList<DisciplinaBean> DISCIPLINAS = 
			new ArrayList<DisciplinaBean>(
			Arrays.asList(
                            new DisciplinaBean("POR", "Português", 1, 6),
                            new DisciplinaBean("MAT", "Matemática", 1, 8),
                            new DisciplinaBean("HIS", "História", 1, 4), 
                            new DisciplinaBean("GEO", "Geografia", 1, 4)
                        ));
    
    public ArrayList<DisciplinaBean> getDisciplinas() {
        return DISCIPLINAS;
    }
}
