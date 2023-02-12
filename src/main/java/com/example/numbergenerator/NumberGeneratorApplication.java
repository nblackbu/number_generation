package com.example.numbergenerator;

import com.example.numbergenerator.controller.NumberController;
import com.example.numbergenerator.service.GeneratorNumberService;
import com.example.numbergenerator.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NumberGeneratorApplication {

    public static void main(String[] args) {
        SpringApplication.run(NumberGeneratorApplication.class, args);
    }
}
