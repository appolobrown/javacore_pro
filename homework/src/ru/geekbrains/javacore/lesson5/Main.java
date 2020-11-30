package ru.geekbrains.javacore.lesson5;

import ru.geekbrains.javacore.lesson5.stage.Road;
import ru.geekbrains.javacore.lesson5.stage.Tunnel;

import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int CARS_COUNT = 10;

    public static void main(String[] args) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        Race race = new Race(new Road(60),
                new Tunnel(CARS_COUNT / 2),
                new Road(40));
        Car[] cars = new Car[CARS_COUNT];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(CARS_COUNT);
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(race, 20 + (int) (Math.random() * 10), cyclicBarrier);
        }
        for (Car car : cars) {
            new Thread(car).start();
        }
        while (!Car.IS_RACE_BEGIN.get()) {
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

        while (Car.FINISH_COUNTER.get() != CARS_COUNT) {
        }
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
    }
}
