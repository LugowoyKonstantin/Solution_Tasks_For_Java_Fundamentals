package com.lugowoy.tasks.convertKilometersToMilesOfSeaAndLand;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

/**Created by Konstantin Lugowoy on 31-Dec-16.*/

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        System.out.println("Enter the number of kilometers for conversion : ");
        Length length = new Length();
        length.setKilometers(reader.readDouble());

        System.out.println("Convert entered number of kilometers, ");
        System.out.println("In nautical miles, enter : \"1\" .");
        System.out.println("In the statute miles, enter : \"2\" .");
        System.out.println("Nothing to convert, enter : \"3\" .");

        int selection = reader.readInt();

        if ((selection > 0) && (selection <= 3)) {
            Convertable<Length> lengthConvertable;
            switch (selection) {
                case 1:
                    lengthConvertable = new ConvertingKilometersToMilesOfSea();
                    lengthConvertable.convert(length);
                    System.out.printf("The result of the conversion of kilometers to nautical miles is %f",
                                            length.getMilesOfSea());
                    break;
                case 2:
                    lengthConvertable = new ConvertingKilometersToMilesOfLand();
                    lengthConvertable.convert(length);
                    System.out.printf("The result of the conversion of kilometers to miles of land is %f",
                                            length.getMilesOfLand());
                    break;
                case 3:
                    System.out.println("EXIT");
            }
        } else {
            System.out.println("Error when entering the action selection");
        }

    }

}