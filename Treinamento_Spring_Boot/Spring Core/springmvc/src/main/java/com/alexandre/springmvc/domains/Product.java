package com.alexandre.springmvc.domains;

import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
public class Product extends AbstractEntity{

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
                "id=" + this.getId() +
                ", version=" + this.getVersion()+
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
