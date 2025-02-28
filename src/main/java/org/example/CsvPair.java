package org.example;
import java.util.Objects;

public class CsvPair implements Comparable<CsvPair> {
    private String str;
    private Integer freq;

    public CsvPair(String str,Integer freq){
        this.str = str;
        this.freq = freq;
    }
    public Integer getFreq(){
        return freq;
    }
    public String getStr(){
        return str;
    }
    public void setFreq(int freq){
        this.freq = freq;
    }
    public void setStr(){
        this.str = str;
    }

    @Override
    public boolean equals(Object o){
        if(o == null || getClass()!= o.getClass()) return false;
        CsvPair pair = (CsvPair) o;
        return Objects.equals(str, pair.str);
    }
    @Override
    public int hashCode(){
        return Objects.hash(str,freq);
    }
    @Override
    public int compareTo(CsvPair o){
        return this.freq - o.getFreq();
    }
    @Override
    public String toString() {
        return str + " -> " + freq;
    }

}
