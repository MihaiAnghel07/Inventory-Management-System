package com.entity;

import com.entity.products.Product;
import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Warehouse")
public class Warehouse {

    @Id
    @Column(name = "warehouse_id")
    private int id;

    private String name;

    @ElementCollection
    @CollectionTable(
            name = "Warehouse_products",
            joinColumns = @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    )
    private Collection<Product> products;
    @OneToMany(mappedBy = "warehouse")
    private List<Supplier> suppliers;
    @OneToMany(mappedBy = "warehouse")
    private List<Customer> customers;

}
