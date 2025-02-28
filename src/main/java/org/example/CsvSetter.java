package org.example;
import java.util.*;

import java.util.Objects;

public class CsvSetter {
    private Set<CsvPair> csvPair;
    private int count;

    public Set<CsvPair> returnPair(){
        return csvPair;
    }
    public int returnCount(){
        return count;
    }


    public CsvSetter(StringBuilder string){
        this.csvPair = new TreeSet<>((a, b) -> {
            int cmp = Integer.compare(a.getFreq(), b.getFreq());
            if (cmp == 0) return a.getStr().compareTo(b.getStr());
            return cmp;
        });
        int length = string.length();
        StringBuilder subString = new StringBuilder();

        for(int i=0;i<length;i++){
            boolean isDigit = Character.isLetterOrDigit(string.charAt(i));

            if(isDigit){
                subString.append(string.charAt(i));
            }
            else{
                if(subString.length() > 0){
                    addWord(subString.toString());
                    subString.setLength(0);
                }

            }
        }
        if (subString.length() > 0) {
            addWord(subString.toString());
        }

    }
    private void addWord(String word) {
        count = count + 1;
        CsvPair existingPair = findCsvPair(word);

        if (existingPair != null) {
            this.csvPair.remove(existingPair); // Удаляем старый объект
            existingPair.setFreq(existingPair.getFreq() + 1);
        } else {
            existingPair = new CsvPair(word, 1);
        }

        this.csvPair.add(existingPair); // Добавляем новый объект с обновленным freq
    }

    // **Функция для поиска объекта CsvPair по str**
    private CsvPair findCsvPair(String str) {
        for (CsvPair pair : this.csvPair) {
            if (pair.getStr().equals(str)) {
                return pair;
            }
        }
        return null;
    }

}
