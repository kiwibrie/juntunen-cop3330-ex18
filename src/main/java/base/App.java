package base;

/*
 *  UCF COP3330 Summer 2021 Assignment 18 Solution
 *  Copyright 2021 Brianne Juntunen
 */
import java.util.Scanner;

public class App {
    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        App myApp = new App();

        int convert = myApp.promptConversion();
        double degree = myApp.promptTemp(convert);

        double convertedTemp = myApp.convertTemperature(convert, degree);

        myApp.printOutput(convertedTemp, convert);
    }

    public void printOutput(double convertedTemp, int convert){
        String conDegree = " ";
        if(convert == 0){ //fahrenheit to celsius
            conDegree = "Celsius";
        } else if (convert == 1){ //celsius to fahrenheit
            conDegree = "Fahrenheit";
        }

        System.out.printf("The temperature in %s is %.1f.", conDegree, convertedTemp);
    }

    public double convertTemperature(int convert, double degree){
        if(convert == 0){ //fahrenheit to celsius
            return (degree -32) * 5 / 9;
        } else if (convert == 1){ //celsius to fahrenheit
            return (degree * 9 / 5) +32;
        }
        return 0;
    }

    public int promptConversion(){
        System.out.println("Press C to convert from Fahrenheit to Celsius.");
        System.out.println("Press F to convert from Celsius to Fahrenheit.");
        System.out.println("Your choice: ");
        String input = in.nextLine();
        int choice = 2;
        while(input != null){
            if(input.equalsIgnoreCase("C")){
                choice = 0;
                break;
            } else if (input.equalsIgnoreCase("F")){
                choice = 1;
                break;
            } else {
                System.out.println("Please enter either C or F. ");
                input = in.nextLine();
            }
        }

        return choice;
    }

    public double promptTemp(int convert){
        String degree = " ";
        if(convert == 0){ //fahrenheit to celsius
            degree = "Fahrenheit";
        } else if (convert == 1){ //celsius to fahrenheit
            degree = "Celsius";
        }

        System.out.printf("Please enter the temperature in %s: ", degree);
        return Double.parseDouble(in.nextLine());
    }
}