package com.cultivation.Test;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class YottabytesNumberTest {
    @Test
    void should_hava_15_yotabyte_number() {
        YotabytesNumber yotabytesNumber = new YotabytesNumber();
        YotabytesIterator iterator = (YotabytesIterator) yotabytesNumber.iterator();
        List<Double> lists = new ArrayList<>();
        while (iterator.hasNext()) {
            lists.add((Double) iterator.next());
        }
        assertEquals(15, lists.size());
    }

}
