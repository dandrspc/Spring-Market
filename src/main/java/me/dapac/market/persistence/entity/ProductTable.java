package me.dapac.market.persistence.entity;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class ProductTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @Column(name = "categories_id")
    private Integer categoryId;

    @Column(name = "bar_code")
    private  String barCode;

    @Column(name = "sale_price")
    private Double salePrice;

    @Column(name = "stock_quantity")
    private Integer stockQty;

    private Boolean state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "categories_id", nullable = false, insertable = false, updatable = false)
    private CategoryTable category;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(Double salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getStockQty() {
        return stockQty;
    }

    public void setStockQty(Integer stockQty) {
        this.stockQty = stockQty;
    }

    public Boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public CategoryTable getCategory() {
        return category;
    }

    public void setCategory(CategoryTable category) {
        this.category = category;
    }
}
