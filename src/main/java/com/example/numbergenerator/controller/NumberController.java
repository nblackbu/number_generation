package com.example.numbergenerator.controller;

import com.example.numbergenerator.service.NumberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/number", produces="text/plain")
public class NumberController {
    @Autowired
    private NumberService numberService;

    @GetMapping("/random")
    public String random(){
        return numberService.getNextCarNumberRandom();
    }

    @GetMapping("/next")
    public String next(){
        return numberService.getNextCarNumberInOrder();
    }
}
