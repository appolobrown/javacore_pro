package ru.geekbrains.javacore.lesson4;

public class LetterPrinter implements Runnable {

    public static final Object lock = new Object();
    public static Character letter = 'A';

    private final char currentLetter;
    private final char next;

    public LetterPrinter(char letter, char next) {
        this.currentLetter = letter;
        this.next = next;
    }

    @Override
    public void run() {

        for (int i = 0; i < 5; i++) {
            synchronized (lock) {
                try {
                    while (letter != currentLetter) {
                        lock.wait();
                    }
                    System.out.print(currentLetter);
                    letter = next;
                    lock.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
