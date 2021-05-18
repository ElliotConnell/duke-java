
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
    
    public void testIsVowel() {
        boolean result = isVowel('F');
        System.out.println(result);
        
        result = isVowel('a');
        System.out.println(result);
    }
    
    public String replaceVowels(String phrase, char ch) {
        //create new string
        String newStr = "";
        
        // loop through charaters in string
        for (int i=0; i<phrase.length(); i++){
            // select character in the string
            char stringChar = phrase.charAt(i);
            char lowerChar = Character.toLowerCase(stringChar);
            if (isVowel(lowerChar) == true){
                newStr = newStr + '*';
            }
            else {
                newStr = newStr + stringChar;
            }
        }
        
        return newStr;
    }
    
    public void testReplaceVowels(){
        String result = replaceVowels("Hello World", '*');
        System.out.println(result);
    }
    
    public String emphasize(String phrase, char ch) {
        // create new string
        String empStr = "";
        
        // loop through characters in string
        for (int i=0; i<phrase.length(); i++){
            //select character in string
            char stringChar = phrase.charAt(i);
            char lowerChar = Character.toLowerCase(stringChar);
            //check to to see if ch matches the character
            if (ch == lowerChar) {
                if (i % 2 == 1) {
                    empStr = empStr + '+';
                }
                else {
                    empStr = empStr + '*';
                }
            }
            else {
                empStr = empStr + stringChar;
            }
            
        }
        
        return empStr;
    }
    
    public void testEmphasize() {
        String result = emphasize("dna ctgaaactga",'a');
        System.out.println(result);
        
        result = emphasize("Mary Bella Abracadabra", 'a');
        System.out.println(result);
        
    }
    

}
