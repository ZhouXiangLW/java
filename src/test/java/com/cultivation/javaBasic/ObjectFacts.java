package com.cultivation.javaBasic;

import com.cultivation.javaBasic.util.CallingAnotherCtor;
import com.cultivation.javaBasic.util.FieldNotExplicitlyInitialized;
import com.cultivation.javaBasic.util.OverloadingFixture;
import com.cultivation.javaBasic.util.SimpleObjectWithInternalState;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

public class ObjectFacts {
    @SuppressWarnings({"UnnecessaryLocalVariable", "ConstantConditions"})
    @Test
    public void should_point_to_the_same_object() {
        Object objectReference = new Object();
        Object sameReference = objectReference;

        final boolean referenceToSameObject = objectReference == sameReference;

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expected = Optional.of(true);
        // --end-->

        assertEquals(expected.get(), referenceToSameObject);
    }

    @Test
    public void should_point_to_different_object() {
        LocalDate goodDay = LocalDate.of(2018, 5, 10);
        LocalDate sameDay = LocalDate.of(2018, 5, 10);

        final boolean referenceToSameObject = goodDay == sameDay;

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Boolean> expected = Optional.of(false);
        // --end-->

        assertEquals(expected.get(), referenceToSameObject);
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    public void should_initialized_to_default_value() {
        FieldNotExplicitlyInitialized instance = new FieldNotExplicitlyInitialized();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expectedName = null;
        final int expectedYearOfBirth = 0;
        final LocalDate expectedRegisteredDate = null;
        // --end-->

        assertEquals(expectedName, instance.getName());
        assertEquals(expectedYearOfBirth, instance.getYearOfBirth());
        assertEquals(expectedRegisteredDate, instance.getRegisteredDate());
    }

    @Test
    public void should_pass_by_value() {
        int value = 5;

        tryingToUpdateValue(value);

        // TODO: please modify the following code to pass the test
        // <--start
        final int expected = 5;
        // --end-->

        assertEquals(expected, value);
    }

    @SuppressWarnings("UnusedAssignment")
    private static void tryingToUpdateValue(int value) {
        value += 2;
    }

    @SuppressWarnings({"UnnecessaryLocalVariable", "unused"})
    @Test
    public void should_pass_by_value_continued() {
        Object objectReference = new Object();
        final Object sameReference = objectReference;

        Object instanceCreatedByMethod = tryingToUpdateReference(objectReference);

        // TODO: please modify the following code to pass the test.
        // You can only choose from `sameReference` and `instanceCreatedByMethod`
        // <--start
        final Object expected = sameReference;
        // --end-->

        assertEquals(expected, objectReference);
    }

    @Test
    public void should_modify_internal_state() {
        SimpleObjectWithInternalState instance = new SimpleObjectWithInternalState("Initial Name");

        tryingToUpdateState(instance);

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "Updated Name";
        // --end-->

        assertEquals(expected, instance.getName());
    }

    @Test
    public void should_choose_method_at_compile_time() {
        OverloadingFixture fixture = new OverloadingFixture();

        String actual = fixture.methodWithOneParameter((Object)"I am a string");

        // TODO: please modify the following code to pass the test. You should write the result directly.
        // <--start
        final String expected = "methodWithOneParameter(Object)";
        // --end-->

        assertEquals(expected, actual);
    }

    @Test
    public void should_choose_the_most_specific_overload() {
        OverloadingFixture fixture = new OverloadingFixture();
        final String name = "name";
        final int integer = 2;

        String actual = fixture.methodWithTwoParameters(name, integer);

        // TODO: please modify the following code to pass the test. You should write the result directly.
        // <--start
        final String expected = "methodWithTwoParameters(String, Integer)";
        // --end-->

        assertEquals(expected, actual);
    }

    @Test
    public void should_calling_another_constructor() {
        CallingAnotherCtor instance = new CallingAnotherCtor();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "Untitled";
        // --end-->

        assertEquals(expected, instance.getName());
    }

    private static void tryingToUpdateState(SimpleObjectWithInternalState instance) {
        instance.setName("Updated Name");
    }

    @SuppressWarnings("ParameterCanBeLocal")
    private static Object tryingToUpdateReference(Object object) {
        object = new Object();
        return object;
    }
}

/*
 * - What does == means for objects.
 * - If there is no explicitly defined constructor, will compiler create one for you?
 * - If there is at least one explicitly defined non-default constructor. Will compiler create a default constructor
 *   for you?
 * - What is the access privilege for method in class marked as `public`, `private`, `protected` and not mark at all.
 */