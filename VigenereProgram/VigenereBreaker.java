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
        
        for (int i = 0;  i < klength; i++){
            CaesarCracker cc = new CaesarCracker(mostCommon);
            String slice = sliceString(encrypted, i, klength);
            int slicedKey = cc.getKey(slice);
            key[i] = slicedKey;
        }
        
        return key;
    }

    public void breakVigenere () {
        FileResource fr = new FileResource();
        String message = fr.asString();
        int[] key = tryKeyLength(message, 4, 'e');
        VigenereCipher vc = new VigenereCipher(key);
        String decrypted = vc.decrypt(message);
        System.out.println(decrypted);       
    }
    
}
