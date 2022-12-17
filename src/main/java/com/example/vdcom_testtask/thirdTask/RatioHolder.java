package com.example.vdcom_testtask.thirdTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RatioHolder {
    private static final int FIRST_NUMBER_OF_RATIO_INDEX = 0;
    private static final int SECOND_NUMBER_OF_RATIO_INDEX = 3;
    private static final int FIRST_VALUE_OF_RATIO_INDEX = 1;
    private static final int SECOND_VALUE_OF_RATIO_INDEX = 4;
    private final List<Ratio> list;

    public RatioHolder() {
        list = new ArrayList<>(11);
/*
        String ratio1String = "1024 byte = 1 kilobyte";
        String ratio2String = "2 bar = 12 ring";
        String ratio3String = "16.8 ring = 2 pyramid";
        String ratio4String = "4 hare = 1 cat";
        String ratio5String = "5 cat = 0.5 giraffe";
        //String ratio6String = "8 bit = 1 byte";
        String ratio6String = "1 byte = 8 bit";
        String ratio7String = "15 ring = 2.5 bar";

        String ratio8String = "1 pyramid = ? bar";
        String ratio9String = "1 giraffe = ? hare";
        String ratio10String = "0.5 byte = ? cat";
        String ratio11String = "2 kilobyte = ? bit";

        createRatio(ratio1String);
        createRatio(ratio2String);
        createRatio(ratio3String);
        createRatio(ratio4String);
        createRatio(ratio5String);
        createRatio(ratio6String);
        createRatio(ratio7String);
        createRatio(ratio8String);
        createRatio(ratio9String);
        createRatio(ratio10String);
        createRatio(ratio11String);
 */
    }

    public Ratio createRatio(String line) {
        String[] array = line.split(" ");
        String value1 = array[FIRST_NUMBER_OF_RATIO_INDEX];
        String value2 = array[SECOND_NUMBER_OF_RATIO_INDEX];
        String name1 = array[FIRST_VALUE_OF_RATIO_INDEX];
        String name2 = array[SECOND_VALUE_OF_RATIO_INDEX];
        Ratio ratio = new Ratio();
        if (searchRatioByName1(name1) && !searchRatioByName1(name2)) {
            ratio.setValue1(value2);
            ratio.setValue2(value1);
            ratio.setName1(name2);
            ratio.setName2(name1);
        } else {
            ratio.setValue1(value1);
            ratio.setValue2(value2);
            ratio.setName1(name1);
            ratio.setName2(name2);
        }
        if (value2.equals("?")) {
            ratio.setSearchable(true);
        }
        list.add(ratio);
        return ratio;
    }

    public boolean searchRatioByName1(String value) {
        for (Ratio ratio : list) {
            if (ratio.getName1().equals(value) && !ratio.getValue2().equals("?")) {
                return true;
            }
        }
        return false;
    }

    public Optional<Ratio> searchRatioByName2(String value) {
        for (Ratio ratio : list) {
            if (ratio.getName2().equals(value)) {
                return Optional.of(ratio);
            }
        }
        return Optional.empty();
    }

    public List<Ratio> getList() {
        return list;
    }
}