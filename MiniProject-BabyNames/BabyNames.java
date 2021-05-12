
/**
 * Write a description of BabyNames here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import org.apache.commons.csv.*;
import java.io.*;
import java.lang.*;

public class BabyNames {
    
    public void totalBirths (FileResource fr) {
        int totalBirths = 0;
        int totalBoys = 0;
        int totalGirls = 0;
        
        for (CSVRecord rec : fr.getCSVParser(false)) {
            int numBorn = Integer.parseInt(rec.get(2));
            totalBirths += numBorn;
            if (rec.get(1).equals("M")) {
                totalBoys += numBorn;
            }
            else {
                totalGirls += numBorn;
            }
        }
        System.out.println("total births = " + totalBirths);
        System.out.println("total boys = " + totalBoys);
        System.out.println("total girls = " + totalGirls);
        
    }
    
    public void testTotalBirths() {
        FileResource fr = new FileResource("testing/yob2014short.csv");
        totalBirths(fr);
    }
    
    public int getRank(int year, String name, String gender) {
        // set fileresource with file from year givin
        FileResource fr = new FileResource("testing/yob" + year + "short.csv");
        // set rank counter
        int rank = 0;
        boolean found = false;
        
        // loop through lines of csv
        for (CSVRecord rec : fr.getCSVParser(false)) {
            String recName = rec.get(0);
            String recGen = rec.get(1);
            
            if (recGen.equals(gender)) {
                rank += 1;
                if (recName.equals(name)) {
                    found = true;
                    break;
                }
            }
        }
        if (found == false) {
            return -1;
        }
            
                
        
        return rank;
    }
    
    public void testGetRank() {
        
        int result = getRank(2014, "Sophia", "F");
        System.out.println("names rank = " + result);
        
        result = getRank(2014, "Noah", "M");
        System.out.println("names rank = " + result);
        
        result = getRank(2014, "Noah", "F");
        System.out.println("names rank = " + result);
    }

}
