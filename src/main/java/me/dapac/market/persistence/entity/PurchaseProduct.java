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
    @MapsId("purchasesId")
    @JoinColumn(name = "purchases_id", insertable = false, updatable = false)
    private PurchaseTable purchase;

    @ManyToOne
    @JoinColumn(name = "products_id", insertable = false, updatable = false)
    private ProductTable product;

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

    public PurchaseTable getPurchase() {
        return purchase;
    }

    public void setPurchase(PurchaseTable purchaseTable) {
        this.purchase = purchaseTable;
    }

    public ProductTable getProduct() {
        return product;
    }

    public void setProduct(ProductTable product) {
        this.product = product;
    }
}
