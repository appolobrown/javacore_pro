package ru.geekbrains.javacore.lesson1;

import ru.geekbrains.javacore.lesson1.fruits.Fruit;

import java.util.ArrayList;

public class Box<T extends Fruit> {
    private ArrayList<T> boxItems;

    public Box() {
        this.boxItems = new ArrayList<>();
    }

    public void addItem(T item) {
        boxItems.add(item);
    }

    public void pourAndClear(Box<T> another) {
        boxItems.addAll(another.boxItems);
        another.boxItems = new ArrayList<>();
    }

    public float getWeight() {
        float total = 0f;
        for (T boxItem : boxItems) {
            total += boxItem.getWeight();
        }
        return total;
    }

    public boolean compare(Box<?> another) {
        return (this.getWeight() == another.getWeight());
    }

    @Override
    public String toString() {
        return "Box{" +
                "boxItems=" + boxItems +
                '}';
    }
}
