package org.example;

import java.util.Map;

public class Main {
    public static void main(String[] args) {
        CsvReader read = new CsvReader();

        StringBuilder str = read.readingTXT("C:\\Users\\Михаил\\IdeaProjects\\Lab1\\src\\main\\text\\words.txt");

        CsvMapper map = new CsvMapper(str);

        CsvStatistic stat = new CsvStatistic();
        stat.Statist(map);


    }
}