package com.cultivation.javaBasicExtended.reverseString;

import com.cultivation.javaBasic.util.StringFunc;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

class StringReverser {
    @SuppressWarnings({"WeakerAccess", "unused"})
    public static String[] reverse(String input) {
        // TODO: please implement the method to pass all the tests.
        // <--start
        if (input == null) throw new IllegalArgumentException();
        if (input.trim().isEmpty()) return new String[0];

        String[] strArray = input.split(" ");
        int firstIndex = 0;
        int lastIndex = strArray.length - 1;
        while (lastIndex - firstIndex >= 1) {
            swap(strArray, firstIndex++, lastIndex--);
        }
        return strArray;
        // --end-->
    }

    private static void swap(String[] strings, int index1, int index2) {
        String tmp = strings[index1];
        strings[index1] = strings[index2];
        strings[index2] = tmp;
    }
}
