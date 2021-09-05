package com.thoughtworks.collection;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.*;
import java.util.stream.Collectors;

public class Reduce {

    List<Integer> arrayList;

    public Reduce(List<Integer> arrayList) {
        this.arrayList = arrayList;
    }

    public int getMaximum() {
        OptionalInt max = arrayList.stream().mapToInt(i -> i).max();
        return max.isPresent() ? max.getAsInt() : 0;
//        return Collections.max(arrayList);
    }

    public double getMinimum() {
        OptionalInt min = arrayList.stream().mapToInt(i -> i).min();
        return min.isPresent() ? min.getAsInt() : 0;
//        return Collections.min(arrayList);
    }

    public double getAverage() {
        OptionalDouble average = arrayList.stream().mapToInt(i -> i).average();
        return average.isPresent() ? average.getAsDouble() : 0;
    }

    public double getOrderedMedian() {
        List<Integer> collect = arrayList.stream().sorted().collect(Collectors.toList());
        int anInt = collect.size() / 2;
        if (collect.size() % 2 == 0) {
            return (double) (collect.get(anInt - 1) + collect.get(anInt)) / 2;
        } else {
            return collect.get(anInt);
        }
    }

    public int getFirstEven() {
        Optional<Integer> first = arrayList.stream().filter(i -> i % 2 == 0).limit(1).findFirst();
        return first.orElse(0);
    }

    public int getIndexOfFirstEven() {
        int firstEven = getFirstEven();
        return arrayList.indexOf(firstEven);
    }

    public boolean isEqual(List<Integer> arrayList) {
        return this.arrayList.containsAll(arrayList) && arrayList.containsAll(this.arrayList);
    }

    public Double getMedianInLinkList(SingleLink singleLink) {
        Integer node = (Integer) singleLink.getNode(6);
        Integer node1 = (Integer) singleLink.getNode(7);
        if (node1 == null) {
            return Double.valueOf(node);
        } else {
            return Double.valueOf(node + node1) / 2;
        }
    }

    public int getLastOdd() {
        return arrayList.stream().filter(i -> i % 2 == 1).reduce((first,second) -> second).orElse(0);
    }

    public int getIndexOfLastOdd() {
        int lastOdd = getLastOdd();
        return arrayList.indexOf(lastOdd);
    }
}
