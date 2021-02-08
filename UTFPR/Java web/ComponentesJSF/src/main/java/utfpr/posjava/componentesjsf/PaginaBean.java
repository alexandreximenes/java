package utfpr.posjava.componentesjsf;

import java.io.Serializable;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@RequestScoped
public class PaginaBean implements Serializable {
    
    public String getPage1(){
        return "tabelas";
    }
    
    public String getLink(String codigo){
        switch (Integer.parseInt(codigo)) {
            case 1:
                return "formularios";
            case 2:
                return "tabelas";
            default:
                return "links";
        }
    }
    
    public String submit() {
        Map<String,String> params;
        params = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String action = params.get("action");
        if ("".equals(action)) {
            action = "links";
        }
        return action;
    }
}
