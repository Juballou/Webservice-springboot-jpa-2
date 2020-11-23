package com.fafram.webserviceexercicio.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tbphone")
public class Phone implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String type;
    private Integer number;

    @ManyToOne
    @JoinTable(name = "tb_phone_customer", joinColumns = @JoinColumn(name = "phone_id"),
            inverseJoinColumns = @JoinColumn(name = "customer_id"))
    private Set<Customer> customers = new HashSet<>();

    public Phone() {
    }

    public Phone(Long id, String type, Integer number) {
        this.id = id;
        this.type = type;
        this.number = number;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }


    public Integer getNumber() {
        return number;
    }

    public Set<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Phone phone = (Phone) o;
        return id.equals(phone.id) &&
                type.equals(phone.type) &&
                number.equals(phone.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, number);
    }
}
