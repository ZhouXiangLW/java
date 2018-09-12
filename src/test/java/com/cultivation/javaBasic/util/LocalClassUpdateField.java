package com.cultivation.javaBasic.util;

public class LocalClassUpdateField {
    private int year;

    public LocalClassUpdateField() {
        year = 2018;
    }

    public int getYear() {
        return year;
    }

    @SuppressWarnings("Convert2Lambda")
    public void somethingHappen() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ++LocalClassUpdateField.this.year;
            }
        };
        runnable.run();
    }
}