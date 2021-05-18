
/**
 * Write a description of CaesarCipher here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class CaesarCipher {
    
    public String encrypt(String input, int key) {
        // make a stringbuilder with the message (encrypted);
        StringBuilder encrypted = new StringBuilder(input);
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        // compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        
        // count from 0 to < length of encrypted, (call it i)
        for (int i = 0; i < encrypted.length(); i++) {
            // look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            char upperChar = Character.toUpperCase(currChar);
           
            // find the index of curChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(upperChar);
            // if currChar is in the alphabet
            if (idx != -1) {
                // get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                // add check for capatalisation
                if (Character.isUpperCase(currChar) == true){
                    // replace the ith character of encrypted with newChar
                    encrypted.setCharAt(i, newChar); 
                }
                else {
                    newChar = Character.toLowerCase(newChar);
                    encrypted.setCharAt(i, newChar);
                }
            }
            // otherwise do nothing
        }
        // answer is the string inside of encrypted
        return encrypted.toString();
    }
    
    public void testCaesar() {
        //String message = encrypt("FIRST LEGION ATTACK EAST FLANK!", 23);
        //System.out.println(message);
        
        String message = encrypt("First Legion", 23);
        System.out.println(message);
        
        message = encrypt("First Legion", 17);
        System.out.println(message);
        
        //FileResource fr = new FileResource();
        //String message = fr.asString();
        //String encrypted = encrypt(message, 23);
        //System.out.println("key is " + key + "\n" + encrypted);
    }

}
