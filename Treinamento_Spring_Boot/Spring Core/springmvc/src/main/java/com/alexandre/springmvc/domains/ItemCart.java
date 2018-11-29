package com.alexandre.springmvc.domains;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class ItemCart extends AbstractEntity{

    @ManyToOne
    private Cart cart;

    @OneToOne
    private Product product;

    public ItemCart() {
    }

    public ItemCart(Cart cart) {
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
