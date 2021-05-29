
/**
 * Write a description of WordFrequencies here.
 * You will write a program to determine the word that occurs the most often in a file. 
 * If more than one word occurs as the most often, then return the first such word found. 
 * You should make all words lowercase before counting them. Thus, “This” and “this” will
 * both be counted as the lowercase version of “this”. You should not consider punctuation,
 * so “end” and “end,” will be considered different words. Use the WordFrequencies program
 * in the lesson as a starting point.
 * 
 * @author (Elliot Connell) 
 * @version (27/05/21)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;
import java.util.*;

public class WordFrequencies {
    
    private ArrayList<String> myWords;
    private ArrayList<Integer> myFreqs;
    
    public WordFrequencies() {
        myWords = new ArrayList<String>();
        myFreqs = new ArrayList<Integer>();
    }
    
    public void findUnique(){
        myWords.clear();
        myFreqs.clear();
        FileResource resource = new FileResource();
        
        for (String s : resource.words()) {
            s = s.toLowerCase();
            int index = myWords.indexOf(s);
            if (index == -1) {
                myWords.add(s);
                myFreqs.add(1);
            }
            else {
                int value = myFreqs.get(index);
                myFreqs.set(index, value+1);
            }
        }
    }
    
    public int findIndexOfMax(){
        int index = 0;
        int freq = 0;
        
        for (int k=0; k < myWords.size(); k++) {
            if (myFreqs.get(k) > freq) {
                freq = myFreqs.get(k);
                index = k;
            }
        }
        
        return index;
    }
    
    public void tester() {
        findUnique();
        System.out.println("# unique words: " + myWords.size());
        //for (int k=0; k < myWords.size(); k++){
            //System.out.println(myFreqs.get(k)+"\t"+myWords.get(k));
        //}
        
        int result = findIndexOfMax();
        System.out.println("the word that occurs most often and its count are: " + myWords.get(result) + " " + myFreqs.get(result));
        
    }

}
