
/**
 * Class to test dna strings for genes
 * 
 * @author Elliot Connell
 * @version 6/4/21
 */
public class Part1 {
    
    public String findSimpleString(String dna) {
        // start codon is "ATG"
        // stop codon is "TAA"
        String result = "";
        int startIndex = dna.indexOf("ATG");
        if (startIndex == -1) // no ATG
        {
            return "";
        }
        int stopIndex = dna.indexOf("TAA", startIndex+3);
        if (stopIndex == -1) { // no TAA
            return "";
        }
        result = dna.substring(startIndex, stopIndex+3);
        if (result.length() % 3 == 0){
            return "";
        }
        
        return result;
    }



    public void testFindSimpleString() {
        //dna with no atg
        String dna = "AATTCGTAATAGGT";
        System.out.println("DNA strand is " + dna);
        String gene = findSimpleString(dna);
        System.out.println("Gene is " + gene);
        
        //dna with no taa
        dna = "AATGCTAGGGTATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna);
        System.out.println("Gene is " + gene);
        
        //dna with no atg or taa
        dna = "ATCCTAGCTTCGGCTGCTCTGAATAGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna);
        System.out.println("Gene is " + gene);
        
        //DNA with atg, taa and the substring between them is a multiple of 3
        dna = "AATGCGTATTTAATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna);
        System.out.println("Gene is " + gene);
        
        //DNA with atg, taa and the substring between them is not a multiple of 3
        dna = "AATGCGTAATATGGT";
        System.out.println("DNA strand is " + dna);
        gene = findSimpleString(dna);
        System.out.println("Gene is " + gene);
        
    }
    

}

