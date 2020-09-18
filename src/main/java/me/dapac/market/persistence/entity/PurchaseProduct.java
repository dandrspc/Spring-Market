package me.dapac.market.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "purchases_products")
public class PurchaseProduct {

    @EmbeddedId
    private PurchaseProductPK id;

    private Integer quantity;
    private Double total;
    private Boolean state;

    @ManyToOne
    @JoinColumn(name = "purchases_id", insertable = false, updatable = false)
    private PurchaseTable purchaseTable;

    @ManyToOne
    @JoinColumn(name = "product_id", insertable = false, updatable = false)
    private ProductTable productTable;

    public PurchaseProductPK getId() {
        return id;
    }

    public void setId(PurchaseProductPK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
}
