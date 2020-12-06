package ru.geekbrains.javacore.lesson8;

import java.util.Arrays;

public class Main {

    public static final int SIZE = 10;

    public static void main(String[] args) {

        int[][] array = new int[SIZE][SIZE];

        fillMatrix(array);

        for (int[] ints : array) {
            System.out.println(Arrays.toString(ints));
        }
    }

    public static void fillMatrix(int[][] matrix) {
        int iCol = matrix.length;
        int max = 0;
        int counter = 1;
        while (Math.round((double) iCol / 2) > 0) {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < iCol; j++) {
                    if (i == 0 && j < iCol - max) {
                        matrix[i + max][j + max] = counter++;
                    }
                    if (j != 0) {
                        if (i == 2 && j < iCol - max) {
                            matrix[iCol - 1][iCol - (j + 1)] = counter++;
                        }
                        if (i == 1 && j < iCol - max) {
                            matrix[j + max][iCol - 1] = counter++;
                        }
                        if (i == 3 && j < iCol - (max + 1)) {
                            matrix[iCol - (j + 1)][max] = counter++;
                        }
                    }
                }
            }
            iCol--;
            max++;
        }
    }
}
