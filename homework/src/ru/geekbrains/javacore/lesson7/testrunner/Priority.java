package ru.geekbrains.javacore.lesson7.testrunner;

public enum Priority {
    P1(1), P2(2), P3(3),
    P4(4), P5(5), P6(6),
    P7(7), P8(8), P9(9), P10(10);

    private final int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Priority highest() {
        return P10;
    }

    public static Priority lowest() {
        return P1;
    }

    public static Priority medium() {
        return P5;
    }
}
