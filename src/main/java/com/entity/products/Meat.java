package com.entity.products;


import jakarta.persistence.Entity;

@Entity
public class Meat extends Product {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }
}
