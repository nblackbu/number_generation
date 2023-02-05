package com.example.numbergenerator.configuration;

import com.example.numbergenerator.service.GeneratorNumberService;
import com.example.numbergenerator.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NumberConfiguration {
    @Autowired
    private GeneratorNumberService carNumberListGeneratorService;

    @Bean
    public NumberService random() {
        return new NumberService(carNumberListGeneratorService.returnAutoMobileNumberRandom(), carNumberListGeneratorService.returnAutoMobileNumberInOrder());
    }
}
