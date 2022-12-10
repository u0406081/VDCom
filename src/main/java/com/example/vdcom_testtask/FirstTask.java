package com.example.vdcom_testtask;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstTask {
    public static void main(String[] args) {

        FirstTask firstTask = new FirstTask();

        //1-й вариант
        firstTask.print(15);

        //2-й вариант
        Stream.iterate(1, x -> x + 1)
                .limit(15)
                .forEach(firstTask::whatIsMultipleOf);

        //3-й вариант
        IntStream.range(1, 16)
                .forEach(firstTask::whatIsMultipleOf);
    }

    public void print(int number) {
        for (int i = 1; i < number + 1; i++) {
            whatIsMultipleOf(i);
        }
    }

    public void whatIsMultipleOf(int number) {
        if ((number % 3 == 0) && (number % 5 == 0)) {
            System.out.println("number = " + number + " FooBar");
            return;
        } else if (number % 3 == 0) {
            System.out.println("number = " + number + " Foo");
            return;
        } else if (number % 5 == 0) {
            System.out.println("number = " + number + " Bar");
            return;
        } else {
            System.out.println("number = " + number);
        }
    }
}
