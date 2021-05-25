
/**
 * Write a description of CaesarCipher here.
 * In this assignment, you will put together the CaesarCipher class from the lesson and add a decrypt method 
 * to decrypt with the same key. In addition you will create a second class, TestCaesarCipher to test examples 
 * that use the CaesarCipher class, including writing a method that will automatically decrypt an encrypted 
 * file by determining the key and then decrypting with that key.
 * 
 * @author: Elliot Connell
 * @version 24/05/21
 */
public class CaesarCipher {
    
    // private fields for the alphabet and shiftedAlphabet
    private String alphabet;
    private String shiftedAlphabet;
    private int mainKey;
    
    //write a constructor CaesarCipher that has one int parameter key. this method should 
    //initialise all the private fields of the class
    public CaesarCipher(int key) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet = alphabet.substring(key) + alphabet.substring(0, key);
        mainKey = key;
    }
    
    public String encrypt(String input) {
        StringBuilder sb = new StringBuilder(input);
        for (int i=0; i<sb.length(); i++) {
            char c = sb.charAt(i);
            char cUpper = Character.toUpperCase(c);
            int idx = alphabet.indexOf(cUpper);
            if (idx != -1) {
                char charNew = shiftedAlphabet.charAt(idx);
                if (Character.isUpperCase(c) == true) {
                    sb.setCharAt(i, charNew);
                }
                else {
                    charNew = Character.toLowerCase(charNew);
                    sb.setCharAt(i, charNew);
                }
                
            } 
        }
        return sb.toString();
    }
    

    
    public String decrypt(String input) {
        CaesarCipher cc = new CaesarCipher(26 - mainKey);
        return cc.encrypt(input);
    }

}
