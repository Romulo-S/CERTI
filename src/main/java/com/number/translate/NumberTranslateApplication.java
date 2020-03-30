package com.number.translate;

import com.number.translate.service.TranslateNumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberTranslateApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumberTranslateApplication.class, args);

    }

}
