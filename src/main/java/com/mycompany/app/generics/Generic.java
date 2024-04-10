package com.mycompany.app.generics;

public class Generic<T> {

    private final T tObject;

    public Generic(T tObject) {
        this.tObject = tObject;
    }


    public void show() {
        System.out.println("This is the generic class: " + tObject.getClass().getName());
    }
}
