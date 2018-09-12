package com.cultivation.javaBasic;

import com.cultivation.javaBasic.util.AnonymousClassUpdateField;
import com.cultivation.javaBasic.util.InnerClassUpdateField;
import com.cultivation.javaBasic.util.LocalClassUpdateField;
import com.cultivation.javaBasic.util.StaticInnerClass;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InnerClassTest {
    @SuppressWarnings("ConstantConditions")
    @Test
    void should_access_instance_field_of_parent_class() {
//        InnerClassUpdateField instance = new InnerClassUpdateField();
////        instance.somethingHappen();
//
//        // TODO: please modify the following code to pass the test
//        // <--start
//        final Optional<Integer> expected = Optional.of(2019);
//        // --end-->
//
//        assertEquals(expected.get().intValue(), instance.getYear());
    }

    @Test
    void should_update_private_field() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField();
        InnerClassUpdateField.MyInnerClass innerClass = innerClassUpdateField.new MyInnerClass();

        innerClass.increaseYear();

        assertEquals(2020, innerClassUpdateField.getYear());
    }

    @Test
    void should_update_year_with_inner_class_field() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField(2018);
        InnerClassUpdateField.MyInnerClass innerClass = innerClassUpdateField.new MyInnerClass(2);
        innerClass.add();
        assertEquals(2020, innerClassUpdateField.getYear());
    }

    @Test
    void should_update_year_this_enclosing_class_add() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField(2018);
        innerClassUpdateField.add();
        assertEquals(2020, innerClassUpdateField.getYear());
    }

    @Test
    void should_update_private_field_with_constructer() {
        InnerClassUpdateField innerClassUpdateField = new InnerClassUpdateField(2018);
        InnerClassUpdateField.MyInnerClass innerClass = innerClassUpdateField.new MyInnerClass(2);
        assertEquals(2020, innerClassUpdateField.getYear());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_update_field_using_local_class() {
        LocalClassUpdateField instance = new LocalClassUpdateField();
        instance.somethingHappen();

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Integer> expected = Optional.of(2019);
        // --end-->

        assertEquals(expected.get().intValue(), instance.getYear());
    }

    @SuppressWarnings("ConstantConditions")
    @Test
    void should_update_field_using_anonymous_class() {
        AnonymousClassUpdateField instance = new AnonymousClassUpdateField();
        instance.somethingHappen();

        // TODO: please modify the following code to pass the test
        // <--start
        final Optional<Integer> expected = Optional.of(2019);
        // --end-->

        assertEquals(expected.get().intValue(), instance.getYear());
    }

    @Test
    void should_create_instance_for_static_inner_class() {
        StaticInnerClass instance = new StaticInnerClass();
        StaticInnerClass.Inner inner = instance.createInner();

        // TODO: please modify the following code to pass the test
        // <--start
        final String expected = "Hello";
        // --end-->

        assertEquals(expected, inner.getName());
    }
}
