package me.dapac.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clients")
public class ClientTable {

    @Id
    private String id;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    private String phone;

    private String address;

    private String email;

    @OneToMany(mappedBy = "client")
    private List<PurchaseTable> purchaseTables;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
