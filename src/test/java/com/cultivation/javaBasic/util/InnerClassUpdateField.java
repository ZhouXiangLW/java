package com.cultivation.javaBasic.util;

public class InnerClassUpdateField {
    private int year = 2018;


    public InnerClassUpdateField(int year) {
        this.year = year;
    }

    public InnerClassUpdateField() {
        this.year = 2018;
    }

    public int getYear() {
        return year;
    }

    public void add() {
        class MyInnerClass{
            private final static int YEAR = 2;
        };
        InnerClassUpdateField.MyInnerClass innerClass = this.new MyInnerClass(2);
        innerClass.add();
    }

    public class MyInnerClass {

        private final static int YEAR = 2;


        private int year;

        public MyInnerClass(int year) {
            this.year = year;
        }

        public MyInnerClass() {
        }

        public void increaseYear() {
            InnerClassUpdateField.this.year += 2;
        }

        public void add() {
            InnerClassUpdateField.this.year += this.year;
        }
    }
}
