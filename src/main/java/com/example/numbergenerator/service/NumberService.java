package com.example.numbergenerator.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

public class NumberService {
    private final List<String> listRandom;
    private final List<String> listInOrder;

    private int countRandom = 0;
    private int countInOrder = 0;

    public NumberService(List<String> listRandom, List<String> listInOrder) {
        this.listRandom = listRandom;
        this.listInOrder = listInOrder;
    }


    public String getNextCarNumberRandom() {
        if (countRandom < listRandom.size()) {
            return listRandom.get(countRandom++);
        }
        else {
            return "Random numbers are over"; }
    }

    public String getNextCarNumberInOrder(){
        if (countInOrder < listInOrder.size()) {
            return listInOrder.get(countInOrder++);
        }
        else {
           return "Order numbers are over";
        }
    }
}
