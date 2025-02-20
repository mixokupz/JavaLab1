package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class CsvStatistic {

    public void Statist(CsvMapper map){

        try(FileWriter writer = new FileWriter("C:\\Users\\Михаил\\IdeaProjects\\Lab1\\src\\main\\text\\stat.csv")){
            writer.append("Word,Count,Count in %\n");
            Map<String,Integer> csvMap = map.returnMap();
            int count = map.returnCount();
            for(Map.Entry<String,Integer> entry: csvMap.entrySet()){
                writer.append(entry.getKey());
                writer.append(";");
                writer.append(entry.getValue().toString());
                writer.append(";");
                float percent = (float)entry.getValue()*100 /count;
                writer.append(String.format("%.2f", percent));
                writer.append("\n");
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }



    }

}
