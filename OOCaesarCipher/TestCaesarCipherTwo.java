
/**
 * Write a description of TestCaesarCipherTwo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class TestCaesarCipherTwo {
    
    public String halfOfString(String message, int start){
        String halfStr = "";
        
        for (int i=start; i<message.length(); i++){
            // select character in the string
            char stringChar = message.charAt(i);
            
            if ((i + start) % 2 == 0){
                halfStr = halfStr + stringChar;
            }
            
        }
        
        return halfStr;
    }
    
    public int[] countLetters(String message) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for (int k=0; k<message.length(); k++){
            char ch = Character.toLowerCase(message.charAt(k));
            int dex = alph.indexOf(ch);
            if(dex != -1){
                counts[dex] += 1;
            }
        }
        
        return counts;    
    }
    
    public int maxIndex(int[]  vals) {
        int maxDex = 0;
        for (int k=0; k<vals.length; k++) {
            if (vals[k] > vals[maxDex]) {
                maxDex = k;
            }
        }
        return maxDex;
    }
    
    public void simpleTests() {
        FileResource fr = new FileResource();
        String message = fr.asString();
        
        CaesarCipherTwo cc = new CaesarCipherTwo(17, 3);
        String encrypted = cc.encrypt(message);
        System.out.println(encrypted);
        
        String decrypted = breakCaesarCipher(encrypted);
        System.out.println(decrypted);
    }
    
    public int getKey(String s){
        int[] counts = countLetters(s);
        int index = maxIndex(counts);
        
        return index;
    }
    
    
    public String breakCaesarCipher(String input) {
        String stringA = halfOfString(input, 0);
        String stringB = halfOfString(input, 1);
        
        int index1 = getKey(stringA);
        int dkey1 = index1 - 4;
        if (index1 < 4) {
            dkey1 = 26 - (4-index1);
        }
        int index2 = getKey(stringB);
        int dkey2 = index2 - 4;
        if (index2 < 4) {
            dkey2 = 26 - (4-index2);
        }
        
        CaesarCipherTwo cc = new CaesarCipherTwo(26 - dkey1, 26 - dkey2);
        String decrypted = cc.encrypt(input);
        
        return decrypted;
    }
}


