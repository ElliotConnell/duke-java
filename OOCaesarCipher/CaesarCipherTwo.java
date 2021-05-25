
/**
 * Write a description of CaesarCipherTwo here.
 * In this assignment, you will put together the CaesarCipherTwo class that encrypts a message with two keys 
 * (the same way as the previous lesson: key1 is used to encrypt every other letter, starting with the first, 
 * and key2 is used to encrypt every other letter, starting with the second), and also decrypts the same message. 
 * In addition you will create a second class, TestCaesarCipherTwo to test examples that use the CaesarCipherTwo 
 * class, including writing a method that will automatically decrypt an encrypted file by determining the two keys
 * that were used to encrypt it. 
 * 
 * @author (Elliot Connell) 
 * @version (25/05/21)
 */
public class CaesarCipherTwo {
    
    private String alphabet;
    private String shiftedAlphabet1;
    private String shiftedAlphabet2;
    //private int mainKey1;
    //private int mainKey1;
    
    public CaesarCipherTwo(int key1, int key2) {
        alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        shiftedAlphabet1 = alphabet.substring(key1) + alphabet.substring(0, key1);
        shiftedAlphabet2 = alphabet.substring(key2) + alphabet.substring(0, key2);
        //mainKey1 = key1;
        //mainKey2 = key2;
    }

}
