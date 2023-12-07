package com.storage;

import com.entity.Product;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import jakarta.persistence.EntityManager;


@Repository
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class RepositoryImpl {

    public void add(Product product, double amount, EntityManager entityManager) {
        entityManager.persist(product);
    }

    public double remove(Product product, double amount, EntityManager entityManager) {
        return amount;
    }

}
