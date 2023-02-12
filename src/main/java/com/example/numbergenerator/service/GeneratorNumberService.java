package com.example.numbergenerator.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class GeneratorNumberService {

    private final String[] letters = {"A", "Е", "Т", "О", "Р", "Н", "У", "К", "Х", "С", "В", "М"};

    public synchronized List<String> listGenerator() {

        String str1 = null;
        List<String> list1 = new ArrayList<>();

        for (int y = 0; y < letters.length; y++) {
            for (int z = 0; z < letters.length; z++) {
                for (int x = 0; x < letters.length; x++) {
                    for (int i = 0; i >= 0 && i <= 999; i++) {
                        if (i >= 0 && i <= 9) str1 = "00" + i;
                        if (i >= 10 && i <= 99) str1 = "0" + i;
                        if (i >= 100 && i <= 999) str1 = "" + i;
                        String rez = letters[x] + str1 + letters[z] + letters[y] + " 116 RUS";
                        list1.add(rez);
                    }
                }
            }
        }
        return list1;
    }

    public List<String> returnAutoMobileNumberRandom() {
        List<String> listRandom = listGenerator();
        Collections.shuffle(listRandom);
        return listRandom;
    }
    public List<String> returnAutoMobileNumberInOrder() {
        List<String> listInOrder = listGenerator();
        return listInOrder;
    }
}
