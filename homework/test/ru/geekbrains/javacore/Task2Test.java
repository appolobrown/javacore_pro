package ru.geekbrains.javacore;

import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.javacore.lesson6.Main;

import static org.junit.Assert.*;

public class Task2Test {

    int[] defauts;
    int[] expected;
    int defaultToFind;

    @Before
    public void setInts() {
        defauts = new int[]{1, 2, 3, 2, 1, 3, 4, 6, 7, 8, 6, 3, 4, 3, 2, 1};
        expected = new int[]{3, 2, 1};
        defaultToFind = 4;
    }

    @Test
    public void checkSubArrayCorrect() {
        assertArrayEquals(expected,
                Main.getSubArrayAfterLast(defauts, defaultToFind));
    }

    @Test()
    public void checkArrayEmptyIfElementLast() {
        defauts[defauts.length - 1] = defaultToFind;
        assertArrayEquals(new int[0],
                Main.getSubArrayAfterLast(defauts, defaultToFind));
    }

    @Test(expected = RuntimeException.class)
    public void checkRuntimeIsThrownIfNotExists() {
        assertArrayEquals(expected,
                Main.getSubArrayAfterLast(defauts, 10));
    }


}
