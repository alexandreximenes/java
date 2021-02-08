package utfpr.posjava.olamundojsf;


import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class HelloBean implements Serializable {
    private String mensagem;
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String msg) {
        this.mensagem = msg;
    }
}
