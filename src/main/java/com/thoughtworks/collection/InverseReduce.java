package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InverseReduce {

    private Random random = new Random();

    public InverseReduce() {}

    public InverseReduce(Random random) {
        this.random = random;
    }

    public List<Integer> divideToSmaller(int number) {
        ArrayList<Integer> list = new ArrayList<>();
        int i = random.nextInt(3);
        while(number >= i) {
           number = number - i;
           list.add(number);
       }
        return list;
    }
}
