
/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class WordPlay {
    
    public boolean isVowel(char ch){
       String vowel = "aeiou";
       
       for (int i=0; i<vowel.length(); i++) {
           char charVowel = vowel.charAt(i);
           ch = Character.toLowerCase(ch);
           if (ch == charVowel) {
               return true;
            }
       }
       return false;       
    }
    

}
