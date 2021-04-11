package com.company;

import java.util.Scanner;

public class Main {
    static int firstNumber;
    static int secondNumber;
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        String userInput = getOperation();
        while (!"q".equals(userInput)) {
            if ("!".equals(userInput)) firstNumber = getInt();
            else { firstNumber = getInt();
                   secondNumber = getInt(); }

            switch (userInput) {
                case "+":
                    System.out.println((double) plus());
                    break;
                case "-":
                    System.out.println((double) minus());
                    break;
                case "*":
                    System.out.println((double) ymn());
                    break;
                case "/":
                    if (secondNumber == 0)
                        System.out.println("Division By Zero!!'");
                    else System.out.println((double) del());
                    break;
                case "!":
                    System.out.println(fact());
                    break;
                default:
                    System.out.println("invalid operation ");
                    break;
            }
             userInput = getOperation();
        }
        scanner.close();
    }

    private static int plus() {
        return firstNumber + secondNumber;
    }

    private static int minus() {
        return firstNumber - secondNumber;
    }

    private static int ymn() {
        return firstNumber * secondNumber;
    }

    private static int del() {
        return firstNumber / secondNumber;
    }

    private static int fact() {
        int res = 1;
        try {
            if (firstNumber >= 10) throw new Exception("The number must not be more than 10");
            for (int i = 2; i <= firstNumber; i++) {
                res *= i;
            }
        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
        return res;
    }
    public static int getInt() {
        System.out.println("Enter the number:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
            // integer out of range ??
        }
        else {
            System.out.println("You made a mistake entering the number. Try again.");
            scanner.next();
            num = getInt();
        }
        return num;
    }
    public static String getOperation() {
        System.out.println("Enter operation:");
        String operation;
        if(scanner.hasNext()){
            operation = scanner.next();
        } else {
            System.out.println("You made a mistake entering the operation. Try again.");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }
}


