package com.lugowoy.tasks.core.convertTheRealNumberInTonsAndWithdrawTonsKilogramsAndGrams;

/** Created by Konstantin Lugowoy on 26.03.2017. */

@FunctionalInterface
public interface Convertable {

    void convert(double numberOfTons);

    static void convertRealNumberInTonsAndWithdrawTonsKilogramsAndGrams(double numberOfTons) {
        int tons = (int) numberOfTons;
        double kilograms = (numberOfTons - tons) * 1000;
        int grams = (int) ((kilograms - (int)kilograms) * 1000 + 0.5);

        System.out.printf("Tons : %d, kilograms : %d, grams : %d", tons, (int)kilograms, grams);
    }
}
