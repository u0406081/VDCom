package com.example.vdcom_testtask.thirdTask;

import java.util.Optional;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        RatioHolder ratioHolder = new RatioHolder();
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String enteredString = scanner.nextLine();
            if(enteredString.equals("calculate")) {
                break;
            }
            ratioHolder.createRatio(enteredString);
        }
        main.start(ratioHolder);
    }

    public void start(RatioHolder ratioHolder) {
        Calculator calculator = new Calculator(ratioHolder);
        ratioHolder.getList().stream().filter((x) -> x.isSearchable()).forEach(
                (ratio) -> {
                    calculator.setFirstValue(ratio.getName1());
                    calculator.setSecondValue(ratio.getName2());
                    calculator.setFourthNumber(ratio.getValue1());
                    Optional<Ratio> findedRatio = ratioHolder.searchRatioByName2(ratio.getName1());
                    try {
                        calculator.unwind(findedRatio.get(), 1);
                        calculator.calculate();
                    } catch (Exception e) {
                        System.out.println("Conversion not possible");
                    }
                }
        );
    }
}