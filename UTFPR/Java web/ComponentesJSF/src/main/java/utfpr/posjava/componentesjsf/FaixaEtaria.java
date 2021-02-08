/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.posjava.componentesjsf;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean
@SessionScoped
public class FaixaEtaria implements Serializable {
    public String label;
    public String value;

    public FaixaEtaria(){
    }
    
    public FaixaEtaria(String label, String value){
        this.label = label;
        this.value = value;
    }

    public String getLabel(){
        return label;
    }

    public String getValue(){
        return value;
    }
}
