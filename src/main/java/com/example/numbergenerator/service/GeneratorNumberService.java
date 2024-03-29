package com.example.numbergenerator.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class GeneratorNumberService {

    private final String[] letters = {"A", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    private final String rus = "116 RUS";

    public List<String> listGeneration() {

        String str1 = null;
        List<String> list1 = new ArrayList<>();

            for (int y = 0; y < letters.length; y++) {
                for (int z = 0; z < letters.length; z++) {
                    for (int x = 0; x < letters.length; x++) {
                        for (int i = 0; i >= 0 && i <= 999; i++) {
                            if (i >= 0 && i <= 9) str1 = "00" + i;
                            if (i >= 10 && i <= 99) str1 = "0" + i;
                            if (i >= 100 && i <= 999) str1 = "" + i;
                            String rez = letters[y] + str1 + letters[z] + letters[x] + " " + rus;
                            list1.add(rez);
                        }
                    }
                }
            }
        return list1;
    }

    public List<String> returnAutoMobileNumberRandom() {
        List<String> randomList = listGeneration();
        Collections.shuffle(randomList);
        return randomList;
    }
    public List<String> returnAutoMobileNumberInOrder() {
        List<String> ordinalList = listGeneration();
        return ordinalList;
    }
}
