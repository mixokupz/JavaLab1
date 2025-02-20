package org.example;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class CsvMapper {
    private Map<String,Integer> csvMap;
    private int count;

    public Map<String,Integer> returnMap(){
        return csvMap;
    }
    public int returnCount(){
        return count;
    }
    public Set<Map.Entry<String, Integer>> entrySet() {
        return csvMap.entrySet();
    }
    public CsvMapper(StringBuilder string){
        this.csvMap = new TreeMap<>();
        //разбиваю по словам
        int length = string.length();
        StringBuilder subString = new StringBuilder();
        for(int i=0;i<length;i++){
            boolean isDigit = Character.isLetterOrDigit(string.charAt(i));

            if(isDigit){
                subString.append(string.charAt(i));
            }
            else{
                if(subString.length() > 0){
                    String key = subString.toString();
                    count = count + 1;
                    if(this.csvMap.containsKey(key)){
                        this.csvMap.put(key, this.csvMap.get(key) + 1);
                    }else {
                        this.csvMap.put(key,1);
                    }

                    subString.setLength(0);
                }

            }
        }
        //если осталось невыведенное слово из-за отсуствия \n
        if (subString.length() > 0) {
            String key = subString.toString();
            count = count + 1;
            if(this.csvMap.containsKey(key)){
                this.csvMap.put(key, this.csvMap.get(key) + 1);
            }else {
                this.csvMap.put(key,1);
            }
        }
    }
}
