package com.lugowoy.tasks.convertingDegreesTemperatures;

import com.lugowoy.helper.reading.Reader;
import com.lugowoy.helper.reading.ReadingDataUserInputInConsole;

/** Created by Konstantin Lugowoy on 11-Jan-17. */

public class Main {

    private static Reader reader = new Reader(new ReadingDataUserInputInConsole());

    public static void main(String[] args) {

        Temperature temperature = new Temperature();
        temperature.setScale(setSelectionOfTemperatureScaleForInputTemperature());

        System.out.println("Enter the temperature value :");
        temperature.setDegreesTemperatures(reader.readDouble());

        if (temperature.getScale().equals(TemperatureScale.Celsius)) {
            choiceAndConvertCelsiusToOtherTemperatureScale(temperature);
        } else {
            Convertable<Temperature> convertable = new ConvertingOtherTemperaturesToCelsius();
            switch (temperature.getScale()) {
                case Fahrenheit:
                    System.out.printf("%f degrees Fahrenheit is equal to %f degrees Celsius.", temperature.getDegreesTemperatures(),
                            convertable.convert(temperature, TemperatureScale.Fahrenheit).getDegreesTemperatures());
                    break;
                case Kelvin:
                    System.out.printf("%f degrees Kelvin is equal to %f degrees Celsius.", temperature.getDegreesTemperatures(),
                            convertable.convert(temperature, TemperatureScale.Kelvin).getDegreesTemperatures());
                    break;
                case Reaumur:
                    System.out.printf("%f degrees Reaumur is equal to %f degrees Celsius.", temperature.getDegreesTemperatures(),
                            convertable.convert(temperature, TemperatureScale.Reaumur).getDegreesTemperatures());
                    break;
                case Delisle:
                    System.out.printf("%f degrees Delisle is equal to %f degrees Celsius.", temperature.getDegreesTemperatures(),
                            convertable.convert(temperature, TemperatureScale.Delisle).getDegreesTemperatures());
                    break;
            }
        }
    }

    private static void choiceAndConvertCelsiusToOtherTemperatureScale(Temperature temperature) {
        System.out.println("Make a choice in what scale to convert degrees Celsius.");
        System.out.println(TemperatureScale.Fahrenheit + " - \"1\" ;");
        System.out.println(TemperatureScale.Kelvin + " - \"2\" ;");
        System.out.println(TemperatureScale.Reaumur + " - \"3\" ;");
        System.out.println(TemperatureScale.Delisle + " - \"4\" ;");

        int choice = reader.readInt();

        while (true) {
            if ((choice > 0) && (choice < 5)) {
                Convertable<Temperature> temperatureScaleConvertable = new ConvertingCelsiusTemperaturesToOther();
                switch (choice) {
                    case 1:
                        System.out.printf("%f degrees Celsius is equal to %f degrees Fahrenheit.", temperature.getDegreesTemperatures(),
                                temperatureScaleConvertable.convert(temperature, TemperatureScale.Fahrenheit).getDegreesTemperatures());
                        break;
                    case 2:
                        System.out.printf("%f degrees Celsius is equal to %f degrees Kelvin.", temperature.getDegreesTemperatures(),
                                temperatureScaleConvertable.convert(temperature, TemperatureScale.Kelvin).getDegreesTemperatures());
                        break;
                    case 3:
                        System.out.printf("%f degrees Celsius is equal to %f degrees Reaumur.", temperature.getDegreesTemperatures(),
                                temperatureScaleConvertable.convert(temperature, TemperatureScale.Reaumur).getDegreesTemperatures());
                        break;
                    case 4:
                        System.out.printf("%f degrees Celsius is equal to %f degrees Delisle.", temperature.getDegreesTemperatures(),
                                temperatureScaleConvertable.convert(temperature, TemperatureScale.Delisle).getDegreesTemperatures());
                        break;

                }
                break;
            } else {
                System.out.println("Invalid selection. \n Re-enter : ");
                choice = reader.readInt();
            }
        }
    }

    private static TemperatureScale setSelectionOfTemperatureScaleForInputTemperature() {
        TemperatureScale temperatureScale = null;

        System.out.println("Select what temperature scale will enter the temperature.Enter the number.");
        System.out.println(TemperatureScale.Celsius + " - \"1\" ;");
        System.out.println(TemperatureScale.Fahrenheit + " - \"2\" ;");
        System.out.println(TemperatureScale.Kelvin + " - \"3\" ;");
        System.out.println(TemperatureScale.Reaumur + " - \"4\" ;");
        System.out.println(TemperatureScale.Delisle + " - \"5\" ;");
        while (true) {
            int choice = reader.readInt();
            if ((choice > 0) && (choice < 6)) {
                switch (choice) {
                    case 1:
                        temperatureScale = TemperatureScale.Celsius;
                        break;
                    case 2:
                        temperatureScale = TemperatureScale.Fahrenheit;
                        break;
                    case 3:
                        temperatureScale = TemperatureScale.Kelvin;
                        break;
                    case 4:
                        temperatureScale = TemperatureScale.Reaumur;
                        break;
                    case 5:
                        temperatureScale = TemperatureScale.Delisle;
                        break;
                }
                break;

            } else {
                System.out.println("Not correct selection. Re-entered choice : ");
            }
        }
        return temperatureScale;
    }

}