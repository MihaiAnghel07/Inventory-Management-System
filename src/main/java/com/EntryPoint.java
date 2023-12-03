package com;


import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class EntryPoint {

    static {
        PropertyConfigurator.configure(EntryPoint.class.getResource("/log4j.properties"));
    }

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(EntryPoint.class, args);
    }
}