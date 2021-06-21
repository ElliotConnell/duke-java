import java.util.*;
import edu.duke.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        String slicedString = "";
        
        for (int index = whichSlice; index < message.length(); index += totalSlices){
            slicedString = slicedString + message.charAt(index);
        }
        return slicedString;
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        //WRITE YOUR CODE HERE
        return key;
    }

    public void breakVigenere () {
        //WRITE YOUR CODE HERE
    }
    
    public void tester(){
        String result = sliceString("abcdefghijklm", 0, 3);
        System.out.println("expected result = 'adgjm'. returns " + result);
        
        result = sliceString("abcdefghijklm", 1, 3);
        System.out.println("expected result = 'behk'. returns " + result);
        
        result = sliceString("abcdefghijklm", 2, 3);
        System.out.println("expected result = 'cfil'. returns " + result);
        
        result = sliceString("abcdefghijklm", 0, 4);
        System.out.println("expected result = 'aeim'. returns " + result);
        
        result = sliceString("abcdefghijklm", 1, 4);
        System.out.println("expected result = 'bfj'. returns " + result);
        
        result = sliceString("abcdefghijklm", 2, 4);
        System.out.println("expected result = 'cgk'. returns " + result);
        
        result = sliceString("abcdefghijklm", 3, 4);
        System.out.println("expected result = 'dhl'. returns " + result);
        
        result = sliceString("abcdefghijklm", 0, 5);
        System.out.println("expected result = 'afk'. returns " + result);
        
        result = sliceString("abcdefghijklm", 1, 5);
        System.out.println("expected result = 'bgl'. returns " + result);
        
        result = sliceString("abcdefghijklm", 2, 5);
        System.out.println("expected result = 'chm'. returns " + result);
        
        result = sliceString("abcdefghijklm", 3, 5);
        System.out.println("expected result = 'di'. returns " + result);
        
        result = sliceString("abcdefghijklm", 4, 5);
        System.out.println("expected result = 'ej'. returns " + result);
    }
    
}
