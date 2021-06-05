
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
    
    private void buildCodonMap(int start, String dna) {
        myCodon.clear();
        
        for (int i = start; i < dna.length() - 3; i += 3) {
            String codon = dna.substring(i, i + 3);
            if (!myCodon.containsKey(codon)) {
                myCodon.put(codon, 1);
            }
            else {
                myCodon.put(codon, myCodon.get(codon) + 1);
            }
        }
        
    }
    
    private String getMostCommonCodon() {
        int maxCount = 0;
        String mostCommon = "";
        
        for (String s: myCodon.keySet()) {
            int currCount = myCodon.get(s);
            if (currCount > maxCount){
                mostCommon = s;
                maxCount = currCount;
            }
        }
        
        System.out.println(mostCommon + maxCount);
        return mostCommon;
    }
    
    public void printCodonCounts(int start, int end) {
        for (String s: myCodon.keySet()){
            int count = myCodon.get(s);
            if (count <= end && count >= start) {
                System.out.println(s + "\t+" + myCodon.get(s));
            }
        }
    }
    
    
    public void tester() {
        FileResource fr = new FileResource();
        String dna = fr.asString();
        dna = dna.toUpperCase();
        
        for (int i = 0; i <= 2; i++){
            buildCodonMap(i, dna);
            System.out.println("counting frame " + i + " has " + myCodon.size());
            String result = getMostCommonCodon();
            System.out.println("most common codon = " + result);
            printCodonCounts(1, 438);
        }
    }

}
