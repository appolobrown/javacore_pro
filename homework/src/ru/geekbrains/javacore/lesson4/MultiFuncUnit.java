package ru.geekbrains.javacore.lesson4;

public class MultiFuncUnit {

    public void print(String source) throws InterruptedException {
        synchronized (this) {
            System.out.printf("*** Print from %s\n", source);
            Thread.sleep(500);
            System.out.printf("*** Done print from %s\n", source);
        }

    }

    public void scan(String source) throws InterruptedException {
        synchronized (this) {
            System.out.printf("--- Scan from %s\n", source);
            Thread.sleep(500);
            System.out.printf("--- Done scan from %s\n", source);
        }
    }

    public void copy(String source) throws InterruptedException {
        synchronized (this) {
            System.out.printf("+++ Copy from %s\n", source);
            scan(source);
            print(source);
            System.out.printf("+++ Done copy %s\n", source);
        }
    }
}
