package ru.geekbrains.javacore.lesson3;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Book {

    private static final String MODE_R_ONLY = "r";
    private static final int PAGE_SIZE = 1800;
    private RandomAccessFile randomAccessFile;
    private long length;
    private int currentPage;

    public Book(File file) throws IOException {
        this.randomAccessFile = new RandomAccessFile(file, MODE_R_ONLY);
        this.length = randomAccessFile.length();
    }

    public String getPage(int numpage) throws IOException {
        long offset = numpage == 1 ? 0 : numpage * PAGE_SIZE;
        if (offset > length) offset = length;

        byte[] bytes = new byte[PAGE_SIZE];
        randomAccessFile.seek(offset);
        randomAccessFile.read(bytes, 0, PAGE_SIZE);
        currentPage = numpage;
        return new String(bytes, Charset.defaultCharset());
    }

    public String getNext() throws IOException {
        return getPage(currentPage + 1);
    }

    public int getTotalPages() {
        return (int) (length / PAGE_SIZE);
    }
}
