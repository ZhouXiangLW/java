package com.cultivation.Test;

import java.util.Iterator;
import java.util.function.Consumer;

public class YotabytesNumber implements Iterable {

    private YotabytesIterator iterator;

    public YotabytesNumber() {
        this.iterator = new YotabytesIterator();
    }

    @Override
    public Iterator iterator() {
        return this.iterator;
    }
}
