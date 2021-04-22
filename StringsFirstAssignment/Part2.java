
/**
 * Class to test dna strings for genes
 * 
 * @author Elliot Connell
 * @version 6/4/21
 */
public class Part2 {
    
    public String findSimpleString(String dna, String startCodon, String stopCodon) {
        // start codon is "ATG"
        // stop codon is "TAA"
        dna = dna.toUpperCase();
        startCodon = startCodon.toUpperCase();
        stopCodon = stopCodon.toUpperCase();
        
        
        String result = "";
        int startIndex = dna.indexOf(startCodon);
        if (startIndex == -1) // no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf(stopCodon, startIndex +3);
        if (stopIndex == -1) { // no TAA
            return "";
        }
        result = dna.substring(startIndex, stopIndex+3);
        if (result.length() % 3 != 0){
            return "";
        }
        
        return result;
    }



    public void testFindSimpleString() {
        //dna with no atg
        String dna = "AATTCGTAATAGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleString(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        //dna with no taa
        dna = "AATGCTAGGGTATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        //dna with no atg or taa
        dna = "ATCCTAGCTTCGGCTGCTCTGAATAGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        //DNA with atg, taa and the substring between them is a multiple of 3
        dna = "AATGCGTATTTAATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        //DNA with atg, taa and the substring between them is not a multiple of 3
        dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna, "ATG", "TAA");
        System.out.println("Gene is " + gene);
        
        //lowercase
        dna = "aatgcgtatttaatggt";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna, "atg", "taa");
        System.out.println("Gene is " + gene);
    }
    

}

