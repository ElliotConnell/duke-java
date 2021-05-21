
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
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
        
        int[] counts = countLetters(s);
        int index = maxIndex(counts);
        
        return index;
    }

}
