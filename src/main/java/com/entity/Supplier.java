package com.entity;

import com.entity.products.Product;
import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "Supplier")
public class Supplier {
    @Id
    @Column(name = "supplier_id")
    private int id;

    private String name;
    @ElementCollection
    @CollectionTable(
            name = "Supplier_products",
            joinColumns = @JoinColumn(name = "supplier_id", referencedColumnName = "supplier_id")
    )
    private Collection<Product> products;
    @ManyToOne
    @JoinColumn(name = "warehouse_id", referencedColumnName = "warehouse_id")
    private Warehouse warehouse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}
