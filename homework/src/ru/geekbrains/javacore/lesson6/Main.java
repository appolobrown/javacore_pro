package ru.geekbrains.javacore.lesson6;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        int[] ints = new int[]{1, 2, 3, 2, 1, 3, 4, 6, 7, 8, 6, 3, 4, 3, 2, 1};
        System.out.println(Arrays.toString(getSubArrayAfterLast(ints, 4)));
        System.out.println(containsAny(ints, new int[]{1, 4}));
    }

    public static int[] getSubArrayAfterLast(int[] in, int element) {
        int index = Arrays.stream(in).boxed().collect(Collectors.toList()).lastIndexOf(element);
        if (index == -1)
            throw new RuntimeException("No such element");
        return Arrays.copyOfRange(in, index + 1, in.length);
    }

    public static boolean containsAny(int[] ints, int[] containsWhat) {
        List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
        for (int i : containsWhat) {
            if (list.contains(i)) return true;
        }
        return false;
    }
}
