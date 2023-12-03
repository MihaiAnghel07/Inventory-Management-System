package com.entity;


import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public abstract class Product {
    @Id
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
