package me.dapac.market.persistence.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PurchaseProductPK implements Serializable {

    @Column(name = "purchases_id")
    private Integer purchasesId;

    @Column(name = "products_id")
    private Integer productId;

    public Integer getPurchasesId() {
        return purchasesId;
    }

    public void setPurchasesId(Integer purchasesId) {
        this.purchasesId = purchasesId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
