package com.example.numbergenerator.service;

import java.util.List;

public class NumberService {
    private final List<String> randomList;
    private final List<String> ordinalList;

    private volatile int countRandom = 0;
    private volatile int countInOrder = 0;

    // сеттеры сделаны для тестирования пограничнях значений
    public void setCountRandom(int countRandom) {
        this.countRandom = countRandom;
    }

    public void setCountInOrder(int countInOrder) {
        this.countInOrder = countInOrder;
    }

    public NumberService(List<String> listRandom, List<String> listInOrder) {
        this.randomList = listRandom;
        this.ordinalList = listInOrder;
    }

    public String getNextCarNumberRandom() {
        if (countRandom <= randomList.size()) {
            return randomList.get(countRandom++);
        }
        else {
            return "Random numbers are over"; }
    }

    public String getNextCarNumberInOrder(){
        if (countInOrder < ordinalList.size()) {
            return ordinalList.get(countInOrder++);
        }
        else {
           return "Order numbers are over"; }
    }
}
