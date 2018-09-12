package com.cultivation.Test;

import java.util.Iterator;

public class YotabytesIterator implements Iterator {

    private double start;
    private double end;
    private double current;

    public YotabytesIterator() {
        this.start = 1D;
        this.current = this.start;
        this.end = 1024D * 1024D * 1024D * 1024D;
    }

    @Override
    public boolean hasNext() {
        for (double d = current; d < end; d++) {
            if (isYotabyteNumber(d)) {
                return true;
            } else {
                current++;
            }
        }
        return false;
    }

    @Override
    public Object next() {
        return current++;
    }

    private boolean isYotabyteNumber(double number) {
        return false;
    }
}
