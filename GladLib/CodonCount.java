
/**
 * Write a description of CodonCount here.
 * 
 * Write a program to find out how many times each codon occurs in a strand of DNA based on reading frames. 
 * A strand of DNA is made up of the symbols C, G, T, and A. A codon is three consecutive symbols in a strand
 * of DNA such as ATT or TCC. A reading frame is a way of dividing a strand of DNA into consecutive codons. 
 * Consider the following strand of DNA = “CGTTCAAGTTCAA”.

 * There are three reading frames. 

 * The first reading frame starts at position 0 and has the codons: “CGT”, “TCA”, “AGT” and “TCA”. 
 * Here TCA occurs twice and the others each occur once.
 * 
 * The second reading frame starts at position 1 (ignoring the first C character) and has the codons:
 * “GTT”, “CAA”, “GTT”, “CAA”. Here both GTT and CAA occur twice.
 * 
 * The third reading frame starts at position 2 (ignoring the first two characters CG) and has the codons : 
 * “TTC”, “AAG”, “TTC”. Here TTC occurs twice and AAG occurs once.
 * 
 * A map of DNA codons to the number times each codon appears in a reading frame would be helpful in solving this problem.
 * 
 * @author: Elliot Connell
 * 
 * @version: 31/05/21
 */

import edu.duke.*;
import java.util.*;

public class CodonCount {
    
    private HashMap<String, Integer> myCodon;
    
    public CodonCount() {
        myCodon = new HashMap<String, Integer>();
    }
    

}
