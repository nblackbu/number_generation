package com.example.numbergenerator.service;

import java.util.List;

public class NumberService {
    private final List<String> randomList;
    private final List<String> ordinalList;

    private int countRandom = 0;
    private int countInOrder = 0;

    // сеттеры сделаны для тестирования пограничных значений
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

    public synchronized String getNextCarNumberRandom() {
        if (countRandom < randomList.size()) {
            return randomList.get(countRandom++); }
        else {
            countRandom = 0;
            return randomList.get(countRandom++); }
    }

    public synchronized String getNextCarNumberInOrder(){
        if (countInOrder < ordinalList.size()) {
            return ordinalList.get(countInOrder++); }
        else {
            countInOrder = 0;
            return ordinalList.get(countInOrder++); }
    }
}
