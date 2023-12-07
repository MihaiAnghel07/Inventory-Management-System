package com.demo;

import com.entity.Meat;
import com.entity.Potatoes;
import com.entity.Sugar;
import com.entity.Tomatoes;
import com.storage.RepositoryImpl;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;


import java.util.Objects;

@Service
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class Demo {

    @Autowired
    private Environment environment;
    @Autowired
    private RepositoryImpl repository;

    public void startDemo() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistenceUnits.TABLE_PER_CLASS");
        init(emf.createEntityManager());

        emf.close();
    }

    private void init(EntityManager entityManager) {
        entityManager.getTransaction().begin();

        double meatAmount = Double.parseDouble(Objects.requireNonNull(environment.getProperty("meat")));
        double potatoesAmount = Double.parseDouble(Objects.requireNonNull(environment.getProperty("potatoes")));
        double sugarAmount = Double.parseDouble(Objects.requireNonNull(environment.getProperty("sugar")));
        double tomatoesAmount = Double.parseDouble(Objects.requireNonNull(environment.getProperty("tomatoes")));

        Meat meat = new Meat();
        meat.setId(1);
        meat.setAmount(meatAmount);
        meat.setTest("test");
        entityManager.persist(meat);
//        repository.add(meat, meatAmount, entityManager);

//        Potatoes potatoes = new Potatoes();
//        potatoes.setId(2);
////        repository.add(potatoes, potatoesAmount, entityManager);
//
//        Sugar sugar = new Sugar();
//        sugar.setId(3);
////        repository.add(sugar, sugarAmount, entityManager);
//
//        Tomatoes tomatoes = new Tomatoes();
//        tomatoes.setId(4);
////        repository.add(tomatoes, tomatoesAmount, entityManager);
//
        entityManager.getTransaction().commit();
    }
}
