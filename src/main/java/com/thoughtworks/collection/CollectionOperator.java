package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionOperator {
    public List<Integer> getListByInterval(int left, int right) {
        ArrayList<Integer> list = new ArrayList<>();
        int max = Math.max(left, right);
        int min = Math.min(left, right);
        for (int i = min; i <= max; i++) {
            list.add(i);
        }
        return left > right ? list.stream().sorted((i1, i2) -> i2 - i1).collect(Collectors.toList()) : list;
    }

    public List<Integer> getEvenListByIntervals(int left, int right) {
        List<Integer> listByInterval = getListByInterval(left, right);
        return listByInterval.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    public List<Integer> popEvenElements(int[] array) {
        ArrayList<Integer> list = getList(array);
        return list.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    private ArrayList<Integer> getList(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : array) {
            list.add(i);
        }
        return list;
    }

    public int popLastElement(int[] array) {
        return array[array.length - 1];
    }

    public List<Integer> popCommonElement(int[] firstArray, int[] secondArray) {
        ArrayList<Integer> firstList = getList(firstArray);
        ArrayList<Integer> secondList = getList(secondArray);
        return firstList.stream()
                .filter(secondList::contains)
                .collect(Collectors.toList());
    }

    public List<Integer> addUncommonElement(Integer[] firstArray, Integer[] secondArray) {
        List<Integer> firstList = Arrays.asList(firstArray);
        List<Integer> secondList = Arrays.asList(secondArray);
        List<Integer> collect = secondList.stream()
                .filter(i -> !firstList.contains(i))
                .collect(Collectors.toList());
        firstList.addAll(collect);
        return firstList;
    }
}
