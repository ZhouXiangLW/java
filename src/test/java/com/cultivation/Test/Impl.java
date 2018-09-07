package com.cultivation.Test;

public class Impl implements Base1, Base2 {
    @Override
    public String test() {
        return Base1.super.test();
    }
}