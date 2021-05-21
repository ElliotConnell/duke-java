
/**
 * Write a description of CaesarBreaker here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CaesarBreaker {
    
    public int countLetters() {
        
        return 0;    
    }
    
    public int maxIndex(int[]  vals) {
        return 0;
        
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

}
