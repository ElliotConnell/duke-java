
/**
 * Tester class to test methods in Vigenere Breaker
 * 
 * @author (Elliot Connell) 
 * @version (22/06/21)
 */


import edu.duke.*;
import java.util.*;

public class Tester {
    
    public void testSliceString(){
        VigenereBreaker vb = new VigenereBreaker();
        
        String result = vb.sliceString("abcdefghijklm", 0, 3);
        System.out.println("expected result = 'adgjm'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 1, 3);
        System.out.println("expected result = 'behk'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 2, 3);
        System.out.println("expected result = 'cfil'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 0, 4);
        System.out.println("expected result = 'aeim'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 1, 4);
        System.out.println("expected result = 'bfj'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 2, 4);
        System.out.println("expected result = 'cgk'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 3, 4);
        System.out.println("expected result = 'dhl'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 0, 5);
        System.out.println("expected result = 'afk'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 1, 5);
        System.out.println("expected result = 'bgl'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 2, 5);
        System.out.println("expected result = 'chm'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 3, 5);
        System.out.println("expected result = 'di'. returns " + result);
        
        result = vb.sliceString("abcdefghijklm", 4, 5);
        System.out.println("expected result = 'ej'. returns " + result);
    }
    
    public void testTryKeyLength(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        String encrypted = fr.asString();
        
        int[] result = vb.tryKeyLength(encrypted, 4, 'e');
        System.out.println(Arrays.toString(result));
        
    }
    
    public void testReadDictionary(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        
        HashSet<String> dictionary = vb.readDictionary(fr);
        System.out.println(dictionary);
    }
    
    public void testCountWords(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        FileResource dict = new FileResource();
        
        
        String message = fr.asString();
        HashSet<String> dictionary = vb.readDictionary(dict);
        int result = vb.countWords(message, dictionary);
        System.out.println("num. of valid words = " + result);
    }
    
    public void testBreakForLanguage(){
        VigenereBreaker vb = new VigenereBreaker();
        FileResource fr = new FileResource();
        FileResource dict = new FileResource();
        
        
        String message = fr.asString();
        HashSet<String> dictionary = vb.readDictionary(dict);
        String result = vb.breakForLanguage(message, dictionary);
        System.out.println(result);
    }

}
