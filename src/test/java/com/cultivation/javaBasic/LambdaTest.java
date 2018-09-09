package com.cultivation.javaBasic;

import com.cultivation.Test.*;
import com.cultivation.javaBasic.util.GenericFunc;
import com.cultivation.javaBasic.util.StringFunc;
import com.cultivation.javaBasic.util.ThisInClosure;
import com.cultivation.javaBasic.util.ValueHolder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LambdaTest {
    @Test
    void should_apply_to_interface_with_single_abstract_method() {
        StringFunc lambda = () -> "Hello";

        // TODO: please modify the following code to pass the test
        // <--start
        final String expect = "Hello";
        // --end-->
        List<Integer> integers = new ArrayList<>();
        integers.forEach(System.out::println);

        assertEquals(expect, lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_be_able_to_bind_to_instance_method() {
        // TODO: please bind lambda to instanceMethod.
        // <--start
        StringFunc lambda = this::instanceMethod;
        // --end-->
        assertEquals("instanceMethod", lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_be_able_to_bind_to_static_method() {
        // TODO: please bind lambda to staticMethod
        // <--start
        StringFunc lambda = LambdaTest::staticMethod;
        // --end-->

        assertEquals("staticMethod", lambda.getString());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_bind_to_constructor() {
        // TODO: please bind lambda to constructor of ArrayList<Integer>
        // <--start
        GenericFunc<ArrayList<Integer>> lambda = ArrayList::new;
        // --end-->

        ArrayList<Integer> value = lambda.getValue();

        assertEquals(0, value.size());
    }

    @Test
    void should_capture_variable_in_a_closure() {
        int captured = 5;

        StringFunc lambda = () -> captured + " has been captured.";

        final String message = lambda.getString();

        // TODO: please modify the following code to pass the test
        // <--start>
        final String expected = "5 has been captured.";
        // --end--
        assertEquals(expected, message);
    }

    @Test
    void should_evaluate_captured_variable_when_executing() {
        ValueHolder<String> value = new ValueHolder<>();
        value.setValue("I am the King of the world!");

        StringFunc lambda = () -> "The length of captured value is: " + value.getValue().length();

        // TODO: please write down the expected string directly.
        // <--start
        final String expected = "The length of captured value is: " + 4;
        // --end-->
        value.setValue("Blah");
        assertEquals(expected, lambda.getString());
    }

    @Test
    void should_extend_variable_scope() {
        StringFunc stringFunc = returnLambda();
        String message = stringFunc.getString();

        // TODO: please write down the expected string directly.
        // <--start
        final String expected = "In the year 2019";
        // --end-->

        assertEquals(expected, message);
    }

    @Test
    void should_not_assign_lambda_to_object() {
    }

    @Test
    void should_capture_this_variable() {
        ThisInClosure instance = new ThisInClosure();
        StringFunc stringFunc = instance.getLambda();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "ThisInClosure";
        // --end-->

        assertEquals(expected, stringFunc.getString());
    }

    private static StringFunc returnLambda() {
        int year = 2019;
        return () -> "In the year " + year;
    }

    @Test
    void should_return_int() {
        IntSupplier intSupplier = () -> 1;

        assertEquals(1, intSupplier.getAsInt());
    }

    @Test
    void should_return_char() {
        CharSupplier charSupplier = () -> '1';
        assertEquals('1', charSupplier.getAsChar());
    }

    @Test
    void should_get_argument() {
        IntFunction function = n -> n;
        assertEquals(5, function.apply(5));
    }

    @Test
    void should_return_sum() {
        IntBiFunction intBiFunction = (a, b) -> a + b;

        assertEquals(3, intBiFunction.apply(1, 2));
    }

    private static void swap(Object[] objects) {
        Object tmp = objects[0];
        objects[0] = objects[1];
        objects[1] = tmp;
    }

    @Test
    void should_swap_first_and_second_element_when_given_array() {
        Integer[] integers1 = new Integer[]{2, 1};
        Integer[] integers2 = new Integer[]{1};
        Integer[] integers3 = new Integer[]{1, 2, 3};
        BiConsumer biConsumer = (array) -> {
            if (array.length < 2) return;
            swap(array);
        };

        biConsumer.apply(integers1);
        biConsumer.apply(integers2);
        biConsumer.apply(integers3);

        assertArrayEquals(new Integer[]{1, 2}, integers1);
        assertArrayEquals(new Integer[]{1}, integers2);
        assertArrayEquals(new Integer[]{2, 1, 3}, integers3);
    }

    @Test
    void should_return_sum_of_array() {
        IntSumFunction intSumFunction = array -> array == null ? 0 : Arrays.stream(array).sum();

        int[] array1 = null;
        int[] array2 = new int[]{1};
        int[] array3 = new int[]{1, 2, 3, 4, 5};

        assertEquals(0, intSumFunction.apply(array1));
        assertEquals(1, intSumFunction.apply(array2));
        assertEquals(15, intSumFunction.apply(array3));
    }

    @SuppressWarnings("unused")
    private static String staticMethod() {
        return "staticMethod";
    }

    @SuppressWarnings("unused")
    private String instanceMethod() {
        return "instanceMethod";
    }
}

/*
 * - Do you think you can assign a lambda expression to an Object instance?
 */
