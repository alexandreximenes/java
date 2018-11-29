package com.alexandre.springmvc.domains;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Product extends AbstractEntity{

<<<<<<< HEAD
    @Version
    private Integer version;

    @Temporal(TemporalType.DATE)
    private Date data_insert;

    @OneToOne(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private ItemCart itemCart;
=======
>>>>>>> c5f1c6b4b334dc7311ccd0c3cd8315a0ce8786db
    private String description;
    private BigDecimal price;
    private String imageUrl;

    public Product() {
    }
    public Product(String description, BigDecimal price, String imageUrl) {
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public Product(Integer id, String description, BigDecimal price, String imageUrl) {
        this(description, price, imageUrl);
        this.setId(id);
<<<<<<< HEAD
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
=======
>>>>>>> c5f1c6b4b334dc7311ccd0c3cd8315a0ce8786db
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
<<<<<<< HEAD
                ", version=" + version +
                ", data_insert=" + data_insert +
=======
                "id=" + this.getId() +
                ", version=" + this.getVersion()+
>>>>>>> c5f1c6b4b334dc7311ccd0c3cd8315a0ce8786db
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
