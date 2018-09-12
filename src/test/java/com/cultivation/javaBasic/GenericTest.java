package com.cultivation.javaBasic;

import com.cultivation.Test.GenericClass;
import com.cultivation.Test.MyDerivedComparable;
import com.cultivation.javaBasic.util.Employee;
import com.cultivation.javaBasic.util.KeyValuePair;
import com.cultivation.javaBasic.util.Manager;
import com.cultivation.javaBasic.util.Pair;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GenericTest {
    @SuppressWarnings("unused")
    @Test
    void should_auto_resolve_generic_method() {
        final String[] words = {"Hello", "Good", "Morning"};

        // TODO: please call getMiddle method for string
        // <--start
        final String last = getLast(words);
        final String middle = getMiddle(words);
        // --end-->

        assertEquals("Morning", last);
        assertEquals("Good", middle);
    }

    @Test
    void should_specify_a_type_restriction_on_typed_parameters() {
        int minimumInteger = min(new Integer[]{1, 2, 3});
        double minimumReal = min(new Double[]{1.2, 2.2, -1d});
        int arrayWithOne = min(new Integer[]{1});
        String minString = min(new String[]{"hello", "a"});

        assertEquals("a", minString);
        assertEquals(1, arrayWithOne);
        assertEquals(1, minimumInteger);
        assertEquals(-1d, minimumReal, 1.0E-05);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_not_know_generic_type_parameters_at_runtime() {
        KeyValuePair<String, Integer> pair = new KeyValuePair<>("name", 2);
        KeyValuePair<Integer, String> pairWithDifferentTypeParameter = new KeyValuePair<>(2, "name");

        Class<?> pairClass = pair.getClass();
        Class<?> pairWithDifferentTypeParameterClass = pairWithDifferentTypeParameter.getClass();

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expected = Optional.of(true);
        // --end-->

        assertEquals(expected.get(), pair.getClass().equals(pairWithDifferentTypeParameter.getClass()));
    }

    @Test
    void should_erase_type_of_unbound_generic_type() {
        GenericClass<Integer> integer = new GenericClass<>();

        Class<GenericClass> clazz = (Class<GenericClass>) integer.getClass();

        Field field = clazz.getDeclaredFields()[0];

        assertEquals(Object.class, field.getType());

    }

    @SuppressWarnings({"UnnecessaryLocalVariable", "unchecked", "unused", "ConstantConditions"})
    @Test
    void should_be_careful_of_raw_type_generic() {
        Pair<Manager> managerPair = new Pair<>();
        Pair rawPair = managerPair;
        rawPair.setFirst(new Employee());

        boolean willThrow = false;
        try {
            Manager first = managerPair.getFirst();
        } catch (ClassCastException error) {
            willThrow = true;
        }

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expected = Optional.of(true);
        // --end-->

        assertEquals(expected.get(), willThrow);
    }

    @Test
    void should_swap() {
        Pair<String> pair = new Pair<>("Hello", "World");

        swap(pair);

        assertEquals("World", pair.getFirst());
        assertEquals("Hello", pair.getSecond());
    }

    @SuppressWarnings("unused")
    private static <T> T getLast(T[] array) {
        return array[array.length - 1];
    }

    private static <T> T getMiddle(T[] array) {
        return array[array.length / 2];
    }


    // TODO: please implement the following code to pass the test. It should be generic after all.
    // The method should only accept `Number` and the number should implement `Comparable<T>`
    // <--start
    @SuppressWarnings("unused")
    private static <T extends Comparable<T>> T min(T[] array) {
//        if (array == null && array.length == 0) return null;
//        T min = array[0];
//        for (int index = 1; index < array.length; index++) {
//            if (array[index].compareTo(min) < 0) {
//                min = array[index];
//            }
//        }
//        return min;
        if (array == null && array.length == 0) return null;
        return Arrays.stream(array)
                .reduce((n1, n2) -> n1.compareTo(n2) < 0 ? n1 : n2)
                .get();
    }

    @Test
    void name() {
        MyDerivedComparable[] myDerivedComparable = new MyDerivedComparable[]{
                new MyDerivedComparable(1),
                new MyDerivedComparable(2),
                new MyDerivedComparable(3)
        };
    }
    // --end-->

    // TODO: please implement following method to pass the test. But you cannot change the signature
    // <--start
    @SuppressWarnings("unused")
    private static<T> void swap(Pair<T> pair) {
        T tmp = pair.getFirst();
        pair.setFirst(pair.getSecond());
        pair.setSecond(tmp);
    }

    // TODO: You can add additional method within the range if you like
    // <--start

    // --end-->
}

/*
 * - Can you give an example when you have to specify a typed parameter in generic method call?
 * - Can type parameter have more than one bounds? Can type parameter bounds to class? Can type parameter bounds to both
 *   class and interface?
 * - What if you have 2 class that one is generic called `KeyValuePair<K, V>` and the second is a non-generic method
 *   called `KeyValuePair` in the same package?
 * - Can you use primitive types as type parameter?
 * - What is the result of the following code
 *   ```
 *   KeyValuePair[] keyValuePairs = new KeyValuePair[10];
 *   keyValuePairs[0] = new KeyValuePair<>("Name", 10);
 *   keyValuePairs[1] = new KeyValuePair<>(10, "Name");
 *   ```
 * - What is the result of the following code
 *   ```
 *   KeyValuePair[] keyValuePairs = new KeyValuePair[10];
 *   keyValuePairs[0] = new KeyValuePair<>("Name", 10);
 *   keyValuePairs[1] = new KeyValuePair<>(10, "Name");
 *   KeyValuePair<String, Integer> value = keyValuePairs[1];
 *   ```
 * - What is the result of the following code
 *   ```
 *   KeyValuePair[] keyValuePairs = new KeyValuePair[10];
 *   keyValuePairs[0] = new KeyValuePair<>("Name", 10);
 *   keyValuePairs[1] = new KeyValuePair<>(10, "Name");
 *   KeyValuePair<String, Integer> value = keyValuePairs[1];
 *   String key = value.getKey();
 *   ```
 * - Please describe the wildcard generic type.
 */