
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;


public class Part1 {
    
    public int findStopCodon (String dna, int startIndex, String stopCodon) {
        int currIndex = dna.indexOf(stopCodon, startIndex+3);
        while (currIndex != -1) {
            int diff = currIndex - startIndex;
            if (diff % 3 == 0) {
                return currIndex;
            }
            else {
                currIndex = dna.indexOf(stopCodon, currIndex +1);
            }
            
        }
        return dna.length();
    }
    
    
    public String findGene (String dna, int startIndex) {
        startIndex = dna.indexOf("ATG");
        if (startIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, startIndex, "TAA");
        int tagIndex = findStopCodon(dna, startIndex, "TAG");
        int tgaIndex = findStopCodon(dna, startIndex, "TGA");
        //int temp = Math.min(taaIndex, tagIndex);
        int minIndex = 0;
        if (taaIndex == -1 || (tgaIndex != -1 && tgaIndex < taaIndex)){
            minIndex = tgaIndex;
        }
        else {
            minIndex = taaIndex;
        }
        
        if (minIndex == -1 || (tagIndex != -1 && tagIndex < minIndex)) {
            minIndex = tagIndex;
        }
        
        if (minIndex == -1) {
            return "";
        }
           
        
        return dna.substring(startIndex, minIndex + 3);
    }
    
    public void testFindStopCodon(){
        
        String dna = "xxxyyyzzzTAAxxxyyyzzzTAAxx";
        int dex = findStopCodon(dna, 0, "TAA");
        if (dex !=9) System.out.println("error on 9");
        dex = findStopCodon(dna, 9, "TAA");
        if (dex !=21) System.out.println("error on 21");
        dex = findStopCodon(dna, 1, "TAA");
        if (dex !=26) System.out.println("error on 26");
        dex = findStopCodon(dna, 0, "TAG");
        if (dex !=26) System.out.println("error on 26 TAG");
        dex = findStopCodon(dna, 0, "TAG");
        System.out.println("tests finished");
        
    }
    
    public void testFindGene() {
        String dna = "ATGCCCGGGAAATAACCC";
        String gene = findGene(dna, 0);
        if (! gene.equals("ATGCCCGGGAAATAA")) {
            System.out.println("error");
        }
        
        System.out.println("tests finished");
    }
    
    public void printAllGenes() {
        int startIndex = 0;
        String dna = "ATGATCTAATTTATGCTGCAACGGTGAAGA";
        
        while (true) {
            String currentGene = findGene(dna, 0);
            
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
        }
    }
    
    public StorageResource getAllGenes(String dna, int startIndex) {
        // create an empty StorageResource, call it geneList
        StorageResource geneList = new  StorageResource();
        
        startIndex = 0;
        
        while (true) {
            String gene = findGene(dna, startIndex);
            
            if (gene.isEmpty()) {
                break;
            }
            
            // add gene to genelist
            geneList.add(gene);
            
            // Set startIndex to just past the end of currentgene
            startIndex = dna.indexOf(gene, startIndex)+ gene.length();
            
        }
        return geneList;
    }
    
    public void testOn (String dna) {

        System.out.println("Testing getAllGenes on " + dna);
        StorageResource genes = getAllGenes(dna, 0);
        for (String g: genes.data()) {
            System.out.println(g);
        }
        
    }
    
    public void test() {
        testOn("ATGATCTAATTTATGCTGCAACGGTGAAGA");
        testOn("");
        testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
    }
    
    
    public float cgRatio(String dna) {
        int count = 0;
        int length = dna.length();
        int indexC = dna.indexOf("C");
        int indexG = dna.indexOf("G");

        
                
        while(true) {
            //count = count + 1;
            //currentIndexg++;
            //indexg = dna.indexOf("G", currentIndexg);
            if (indexC <= length || indexG <= length) {
                count = count += 1; 
            }
            
            indexC = dna.indexOf("C", indexC+1);
            indexG = dna.indexOf("G", indexG+1);
            
            //return count; 
        }
        
        //float cg = (float)count/dna.length();
        
        return count;       
    }
    
    public void testCg() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna1 = fr.asString();
        
        
        float result = cgRatio(dna1);
        System.out.println("cgRatio = " + result);
        
        cgRatio("ATGCCATAG");
        System.out.println("cgRatio = " + result);
        
    }
    
    public int countCGT (String dna) {
        int count = 0;
        int pos = dna.indexOf("CGT");
        while(pos !=-1 && pos<dna.length()) {
            count += 1;
            pos=dna.indexOf("CGT", pos+3);
        }
        return count;
    }
    
    public void testCount() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna1 = fr.asString();
        dna1 = dna1.toUpperCase();
        
        float result = countCGT(dna1);
        System.out.println("Count of Codon = " + result);
        result = countCGT("");
        
    }
}
    

