package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class CsvStatistic {

    public void Statist(CsvSetter set){

        try(FileWriter writer = new FileWriter("C:\\Users\\Михаил\\IdeaProjects\\Lab1\\src\\main\\text\\stat.csv")){
            writer.append("Word,Count,Count in %\n");
            int count = set.returnCount();
            for(CsvPair pair : set.returnPair()){
                writer.append(pair.getStr());
                writer.append(";");
                writer.append(pair.getFreq().toString());
                writer.append(";");
                float percent = (float)pair.getFreq()*100 /count;
                writer.append(String.format("%.2f", percent));
                writer.append("\n");
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


    }

}
