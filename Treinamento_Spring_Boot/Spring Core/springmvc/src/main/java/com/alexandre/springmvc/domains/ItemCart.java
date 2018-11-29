package com.alexandre.springmvc.domains;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Version;

@Entity
public class ItemCart extends AbstractEntity{

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    @Version
    private Integer version;

    public ItemCart() {
    }

    public ItemCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
