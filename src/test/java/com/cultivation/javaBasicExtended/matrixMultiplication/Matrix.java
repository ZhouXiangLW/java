package com.cultivation.javaBasicExtended.matrixMultiplication;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@SuppressWarnings({"WeakerAccess", "unused"})
class Matrix {
    private final int[][] storage;

    public int rows() {return storage.length;}

    public int columns() {return storage[0].length;}

    public Matrix(int[][] matrixArray) {
        // TODO: please implement the constructor of a matrix.
        // <--start
        if (matrixArray == null) throw new IllegalArgumentException("Raw matrix is null");
        if (matrixArray.length == 0) throw new IllegalArgumentException("Raw matrix contains 0 row");
        for (int i = 0; i < matrixArray.length; i++) {
            if (matrixArray[i] == null) throw new IllegalArgumentException("Raw matrix contains null row");
            if (matrixArray[i].length == 0) throw new IllegalArgumentException("At least one row of raw matrix contains 0 column");
            if (matrixArray[i].length != matrixArray[0].length) throw new IllegalArgumentException("Raw matrix is not rectangle");
        }
        storage = matrixArray;
        // --end-->
    }

    public static Matrix multiply(Matrix left, Matrix right) {
        // TODO: please implement the method to pass the tests.
        // <--start
        if (left == null || right == null) {
            throw new IllegalArgumentException("Arguments can not be null!");
        }
        if (left.rows() != right.columns() || left.columns() != right.rows()) {
            throw new IllegalArgumentException();
        }
        return doMultiply(left, right);
        // --end-->
    }

    // TODO: you can add some helper method if you like.
    // <--start
    private static Matrix doMultiply(Matrix left, Matrix right) {
        int[][] result = new int[left.rows()][left.rows()];
        for (int rowIndex = 0; rowIndex < left.rows(); rowIndex++) {
            for (int colIndex = 0; colIndex < right.columns(); colIndex++) {
                result[rowIndex][colIndex] = getResult(left.getRow(rowIndex), right.getColumn(colIndex));
            }
        }
        return new Matrix(result);
    }

    private static int getResult(int[] row, int[] column) {
        if (row.length != column.length) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (int index = 0; index < row.length; index++) {
            result += row[index]* column[index];
        }
        return result;
    }

    private int[] getColumn(int colIndex) {
        if (colIndex < 0 || colIndex >= columns()) throw new IllegalArgumentException();
        int[] column = new int[storage.length];
        for (int rowIndex = 0; rowIndex < column.length; rowIndex++) {
            column[rowIndex] = storage[rowIndex][colIndex];
        }
        return column;
    }
    // --end->

    public int[] getRow(int rowIndex) {
        if (rowIndex < 0 || rowIndex >= rows()) { throw new IllegalArgumentException(); }
        return storage[rowIndex];
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) { return false; }
        if (this == obj) { return true; }
        if (Matrix.class != obj.getClass()) { return false; }

        Matrix matrix = (Matrix) obj;
        if (rows() != matrix.rows() || columns() != matrix.columns()) {
            return false;
        }

        int rows = rows();
        for (int rowIndex = 0; rowIndex < rows; ++rowIndex) {
            if (!Arrays.equals(getRow(rowIndex), matrix.getRow(rowIndex))) { return false; }
        }

        return true;
    }

    @Override
    public int hashCode() {
        int hash = Arrays.hashCode(getRow(0));
        int rows = rows();
        for (int rowIndex = 1; rowIndex < rows; ++rowIndex) {
            hash ^= Arrays.hashCode(getRow(rowIndex));
        }

        return hash;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Arrays.stream(storage)
            .forEach(row -> formatRow(builder, row));
        return builder.toString();
    }

    private void formatRow(StringBuilder builder, int[] row) {
        for (int item : row) {
            builder.append(String.format("%-10s", Integer.toString(item)));
        }
        builder.append("\n");
    }
}
