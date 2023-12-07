package com;


import com.demo.Demo;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class EntryPoint implements CommandLineRunner {

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

    @Override
    public void run(String... args) throws Exception {
        System.out.println("-----------------------------------------------------------------------------------------");
        Demo demo = (Demo) applicationContext.getBean("demo");
        demo.startDemo();
        System.out.println("-----------------------------------------------------------------------------------------");
    }
}