package me.dapac.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categories")
public class CategoryTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private  String description;

    private  Boolean state;

    @OneToMany(mappedBy = "category")
    private List<ProductTable> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public List<ProductTable> getProducts() {
        return products;
    }

    public void setProducts(List<ProductTable> products) {
        this.products = products;
    }
}
