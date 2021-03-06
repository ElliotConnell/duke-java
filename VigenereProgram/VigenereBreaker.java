import java.util.*;
import edu.duke.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slicedString = new StringBuilder();
        
        for (int index = whichSlice; index < message.length(); index += totalSlices){
            slicedString.append(message.charAt(index));
        }
        return slicedString.toString();
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
        

        HashMap<String, HashSet<String>> languages = new HashMap <String, HashSet<String>>();
        DirectoryResource dr = new DirectoryResource();
        
        for (File dictFile: dr.selectedFiles()){
            FileResource fr = new FileResource(dictFile.getAbsoluteFile()); 
            HashSet<String> dictionary = readDictionary(fr);
            languages.put(dictFile.getName(), dictionary);
        }
        
        FileResource sc = new FileResource();
        String message = sc.asString();
        breakForAllLanguages(message, languages);       
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
        int finalKLength = 0;
        char mostCommonChar = mostCommonCharIn(dictionary);
        
        for (int klength = 1; klength <=100; klength++){
            int[] key = tryKeyLength(encrypted, klength, mostCommonChar);
            VigenereCipher vc = new VigenereCipher(key);
            String decrypted = vc.decrypt(encrypted);
            int validWords = countWords(decrypted, dictionary);
            
            if (validWords > highestWordCount){
                highestWordCount = validWords;
                result = decrypted;
                finalKLength = klength;
            }
            
        }
        
        //System.out.println(highestWordCount);
        //System.out.println(finalKLength);
        
        return result;
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary){
        char mostCommonCharIn = Character.MIN_VALUE;
        
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        
        for (String word: dictionary){
            for(int i=0; i<word.length(); i++){
                int index = alphabet.indexOf(Character.toLowerCase(word.charAt(i)));
                if (index != -1){
                    counts[index] += 1;
                }
            }
        }
        int maxIndex = 0;
        
        for (int i=0; i<counts.length; i++){
            if(counts[i] > counts[maxIndex]){
                maxIndex = i;
            }
        }
        return alphabet.charAt(maxIndex);
    }
    
    public void breakForAllLanguages(String encrypted, HashMap<String, HashSet <String>> languages){
        String resultLanguage = "";
        String resultDecryption = "";
        int counter = 0;
        
        for (String s: languages.keySet()){
            HashSet<String> currDict = languages.get(s);
            char currMostCommon = mostCommonCharIn(currDict);
            String currDecryption = breakForLanguage(encrypted, currDict);
            int currCounts = countWords(currDecryption, currDict);
            
            if (currCounts > counter){
                counter = currCounts;
                resultDecryption = currDecryption;
                resultLanguage = s;
            }
        }
        
        System.out.println("language = " + resultLanguage);
        System.out.println(resultDecryption);
    }
    
}
