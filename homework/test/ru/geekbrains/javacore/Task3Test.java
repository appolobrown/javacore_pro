package ru.geekbrains.javacore;

import org.junit.Before;
import org.junit.Test;
import ru.geekbrains.javacore.lesson6.Main;

import static org.junit.Assert.*;


public class Task3Test {

    int[] contains;
    int[] notCcontains;
    int[] whatContains;


    @Before
    public void setContains() {
        contains = new int[]{1, 2, 3, 2, 1, 3, 4, 6, 7, 8, 6, 3, 4, 3, 2, 1};
        notCcontains = new int[]{2, 3, 2, 3, 6, 7, 8, 6, 3, 3, 2};
        whatContains = new int[]{1, 4};
    }

    @Test
    public void checkTrueIfContains() {
        assertTrue(Main.containsAny(contains, whatContains));
    }

    @Test
    public void checkFalseIfNotContains() {
        assertFalse(Main.containsAny(notCcontains, whatContains));
    }

    @Test
    public void checkTrueIfContainsAny() {
        assertTrue(Main.containsAny(new int[]{1}, whatContains));
    }

    @Test
    public void checkFalseIfNotContainsAny() {
        assertFalse(Main.containsAny(new int[]{3}, whatContains));
    }
}
