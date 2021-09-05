package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Add {
    public int getSumOfEvens(int leftBorder, int rightBorder) {
        return getSum(leftBorder, rightBorder, 0);
    }

    public int getSumOfOdds(int leftBorder, int rightBorder) {
        return getSum(leftBorder, rightBorder, 1);
    }

    private int getSum(int leftBorder, int rightBorder, int flag) {
        int sum = 0;
        int max = Math.max(leftBorder, rightBorder);
        int min = Math.min(leftBorder, rightBorder);
        for (int i = min; i <= max; i++) {
            if (i % 2 == flag) {
                sum = sum + i;
            }
        }
        return sum;
    }

    public int getSumTripleAndAddTwo(List<Integer> arrayList) {
        return arrayList.stream()
                .mapToInt(i -> i * 3 + 2)
                .sum();
    }

    public List<Integer> getTripleOfOddAndAddTwo(List<Integer> arrayList) {
         return arrayList.stream().map(i -> {
            if (i % 2 == 1){
                i = i * 3 + 2;
            }
            return i;
        }).collect(Collectors.toList());
    }

    public int getSumOfProcessedOdds(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(i -> i % 2 == 1)
                .mapToInt(i -> i * 3 + 5).sum();
    }

    public double getMedianOfEven(List<Integer> arrayList) {
        List<Integer> collect = arrayList.stream()
                .sorted()
                .collect(Collectors.toList());
        int size = collect.size();
        return size % 2 == 0 ? (double) (collect.get(size / 2 - 1) + collect.get(size / 2)) / 2
                             : (double) collect.get(size / 2);
    }

    public double getAverageOfEven(List<Integer> arrayList) {
        return arrayList.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.averagingInt(i -> i));
    }

    public boolean isIncludedInEvenIndex(List<Integer> arrayList, Integer specialElement) {
        List<Integer> list = arrayList.stream()
                .filter(i -> i % 2 == 0)
                .filter(i -> i.equals(specialElement))
                .collect(Collectors.toList());
        return list.size() != 0;
    }

    public List<Integer> getUnrepeatedFromEvenIndex(List<Integer> arrayList) {
        return arrayList.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }

    public List<Integer> sortByEvenAndOdd(List<Integer> arrayList) {
        List<Integer> collectEven = arrayList.stream()
                .filter(i -> i % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        List<Integer> collectOdd = arrayList.stream()
                .filter(i -> i % 2 == 1)
                .sorted((i1,i2) -> i2 - i1)
                .collect(Collectors.toList());
        collectEven.addAll(collectOdd);
        return collectEven;
    }

    public List<Integer> getProcessedList(List<Integer> arrayList) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i < arrayList.size(); i++) {
            list.add((arrayList.get(i - 1) + arrayList.get(i)) * 3);
        }
        return list;
    }
}
