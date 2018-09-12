package com.cultivation.Test;

class MyComparable<T> implements Comparable<T> {

    private Integer value;

    public MyComparable(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return this.value;
    }

    @Override
    public int compareTo(Object o) {
        if (o == null) {
            throw new IllegalArgumentException();
        }
        MyComparable myComparable = (MyComparable) o;
        if (this.value > myComparable.value) {
            return 1;
        } else {
            return this.value == myComparable.value ? 0 : -1;
        }
    }
}
