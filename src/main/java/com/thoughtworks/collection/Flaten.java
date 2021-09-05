package com.thoughtworks.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Flaten {

    Integer[][] array;
    public Flaten(Integer[][] array) {
        this.array = array;
    }

    public List<Integer> transformToOneDimesional() {
        Object[] objects = Arrays.stream(array).flatMap(Arrays::stream).toArray();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (Object object : objects) {
            arrayList.add((Integer) object);
        }
        return  arrayList;
    }

    public List<Integer> transformToUnrepeatedOneDimesional() {
        return transformToOneDimesional().stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
