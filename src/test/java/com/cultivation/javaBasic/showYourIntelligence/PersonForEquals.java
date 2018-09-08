package com.cultivation.javaBasic.showYourIntelligence;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Objects;

@SuppressWarnings("unused")
public class PersonForEquals implements Comparable<PersonForEquals> {
    private final String name;
    private final short yearOfBirth;



    public PersonForEquals(String name, short yearOfBirth) {
        if (name == null) {
            throw new IllegalArgumentException("name is mandatory.");
        }

        if (yearOfBirth <= 1900 || yearOfBirth >= 2019) {
            throw new IllegalArgumentException("year of birth is out of range.");
        }

        this.name = name;
        this.yearOfBirth = yearOfBirth;
    }


    public String getName() {
        return name;
    }

    public short getYearOfBirth() {
        return yearOfBirth;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        PersonForEquals p = (PersonForEquals) o;
        return p.getName() == this.getName() && p.getYearOfBirth() == this.getYearOfBirth();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, yearOfBirth);
    }

    @Override
    public int compareTo(PersonForEquals o) {
        if (o == null) throw new IllegalArgumentException("Parameter can not be null");
        if (getName().compareTo(o.getName()) > 0) {
            return 1;
        } else if (getYearOfBirth() > o.getYearOfBirth()) {
            return 1;
        } else if (getName().compareTo(o.getName()) == 0 && getYearOfBirth() == o.getYearOfBirth()) {
            return 0;
        } else {
            return -1;
        }
    }
}
