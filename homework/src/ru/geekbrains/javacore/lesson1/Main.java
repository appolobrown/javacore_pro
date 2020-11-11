package ru.geekbrains.javacore.lesson1;

import ru.geekbrains.javacore.lesson1.fruits.Apple;
import ru.geekbrains.javacore.lesson1.fruits.Orange;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7};
        try {
            changeElements(array, 2, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(arrayToArrayList(array));

        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 3; i++) {
            appleBox.addItem(new Apple());
        }

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 3; i++) {
            orangeBox.addItem(new Orange());
        }
        System.out.println(appleBox.compare(orangeBox));
        Box<Apple> anotherAppleBox = new Box<>();
        anotherAppleBox.pourAndClear(appleBox);
        System.out.println(appleBox.toString());
        System.out.println(anotherAppleBox.toString());

    }


    private static <T> T[] changeElements(T[] array, int i, int j) throws Exception {
        if (i < array.length || j < array.length) {
            T tempElement = array[i];
            array[i] = array[j];
            array[j] = tempElement;
            return array;
        } else throw new Exception("array size is lower than element index ");
    }

    private static <T> ArrayList<T> arrayToArrayList(T[] array) {
        return new ArrayList<>(Arrays.asList(array));
    }
}
