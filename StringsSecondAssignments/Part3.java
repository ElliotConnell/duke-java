
/**
 * How many Genes?.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Part3 {
    
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
    
    public String findGene (String dna, int start) {
        int startIndex = dna.indexOf("ATG");
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
    
       
    public void printAllGenes(String dna) {
        int startIndex = 0;
        
        while (true) {
            String currentGene = findGene(dna, startIndex);
            
            if (currentGene.isEmpty()) {
                break;
            }
            System.out.println(currentGene);
        }
    }
    
    public void findGenetest() {
       String dna;
       
       dna="ATGTRFTAAFTRATGAG";
       String Genegot=findGene(dna,0);
       System.out.println(dna);
       System.out.println("answer should be ATGTRFTAA");
       System.out.println(Genegot);
       
       dna= "RATGAFTTAAFTRATG";
       Genegot=findGene(dna,0);
       System.out.println(dna);
       System.out.println("answer should be ATGAFTTAA");
       System.out.println(Genegot);
       
       dna= "RATGTRFFTAAFTRATGTAG";
       Genegot=findGene(dna,0);
       System.out.println(dna);
       System.out.println("answer should be ATGTAG");
       System.out.println(Genegot);
       
       dna= "RATGTTAARFTAAFTRATGTAGERE";
       Genegot=findGene(dna,0);
       System.out.println(dna);
       System.out.println("answer should be ATGTTAARFTAA");
       System.out.println(Genegot);
       
       dna= "ATGTRRFTAAFTRTAGAVG";
       Genegot=findGene(dna,0);
       System.out.println(dna);
       System.out.println("answer should be No Gene");
       System.out.println(Genegot);
       
       dna= "TAARTGATGTGAAV";
       Genegot=findGene(dna,0);
       System.out.println(dna);
       System.out.println("answer should be ATGTGA");
       System.out.println(Genegot);
     
    }

}
