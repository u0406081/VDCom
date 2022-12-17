package com.example.vdcom_testtask.thirdTask;

import java.util.Optional;

public class Calculator {
    private Double firstNumber;
    private Double secondNumber;
    private Double thirdNumber;
    private Double fourthNumber;
    private final RatioHolder ratioHolder;
    private String firstValue;
    private String secondValue;

    public Calculator(RatioHolder ratioHolder) {
        this.ratioHolder = ratioHolder;
    }

    public void unwind(Ratio ratio, int level) throws Exception {
        if (level == 1) {
            if (Double.parseDouble(ratio.getValue2()) > 1) {
                firstNumber = Double.parseDouble(ratio.getValue2());
                secondNumber = Double.parseDouble(ratio.getValue1());
            } else {
                firstNumber = Double.parseDouble(ratio.getValue1());
                secondNumber = Double.parseDouble(ratio.getValue2());
            }
            Optional<Ratio> level2Ratio = ratioHolder.searchRatioByName2(ratio.getName1());
            if (level2Ratio.isPresent()) {
                unwind(level2Ratio.get(), 2);
            } else {
                throw new Exception("123");
            }

        } else if (level == 2) {
            if (Double.parseDouble(ratio.getValue2()) > Double.parseDouble(ratio.getValue1())) {
                thirdNumber = Double.parseDouble(ratio.getValue2());
            } else {
                thirdNumber = Double.parseDouble(ratio.getValue1());
            }
        }
    }

    public void calculate() {
        Double result = firstNumber / secondNumber * thirdNumber * fourthNumber;
        System.out.println(fourthNumber.intValue() + " " + firstValue + " = " + String.format("%.1f", result) +
                " " + secondValue);
    }

    public void setFirstValue(String firstValue) {
        this.firstValue = firstValue;
    }

    public void setSecondValue(String secondValue) {
        this.secondValue = secondValue;
    }

    public void setFourthNumber(String fourthNumber) {
        this.fourthNumber = Double.parseDouble(fourthNumber);
    }
}
