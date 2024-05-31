package ru.enlistment_office.base;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class EnlistmentOfficeApplication {

    public static void main(String[] args) {
        SpringApplication.run(EnlistmentOfficeApplication.class, args);
    }

}
