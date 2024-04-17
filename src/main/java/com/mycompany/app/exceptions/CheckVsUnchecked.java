package com.mycompany.app.exceptions;

import java.io.FileReader;

public class CheckVsUnchecked {
    public static void main(String[] args) {
        readFile("myFile.txt");
    }

    private static void readFile (String fileName) {
        FileReader reader = new FileReader(fileName);
    }

    public static void division() {
        int x = 10;
        int y = 0;
        int z = x / y; // ArithmeticException

    }

    public static void squareRoot() {
        int x = -25;

        double squareRoot = Math.sqrt(x); // ArithmeticException
    }

}
