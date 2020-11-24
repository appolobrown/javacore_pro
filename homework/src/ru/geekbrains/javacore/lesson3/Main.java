package ru.geekbrains.javacore.lesson3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(readFile(new File("files/test1"))));
        try {
            collectToOneFile(getInputStreams(), new File("files/result"));

            startBookReader();
        } catch (IOException ignored) {
        }


    }

    private static void startBookReader() throws IOException {
        Book book = new Book(new File("files/book"));
        System.out.println("This is supa dupa reader. \n " +
                "PLease enter a <page_number>, <n> for next page , \n" +
                "<p> for total pages or <exit> to close");

        Scanner input = new Scanner(System.in);

        String line = input.nextLine();
        while (!line.equals("exit")) {
            String toPrint = "";
            switch (line) {
                case "n":
                    toPrint = book.getNext();
                    break;
                case "p":
                    toPrint = String.valueOf(book.getTotalPages());
                    break;
                default:
                    try {
                        toPrint = book.getPage(Integer.parseInt(line));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input: " + line);
                    }
            }
            System.out.println(toPrint);
            line = input.nextLine();
        }
    }

    public static int[] readFile(File file) {
        int[] result;
        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            result = new int[fileInputStream.available()];
            int readed, i = 0;
            while ((readed = fileInputStream.read()) != -1) {
                result[i] = readed;
                i++;
            }
        } catch (IOException e) {
            result = new int[0];
            return result;
        }
        return result;
    }

    public static void collectToOneFile(ArrayList<InputStream> inputStreams, File result) {
        try (SequenceInputStream in = new SequenceInputStream(Collections.enumeration(inputStreams));
             FileOutputStream fileOutputStream = new FileOutputStream(result)) {
            int x;
            byte[] buffer = new byte[512];
            while ((x = in.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, x);
            }
            fileOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<InputStream> getInputStreams() throws FileNotFoundException {
        ArrayList<InputStream> streams = new ArrayList<>();
        for (int i = 1; i != 5; i++) {
            streams.add(new FileInputStream(new File("files/test" + i)));
        }
        return streams;
    }
}
