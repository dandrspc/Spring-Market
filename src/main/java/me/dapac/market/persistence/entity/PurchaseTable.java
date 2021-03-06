package me.dapac.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "purchases")
public class PurchaseTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "clients_id")
    private String clientId;

    private LocalDateTime date;
    @Column(name = "payment_method")

    private String paymentMethod;
    private String comment;
    private String state;

    @ManyToOne
    @JoinColumn(name = "clients_id", insertable = false, updatable = false)
    private ClientTable client;

    @OneToMany(mappedBy = "purchase", cascade = {CascadeType.ALL})
    private List<PurchaseProduct> products;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public ClientTable getClient() {
        return client;
    }

    public void setClient(ClientTable client) {
        this.client = client;
    }

    public List<PurchaseProduct> getProducts() {
        return products;
    }

    public void setProducts(List<PurchaseProduct> products) {
        this.products = products;
    }
}
