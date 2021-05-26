
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class CaesarBreaker {
    
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
    
    public String decrypt(String encrypted) {
        CaesarCipher cc = new CaesarCipher();
        int[] freqs = countLetters(encrypted);
        int maxDex = maxIndex(freqs);
        int dkey = maxDex - 4;
        
        if (maxDex < 4) {
            dkey = 26 - (4-maxDex);
        }
                
        return cc.encrypt(encrypted, 26 - dkey);
    }
    
    public void testDecrypt() {
        
        String result = decrypt("Cfopq Ibbbbbdflk");
        System.out.println(result);
        
        result = decrypt("Wzijk Cvvvvvxzfe");
        System.out.println(result);
        
    }
    
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
    
    public void testHalfOfString() {
        String result = halfOfString("Qbkm Zgis", 0);
        System.out.println(result);
        
        result = halfOfString("Qbkm Zgis", 1);
        System.out.println(result);
    }
    
    public int getKey(String s) {
        // call countLetters to get an array of the letter frequencies in string s
        int[] counts = countLetters(s);
        // calculate the index of the largest letter fequency
        int index = maxIndex(counts);
        
        // return the index        
        return index;
    }
    
    public String decryptTwoKeys(String encrypted){
        // calculate a string of every other character starting with the first character of encrypted string
        String stringA = halfOfString(encrypted, 0);
        // calculate a string of every other character starting with the second character of encrypted string
        String stringB = halfOfString(encrypted, 1);
        // calculate the key used to encrypt each half string
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
        // print out the two keys found
        System.out.println("the two keys for the encrypted string are = " + dkey1 + " & " + dkey2);
        
        // calc and return the decrypted String using encryptTwoKeys method
        CaesarCipher cc = new CaesarCipher();
        String decrypted = cc.encryptTwoKeys(encrypted, 26 - dkey1, 26 - dkey2);
        
        return decrypted;        
    }
    
    public void testDecryptTwoKeys(){
        FileResource fr = new FileResource();
        String message = fr.asString();
        //String message = "Aal uttx hm aal Qtct Fhljha pl Wbdl. Pvxvxlx!";
        String result = decryptTwoKeys(message);
        System.out.println(result);
    }

}
