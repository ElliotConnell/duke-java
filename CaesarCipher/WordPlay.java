
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
    

}
