package com.alexandre.springmvc.domains;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart extends AbstractEntity{

    @Version
    private Integer version;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemCart> itensCart = new ArrayList<>();

    public Cart() {
    }

    public Cart(List<ItemCart> itensCart, User user) {
        this.itensCart = itensCart;
        this.user = user;
    }

    @OneToOne
    private User user;

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public List<ItemCart> getItensCart() {
        return itensCart;
    }

    public void setItensCart(List<ItemCart> itensCart) {
        this.itensCart = itensCart;
    }

    public com.alexandre.springmvc.domains.User getUser() {
        return this.user;
    }

    public void setUser(com.alexandre.springmvc.domains.User user) {
        this.user = user;
    }
}
