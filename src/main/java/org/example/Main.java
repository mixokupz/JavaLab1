package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        CsvReader read = new CsvReader();

        StringBuilder str = read.readingTXT("C:\\Users\\Михаил\\IdeaProjects\\Lab1\\src\\main\\text\\words.txt");

        CsvSetter set = new CsvSetter(str);
        

        CsvStatistic stat = new CsvStatistic();
        stat.Statist(set);


    }
}