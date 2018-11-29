package com.alexandre.springmvc.domains;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product extends AbstractEntity{

    @Version
    private Integer version;

    @Temporal(TemporalType.DATE)
    private Date data_insert;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private ItemCart itemCart;
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Product() {
    }
    public Product(String description, BigDecimal price, String imageUrl) {
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.data_insert = new Date();
    }

    public Product(Integer id, String description, BigDecimal price, String imageUrl) {
        this(description, price, imageUrl);
        this.setId(id);
    }

    public ItemCart getItemCart() {
        return itemCart;
    }

    public void setItemCart(ItemCart itemCart) {
        this.itemCart = itemCart;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Date getData_insert() {
        return data_insert;
    }

    public void setData_insert(Date data_insert) {
        this.data_insert = data_insert;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Product{" +
                ", version=" + version +
                ", data_insert=" + data_insert +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
