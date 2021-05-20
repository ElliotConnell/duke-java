
/**
 * Write a description of WordLengths here.
 * You will write a program to figure out the most common word length of words from a file. 
 * To solve this problem you will need to keep track of how many words from a file are of each possible length.
 * You should group all words of length 30 or more together, 
 * and you should not count basic punctuation that are the first or last characters of a group of characters.
 * 
 * @author (Elliot Connell) 
 * @version (18/05/21)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class WordLengths {
    
    public void countWordLengths( FileResource resource, int[] counts) {
        // create new int array from counts
        // set counter
        
        // look into file 
        
        // for each word in file. start the loop
        for (String word: resource.words()) {
            int len = word.length();
            boolean firstChar = Character.isLetter(word.charAt(0));
            boolean lastChar = Character.isLetter(word.charAt(len-1));
            if (firstChar == false){
                len = len - 1;
            }
            
            if (lastChar == false){
                len = len -1;
            }
                
            counts[len] += 1;
        }
        
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0) {
                System.out.println("for length " + i + ", no. of words = " + counts[i]);
            }
        }
                
    }
    
    public void testCountWordLengths() {
        FileResource resource = new FileResource();
        int[] counts = new int[31];
        
        countWordLengths(resource, counts);
                
    }
}
    


