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
        FileResource dict = new FileResource("dictionaries/English");
        
        HashSet<String> dictionary = readDictionary(dict);
       
        
        String message = fr.asString();
        String decrypted = breakForLanguage(message, dictionary);
        System.out.println(decrypted);       
    }
    
    public HashSet<String> readDictionary(FileResource fr){
        HashSet<String> dictionary = new HashSet();
        
        for (String line: fr.lines()){
            dictionary.add(line.toLowerCase());
        }
        
        return dictionary;
    }
    
    public int countWords(String message, HashSet<String> dictionary){
        String[] words = message.split("\\W+");
        int counter = 0;
        
        for (int index = 0; index < words.length; index++){
            String word = words[index].toLowerCase();
            if(dictionary.contains(word)){
                counter += 1;
            }
            
        }
        return counter;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary){
        int highestWordCount = 0;
        String result = "";
        
        
        for (int klength = 1; klength <=100; klength++){
            int[] key = tryKeyLength(encrypted, klength, 'e');
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int validWords = countWords(decrypted, dictionary);
            
            if (validWords > highestWordCount){
                highestWordCount = validWords;
                result = decrypted;
            }
            
        }
        
        
        return result;
    }
    
    
}
