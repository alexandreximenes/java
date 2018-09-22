package br.com.alexandre.app.model.vo;

import br.com.alexandre.app.model.User;

import java.util.List;
import java.util.stream.Collectors;

public class UserVO {

    private String usuario;
    private String nome;
    private boolean admin;

    public UserVO(User user) {
        if(user != null) {
            this.usuario = user.getUsername();
            this.nome = user.getNome();
            this.admin = user.isAdmin();
        }
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public static List<UserVO> toList(List<User> users){
        return users.stream()
                .map(user -> new UserVO(user))
                .collect(Collectors.toList());
    }
}
