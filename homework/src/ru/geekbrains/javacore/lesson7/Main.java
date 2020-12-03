package ru.geekbrains.javacore.lesson7;

import ru.geekbrains.javacore.lesson7.testrunner.TestRunner;

import java.lang.reflect.InvocationTargetException;

public class Main {
    public static void main(String[] args)
            throws InvocationTargetException,
            IllegalAccessException,
            NoSuchMethodException,
            InstantiationException,
            ClassNotFoundException {
        TestRunner.start(HomeTest.class);
        TestRunner.start(HomeTest.class.getName());
    }
}
