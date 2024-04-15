package com.mycompany.app.exceptions;

import java.util.Arrays;

import static java.lang.reflect.Array.getInt;

public class ExceptionHandling {
    public static void main(String[] args) {
        try {
            getInt();
        } catch (NumberFormatException e) {
            System.out.println("Hey, put a valid argument. ");
        } catch (NullPointerException e ) {
            System.out.print("Hey, type something.");
        }
        System.out.println("End here!");
    }

    private static void getInt() {
        int myInt = Integer.parseInt("pants");
    }
}
