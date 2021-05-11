
/**
 * Write a description of Part1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import edu.duke.*;


public class Part1 {
    
    public int findStopCodon (String dnaStr, int newIndex, String stopCodon) {
        int currIndex = dnaStr.indexOf(stopCodon, newIndex+3);
        while (currIndex != -1) {
            int diff = currIndex - newIndex;
            if (diff % 3 == 0) {
                return currIndex;
            }
            else {
                currIndex = dnaStr.indexOf(stopCodon, currIndex +3);
            }
            
        }
        return dnaStr.length();
    }
    
    
    public String findGene (String dna, int startIndex) {
        dna = dna.toUpperCase();
        int firstIndex = dna.indexOf("ATG", startIndex);
        int strandLength = dna.length();     
        
        if (firstIndex == -1) {
            return "";
        }
        int taaIndex = findStopCodon(dna, firstIndex, "TAA");
        int tagIndex = findStopCodon(dna, firstIndex, "TAG");
        int tgaIndex = findStopCodon(dna, firstIndex, "TGA");
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
        
        if (minIndex == strandLength){
            //startIndex = startIndex + 1;
            return "";
        }
        
    
        String gene = dna.substring(firstIndex, minIndex + 3);
        int length = gene.length();
        firstIndex = firstIndex + length ;
     
        return gene;
        
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
        
        System.out.println("tests finished");
        
    }
    
    public void testFindGene() {
        String dna = "ATGCCCGGGAAATGAGCCC";
        String gene = findGene(dna, 0);
        
        System.out.println(gene);
        if (! gene.equals("ATGCCCGGGAAATGA")) {
            System.out.println("error");
        }
        
        System.out.println("tests finished");
    }
    
    public void printAllGenes(String dna) {
        dna = dna.toUpperCase();
        int startIndex = 0;
        
        
        while (true) {
            
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty()) {
                break;
            }
            
                       
            
            int length = currentGene.length();
            
            startIndex = dna.indexOf(currentGene, startIndex)  + length;
            System.out.println(currentGene);
            
            
        }
    }
    
    public StorageResource getAllGenes(String dna) {
        // create an empty StorageResource, call it geneList
        StorageResource geneList = new  StorageResource();
        dna = dna.toUpperCase();
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty()) {
                break;
            }
            
            // add gene to genelist
            geneList.add(currentGene);
            
            // Set startIndex to just past the end of currentgene
            startIndex = (dna.indexOf(currentGene, startIndex) + currentGene.length());
            
        }
        return geneList;
    }
    
    public void testOn (String dna) {

        System.out.println("Testing getAllGenes on brca1line.fa");
        //printAllGenes(dna);
        StorageResource genes = getAllGenes(dna);
        int count = 0;
        for (String g: genes.data()) {
           System.out.println(g);
           count += 1;
        }
        
        System.out.println(count);
    }
    
    public void test() {
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna2 = fr.asString();
        
        testOn(dna2);
        //testOn("");
        //testOn("ATGATCATAAGAAGATAATAGAGGGCCATGTAA");
        //testOn("nonCodingDNAxxxMyGeneATGmyGenexTAAxxGeneATGTAACATGTAAATGCendTAATAAnonCodingDNAxTAGxTGA");
        //testOn("oneAtGMyGeneOneAATGGGGTAATGATAGAACCCGGYGGGGTAGGGCTGCCCATGendOneTAAnonCodingDnaTAGTGAZZZtaaTwoATGMyGeneTwoCATGGGGTAATGATAGCCatgCCCFalseStartTAATGATGendTwoTAGnonCodingDNATAACCCThreeATGMyGeneThreeATGGGGTAATGATAGATGccendThreeTAAnonCodingDNAccTAAfalsecccFourATGMyGeneFourATGGGGTAATGATAGCendFourTAGnonCodingdnaFiveAtgMyGeneFiveATGGGGTAATGATAGCendFiveTGAnonCodingdnaSixATGmyGeneSixATATGGGGTAATGATAGAendSixTAAnoncodingdnaSevenATGMyGeneSevenCcATGGGGTAATGATAGendSeventaAnoncodingdnaEightATGmyGeneEightATGGGGTAATGATAGGGendEighttaAnoncodingdnaCcccWrongtgaCtaaCtagCCcgNineATgmyGeneNineATGGGGTAATGATAGTaaAendNineTAAnonCodingDnaCcccTenATGmyGeneTenGATGGGGTAATGATAGCCHasFakeATGFAKEatgcendTentaanonCodingDnaCtagCtganonCodingDnaxxxElevenATGmyGeneElevenCATGGGGTAATGATAGTAAxxGeneATGTAACATGTAAATGCendElevenTAAnonCodingDnaxTAGxtgaTwelveATGmyGeneTwelveCATGGGGTAATGATAGCTheLastGeneIsATGTAGendTwelvetgaATGTAG");
        
    }
    
    
    public float cgRatio(String dna) {
        int count = 0;
        int length = dna.length();
                        
        for (int i=0; i < length; i++) {
            String value = String.valueOf(dna.charAt(i));
            
            if (value.compareToIgnoreCase("C") == 0 || value.compareToIgnoreCase("G") == 0){
                count +=1;
                
            }
        }

                      
              
        float cg = (float)count/dna.length();
        
        return cg;       
    }
    
    public void testCg() {
        FileResource fr = new FileResource("brca1line.fa");
        String dna1 = fr.asString();
        
        
        float result = cgRatio(dna1);
        System.out.println("cgRatio = " + result);
        
        result = cgRatio("ATGCCATAG");
        System.out.println("cgRatio = " + result);
        
    }
    
    public int countCGT (String dna) {
        int count = 0;
        int pos = dna.indexOf("CTG");
        while(pos !=-1 && pos<dna.length()) {
            count += 1;
            pos=dna.indexOf("CTG", pos+3);
        }
        return count;
    }
    
    public void testCount() {
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna1 = fr.asString();
        dna1 = dna1.toUpperCase();
        
        float result = countCGT(dna1);
        System.out.println("Count of Codon = " + result);
        result = countCGT("");
        
    }
    
    public void processGenes(String sr) {
        StorageResource genes = getAllGenes(sr);
        // print all strings in sr that are longer than 9 characters
        int count = 0;
        for (String g: genes.data()) {
            
            if (g.length() > 60) {
                System.out.println(g);
                count += 1;
            }
            
        }
        //print the number of Strings in sr that longer than 9 characters
        System.out.println("No. of strings longer than 60 characters = " + count);
        
        //print the strings in sr whose C-G ratio is higher than 0.35
        int cgCount = 0;
        for (String g: genes.data()) {
            float cgRatio = cgRatio(g);
            if (cgRatio > 0.35) {
                System.out.println(g);
                cgCount += 1;
            }
            
        }
                
        // print the number of strings in sr whose cg ratio is higher than 0.35
        System.out.println("No. of strings with cgRatios higher than 0.35 = " + cgCount);
        // print the length of the longest gene in sr
        String longestGene = "";
        for (String g: genes.data()) {
            if (longestGene == "") {
                longestGene = g;
            }
            
            if (longestGene.length() < g.length()) {
                longestGene = g;
            }
            
        }
        
        System.out.println("longest gene = ");
        System.out.println(longestGene);
        System.out.println(longestGene.length());
    }
    
    public void testProcessGenes() {
        FileResource fr = new FileResource("GRch38dnapart.fa");
        String dna = fr.asString();
        processGenes(dna);
        
    }
}
    


    

